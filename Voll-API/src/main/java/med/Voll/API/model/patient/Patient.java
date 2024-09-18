package med.Voll.API.model.patient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.Voll.API.model.address.Address;

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

    @Embedded
    private Address address;

    public Patient(RegisterPatientDto registerPatientDto){
        this.name = registerPatientDto.name();
        this.cpf = registerPatientDto.cpf();
        this.email = registerPatientDto.email();
        this.phone = registerPatientDto.phone();
        this.address = new Address(registerPatientDto.address());
    }
}
