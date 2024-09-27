package med.Voll.API.domain.doctor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Page<Doctor>findAllByActiveTrue(Pageable pageable);

    @Query("""
              SELECT d FROM Doctor d 
              WHERE d.active = true
              AND d.specialty = :specialty
              AND d.id NOT IN (
                SELECT a.doctor.id FROM Appointment a
                WHERE a.schedule = :schedule
              )
              ORDER BY function('random')
              LIMIT 1
            """)
    Doctor findBySpecialtyAndFreeSchedule(Specialty specialty, LocalDateTime schedule);
}
