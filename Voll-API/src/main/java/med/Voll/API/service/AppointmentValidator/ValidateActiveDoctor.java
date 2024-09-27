package med.Voll.API.service.AppointmentValidator;

import med.Voll.API.domain.appointment.RegisterAppointmentDto;
import med.Voll.API.domain.doctor.DoctorRepository;
import med.Voll.API.infra.exceptions.ErrorMessage;
import med.Voll.API.infra.exceptions.VollMedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateActiveDoctor implements AppointmentValidatorInterface {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public void validate(RegisterAppointmentDto registerAppointmentDto) {
        if(registerAppointmentDto.idDoctor() != null) {
            var doctor = doctorRepository.getReferenceById(registerAppointmentDto.idDoctor());
            if (!doctor.isActive())
                throw new VollMedException(ErrorMessage.DOCTOR_IS_NOT_ACTIVE);
        }
    }
}
