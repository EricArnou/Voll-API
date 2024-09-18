package med.Voll.API.model.doctor;

public record ReturnDoctorDto(String name, String email, String crm, Specialty specialty) {

    public ReturnDoctorDto(Doctor doctor) {
        this(doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
