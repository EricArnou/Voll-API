package med.Voll.API.service.AppointmentValidator;

import med.Voll.API.domain.appointment.RegisterAppointmentDto;
import med.Voll.API.infra.exceptions.ErrorMessage;
import med.Voll.API.infra.exceptions.VollMedException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidateWithinClinicOpeningHours implements AppointmentValidatorInterface{

    @Override
    public void validate(RegisterAppointmentDto appointmentDto) {
        var checkDayOfWeek = appointmentDto.schedule().getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var checkHourBefore = appointmentDto.schedule().getHour() < 7;
        var checkHourAfter = appointmentDto.schedule().getHour() > 18;

        if(checkDayOfWeek || checkHourAfter || checkHourBefore)
            throw new VollMedException(ErrorMessage.CLINIC_DOES_NOT_OPEN);
    }
}
