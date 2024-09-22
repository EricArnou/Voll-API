package med.Voll.API.domain.patient;

public record ReturnPatientDto(Long id, String name, String email, String cpf){

    public ReturnPatientDto(Patient patient){
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf());
    }
}
