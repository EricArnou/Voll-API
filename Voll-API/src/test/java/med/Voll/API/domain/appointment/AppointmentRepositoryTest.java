package med.Voll.API.domain.appointment;

import jakarta.persistence.EntityManager;
import med.Voll.API.TestAssistant;
import med.Voll.API.domain.doctor.Specialty;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static med.Voll.API.TestAssistant.*;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class AppointmentRepositoryTest {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    void whenExistsScheduleExpectTrue() {
        //given
        var doctor = createDemoDoctor1(Specialty.CARDIOLOGIA);
        var patient = createDemoPatient();
        entityManager.persist(doctor);
        entityManager.persist(patient);
        entityManager.persist(scheduleAppointment(doctor, patient, NEXT_MONDAY_AT_10AM));

        //when
        var hasAppointment = appointmentRepository.existsByDoctorAndSchedule(doctor, NEXT_MONDAY_AT_10AM);

        //then
        Assertions.assertThat(hasAppointment).isTrue();
    }

    @Test
    void whenExistsAnAppointmentByPatientExpectTrue() {
        //given
        var doctor = createDemoDoctor1(Specialty.CARDIOLOGIA);
        var patient = createDemoPatient();
        entityManager.persist(doctor);
        entityManager.persist(patient);
        entityManager.persist(scheduleAppointment(doctor, patient, NEXT_MONDAY_AT_10AM));

        //when
        var hasAppointment = appointmentRepository.existsByPatientAndScheduleBetween(patient,NEXT_MONDAY_AT_7AM, NEXT_MONDAY_AT_19PM);

        //then
        Assertions.assertThat(hasAppointment).isTrue();
    }

    @Test
    void whenNotExistsAnAppointmentByPatientExpectFalse() {
        //given
        var doctor = createDemoDoctor1(Specialty.CARDIOLOGIA);
        var patient = createDemoPatient();
        entityManager.persist(doctor);
        entityManager.persist(patient);
        entityManager.persist(scheduleAppointment(doctor, patient, NEXT_THURSDAY_AT_10AM));

        //when
        var hasAppointment = appointmentRepository.existsByPatientAndScheduleBetween(patient,NEXT_MONDAY_AT_7AM, NEXT_MONDAY_AT_19PM);

        //then
        Assertions.assertThat(hasAppointment).isFalse();
    }
}