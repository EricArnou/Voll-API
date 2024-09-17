package med.Voll.API.model.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.Voll.API.model.address.AddressDto;

public record RegisterDoctorDto(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Specialty specialty,
        @NotBlank
        String phone,
        @NotNull
        @Valid
        AddressDto address) {
}
