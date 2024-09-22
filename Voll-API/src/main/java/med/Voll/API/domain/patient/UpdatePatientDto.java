package med.Voll.API.domain.patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.Voll.API.domain.address.AddressDto;

public record UpdatePatientDto(
        @NotNull
        Long id,
        String name,
        String phone,
        @Valid
        AddressDto address) {
}
