package med.Voll.API.model.doctor;

public record ReturnDoctorDto(Long id, String name, String email, String crm, Specialty specialty) {

    public ReturnDoctorDto(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
