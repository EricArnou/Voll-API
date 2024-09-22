package med.Voll.API.domain.patient;

import med.Voll.API.domain.address.Address;

public record ReturnUpdatePatientDto(Long id, String name, String email, String phone, String cpf, Address address) {

    public ReturnUpdatePatientDto(Patient patient){
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getPhone(), patient.getCpf(), patient.getAddress());
    }
}
