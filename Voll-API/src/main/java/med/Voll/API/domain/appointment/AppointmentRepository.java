package med.Voll.API.domain.appointment;

import med.Voll.API.domain.doctor.Doctor;
import med.Voll.API.domain.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    boolean existsByDoctorAndSchedule(Doctor doctor, LocalDateTime schedule);
    boolean existsByPatientAndScheduleBetween(Patient patient, LocalDateTime firstSchedule, LocalDateTime lastSchedule);
}
