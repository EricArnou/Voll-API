package med.Voll.API.model.doctor;

import med.Voll.API.model.address.AddressDto;

public record RegisterDoctorDto(String name, String email, String crm, Specialty specialty, AddressDto address) {
}
