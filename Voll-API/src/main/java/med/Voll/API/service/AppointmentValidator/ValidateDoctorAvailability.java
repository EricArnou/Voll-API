package med.Voll.API.service.AppointmentValidator;

import med.Voll.API.domain.appointment.AppointmentRepository;
import med.Voll.API.domain.appointment.RegisterAppointmentDto;
import med.Voll.API.domain.doctor.DoctorRepository;
import med.Voll.API.infra.exceptions.ErrorMessage;
import med.Voll.API.infra.exceptions.VollMedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateDoctorAvailability implements AppointmentValidatorInterface{

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public void validate(RegisterAppointmentDto appointmentDto) {
        if(appointmentDto.idDoctor() != null) {
            var doctor = doctorRepository.getReferenceById(appointmentDto.idDoctor());
            var schedule = appointmentDto.schedule();
            var appointment = appointmentRepository.existsByDoctorAndSchedule(doctor, schedule);

            if (appointment)
                throw new VollMedException(ErrorMessage.DOCTOR_NOT_AVAILABLE);
        }
    }
}
