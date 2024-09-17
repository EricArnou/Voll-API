package med.Voll.API.model.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.Voll.API.model.address.Address;

@Table(name = "doctors")
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    public Doctor(RegisterDoctorDto registerDoctorDto){
        this.name = registerDoctorDto.name();
        this.crm = registerDoctorDto.crm();
        this.email = registerDoctorDto.email();
        this.specialty = registerDoctorDto.specialty();
        this.address = new Address(registerDoctorDto.address());
    }
}
