package med.Voll.API.domain.doctor;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static med.Voll.API.TestAssistant.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class DoctorRepositoryTest {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    void whenDoctorNotAvailableExpectNull() {
        //given
        var doctor = createDemoDoctor1(Specialty.ORTOPEDIA);
        var patient = createDemoPatient();
        entityManager.persist(doctor);
        entityManager.persist(patient);
        entityManager.persist(scheduleAppointment(doctor, patient, NEXT_MONDAY_AT_10AM));

        //when
        var freeDoctor = doctorRepository.findBySpecialtyAndFreeSchedule(Specialty.ORTOPEDIA, NEXT_MONDAY_AT_10AM);

        //then
        assertThat(freeDoctor).isNull();
    }

    @Test
    void whenHasNotDoctorAvailableExpectOtherDoctor() {
        //given
        var doctor = createDemoDoctor1(Specialty.ORTOPEDIA);
        var otherDoctor = createDemoDoctor2(Specialty.ORTOPEDIA);
        var patient = createDemoPatient();
        entityManager.persist(doctor);
        entityManager.persist(otherDoctor);
        entityManager.persist(patient);
        entityManager.persist(scheduleAppointment(doctor, patient, NEXT_MONDAY_AT_10AM));

        //when
        var freeDoctor = doctorRepository.findBySpecialtyAndFreeSchedule(Specialty.ORTOPEDIA, NEXT_MONDAY_AT_10AM);

        //then
        assertEquals(otherDoctor, freeDoctor);
    }
}