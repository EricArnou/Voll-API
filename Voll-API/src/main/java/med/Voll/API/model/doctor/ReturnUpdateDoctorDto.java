package med.Voll.API.model.doctor;

import med.Voll.API.model.address.Address;

public record ReturnUpdateDoctorDto(Long id, String name, String email, String crm, String phone, Specialty specialty, Address address){

    public ReturnUpdateDoctorDto(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getPhone(), doctor.getSpecialty(), doctor.getAddress());
    }
}
