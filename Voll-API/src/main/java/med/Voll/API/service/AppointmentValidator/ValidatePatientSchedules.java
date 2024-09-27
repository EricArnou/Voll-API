package med.Voll.API.service.AppointmentValidator;

import med.Voll.API.domain.appointment.AppointmentRepository;
import med.Voll.API.domain.appointment.RegisterAppointmentDto;
import med.Voll.API.domain.patient.PatientRepository;
import med.Voll.API.infra.exceptions.ErrorMessage;
import med.Voll.API.infra.exceptions.VollMedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatePatientSchedules implements AppointmentValidatorInterface {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    PatientRepository patientRepository;

    @Override
    public void validate(RegisterAppointmentDto registerAppointmentDto) {
        var patient = patientRepository.getReferenceById(registerAppointmentDto.idPatient());
        var firstSchedule = registerAppointmentDto.schedule().withHour(7);
        var lastSchedule = registerAppointmentDto.schedule().withHour(18);
        var appointmeant = appointmentRepository.existsByPatientAndScheduleBetween(patient, firstSchedule, lastSchedule);

        if (appointmeant)
            throw new VollMedException(ErrorMessage.PATIENT_ALREADY_HAS_AN_APPOINTMENT);
    }
}
