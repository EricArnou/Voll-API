package med.Voll.API.domain.appointment;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RegisterAppointmentDto(
        Long idDoctor,

        @NotNull
        Long idPatient,

        @Future
        LocalDateTime schedule) {
}
