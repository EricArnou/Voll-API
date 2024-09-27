package med.Voll.API.service;

import med.Voll.API.domain.appointment.Appointment;
import med.Voll.API.domain.appointment.AppointmentRepository;
import med.Voll.API.domain.appointment.RegisterAppointmentDto;
import med.Voll.API.domain.appointment.ReturnAppointmentDto;
import med.Voll.API.domain.doctor.Doctor;
import med.Voll.API.domain.doctor.DoctorRepository;
import med.Voll.API.domain.patient.PatientRepository;
import med.Voll.API.infra.exceptions.ErrorMessage;
import med.Voll.API.infra.exceptions.VollMedException;
import med.Voll.API.service.AppointmentValidator.AppointmentValidatorInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    List<AppointmentValidatorInterface> validators;

    public ResponseEntity scheduleAnAppointment(RegisterAppointmentDto appointmentDto){
        if(!patientRepository.existsById(appointmentDto.idPatient()))
            throw new VollMedException(ErrorMessage.PATIENT_NOT_FOUND);

        if (appointmentDto.idDoctor() != null && !doctorRepository.existsById(appointmentDto.idDoctor()))
            throw new VollMedException(ErrorMessage.DOCTOR_NOT_FOUND);

        validators.forEach(v -> v.validate(appointmentDto));

        var patient = patientRepository.getReferenceById(appointmentDto.idPatient());
        var doctor= chooseDoctor(appointmentDto);

        if(doctor == null)
            throw new VollMedException(ErrorMessage.DOCTOR_NOT_AVAILABLE);

        var appointment = new Appointment(null, patient, doctor, appointmentDto.schedule());
        appointmentRepository.save(appointment);

        return ResponseEntity.ok(new ReturnAppointmentDto(appointment));
    }

    private Doctor chooseDoctor(RegisterAppointmentDto appointmentDto){
        if(appointmentDto.idDoctor() != null)
            return doctorRepository.getReferenceById(appointmentDto.idDoctor());
        if(appointmentDto.specialty() == null)
            throw new VollMedException(ErrorMessage.SPECIALTY_IS_REQUIRED);

        return doctorRepository.findBySpecialtyAndFreeSchedule(appointmentDto.specialty(), appointmentDto.schedule());
    }
}
