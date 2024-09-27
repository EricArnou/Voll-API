package med.Voll.API.service.AppointmentValidator;

import med.Voll.API.domain.appointment.RegisterAppointmentDto;
import med.Voll.API.infra.exceptions.ErrorMessage;
import med.Voll.API.infra.exceptions.VollMedException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidateScheduleInAdvance implements AppointmentValidatorInterface{

    @Override
    public void validate(RegisterAppointmentDto registerAppointmentDto) {
        var schedule = registerAppointmentDto.schedule();
        var now = LocalDateTime.now();
        var checkMinutesDifference = Duration.between(now, schedule).toMinutes();

        if(checkMinutesDifference < 30)
            throw new VollMedException(ErrorMessage.NO_ADVANCE_NOTICE_NECESSARY);
    }
}
