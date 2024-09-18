package med.Voll.API.model.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.Voll.API.model.address.AddressDto;

public record UpdateDoctorDto(
        @NotNull
        Long id,
        String name,
        String phone,
        @Valid
        AddressDto address
) {
}
