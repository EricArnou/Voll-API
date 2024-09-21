package med.Voll.API.patient;

import med.Voll.API.model.address.Address;
import med.Voll.API.model.patient.Patient;

public record ReturnUpdatePatientDto(Long id, String name, String email, String phone, String cpf, Address address) {

    public ReturnUpdatePatientDto(Patient patient){
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getPhone(), patient.getCpf(), patient.getAddress());
    }
}
