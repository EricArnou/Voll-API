package med.Voll.API.domain.appointment;

import med.Voll.API.TestAssistant;
import med.Voll.API.domain.doctor.Specialty;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class AppointmentRepositoryTest extends TestAssistant {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Test
    void whenExistsScheduleExpectTrue() {
        //given
        var doctor = createDemoDoctor1(Specialty.CARDIOLOGIA);
        var patient = createDemoPatient();
        scheduleAppointment(doctor, patient, NEXT_MONDAY_AT_10AM);

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
        scheduleAppointment(doctor, patient, NEXT_MONDAY_AT_10AM);

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
        scheduleAppointment(doctor, patient, NEXT_THURSDAY_AT_10AM);

        //when
        var hasAppointment = appointmentRepository.existsByPatientAndScheduleBetween(patient,NEXT_MONDAY_AT_7AM, NEXT_MONDAY_AT_19PM);

        //then
        Assertions.assertThat(hasAppointment).isFalse();
    }
}