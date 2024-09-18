package med.Voll.API.model.patient;

import med.Voll.API.model.address.AddressDto;

public record RegisterPatientDto(
        String name,
        String email,
        String phone,
        String cpf,
        AddressDto address
) {
}
