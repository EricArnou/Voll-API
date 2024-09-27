package med.Voll.API.domain.appointment;

import java.time.LocalDateTime;

public record ReturnAppointmentDto(Long idDoctor, Long idPatient, LocalDateTime schedule) {

    public ReturnAppointmentDto(Appointment appointment){
        this(appointment.getDoctor().getId(), appointment.getPatient().getId(), appointment.getSchedule());
    }
}
