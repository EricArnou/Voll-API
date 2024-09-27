package med.Voll.API.service.AppointmentValidator;

import med.Voll.API.domain.appointment.RegisterAppointmentDto;

public interface AppointmentValidatorInterface {

    void validate(RegisterAppointmentDto registerAppointmentDto);
}
