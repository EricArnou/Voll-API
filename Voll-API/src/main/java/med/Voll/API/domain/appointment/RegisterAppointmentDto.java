package med.Voll.API.domain.appointment;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.Voll.API.domain.doctor.Specialty;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public record RegisterAppointmentDto(

        Long idDoctor,

        @NotNull
        Long idPatient,

        @Future
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime schedule,

        Specialty specialty) {
}
