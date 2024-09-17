package med.Voll.API.model.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String place;
    private String neighborhood;
    private String cep;
    private String state;
    private String city;
    private String complement;
    private String number;

    public Address(AddressDto addressDto) {
        this.place = addressDto.place();
        this.neighborhood = addressDto.neighborhood();
        this.cep = addressDto.cep();
        this.state = addressDto.state();
        this.city = addressDto.city();
        this.complement = addressDto.complement();
        this.number = addressDto.number();
    }
}
