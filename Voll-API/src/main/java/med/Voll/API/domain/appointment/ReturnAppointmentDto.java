package med.Voll.API.domain.appointment;

import java.time.LocalDateTime;

public record ReturnAppointmentDto(Long id, Long idDoctor, Long idPatient, LocalDateTime schedule) {

    public ReturnAppointmentDto(Appointment appointment){
        this(appointment.getId(),appointment.getDoctor().getId(), appointment.getPatient().getId(), appointment.getSchedule());
    }
}
