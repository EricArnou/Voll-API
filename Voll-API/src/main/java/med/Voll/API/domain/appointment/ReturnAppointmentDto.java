package med.Voll.API.domain.appointment;

import java.time.LocalDateTime;

public record ReturnAppointmentDto(Long idDoctor, Long idPatient, LocalDateTime schedule) {
}
