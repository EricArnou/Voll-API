package med.Voll.API.domain.patient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.Voll.API.domain.address.Address;

@Entity
@Table(name = "patients")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String cpf;
    private boolean active;

    @Embedded
    private Address address;

    public Patient(RegisterPatientDto registerPatientDto){
        this.name = registerPatientDto.name();
        this.cpf = registerPatientDto.cpf();
        this.email = registerPatientDto.email();
        this.phone = registerPatientDto.phone();
        this.address = new Address(registerPatientDto.address());
        this.active = true;
    }

    public void updateInformation(UpdatePatientDto updatePatientDto) {
        if(updatePatientDto.name() != null) this.name = updatePatientDto.name();
        if(updatePatientDto.phone() != null) this.phone = updatePatientDto.phone();
        if(updatePatientDto.address() != null) this.address = new Address(updatePatientDto.address());
    }

    public void disablePatient() {
        this.active = false;
    }
}
