package med.Voll.API;

import jakarta.persistence.EntityManager;
import med.Voll.API.domain.address.AddressDto;
import med.Voll.API.domain.appointment.Appointment;
import med.Voll.API.domain.doctor.Doctor;
import med.Voll.API.domain.doctor.RegisterDoctorDto;
import med.Voll.API.domain.doctor.Specialty;
import med.Voll.API.domain.patient.Patient;
import med.Voll.API.domain.patient.RegisterPatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

@DataJpaTest
public class TestAssistant {

    @Autowired
    EntityManager entityManager;

    //dates
    protected final LocalDateTime NEXT_MONDAY_AT_10AM = LocalDateTime.now()
            .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
            .withHour(10);

    protected final LocalDateTime NEXT_MONDAY_AT_7AM = LocalDateTime.now()
            .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
            .withHour(7);

    protected final LocalDateTime NEXT_MONDAY_AT_19PM = LocalDateTime.now()
            .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
            .withHour(19);
    protected final LocalDateTime NEXT_THURSDAY_AT_10AM = LocalDateTime.now()
            .with(TemporalAdjusters.next(DayOfWeek.THURSDAY))
            .withHour(10);

    //doctor
    protected final String DOCTOR_NAME_1 = "doctor 1";
    protected final String DOCTOR_EMAIL_1 = "email 1";
    protected final String DOCTOR_CRM_1 = "123456";
    protected final String DOCTOR_PHONE_1 = "11111111111";
    protected final String DOCTOR_NAME_2 = "doctor 2";
    protected final String DOCTOR_EMAIL_2 = "email 2";
    protected final String DOCTOR_CRM_2 = "123450";
    protected final String DOCTOR_PHONE_2 = "11111111112";



    //patient
    protected final String PATIENT_NAME_1 = "patient 1";
    protected final String PATIENT_EMAIL_1 = "email 1";
    protected final String PATIENT_CPF_1 = "12345678901";
    protected final String PATIENT_PHONE_1 = "11111111111";

    protected Doctor createDemoDoctor1(Specialty specialty){
        var doctor = new Doctor(new RegisterDoctorDto(DOCTOR_NAME_1, DOCTOR_EMAIL_1, DOCTOR_CRM_1, specialty, DOCTOR_PHONE_1, demoAddress()));
        entityManager.persist(doctor);
        return doctor;
    }

    protected Doctor createDemoDoctor2(Specialty specialty){
        var doctor = new Doctor(new RegisterDoctorDto(DOCTOR_NAME_2, DOCTOR_EMAIL_2, DOCTOR_CRM_2, specialty, DOCTOR_PHONE_2, demoAddress()));
        entityManager.persist(doctor);
        return doctor;
    }

    protected Patient createDemoPatient(){
        var patient = new Patient(new RegisterPatientDto(PATIENT_NAME_1, PATIENT_EMAIL_1, PATIENT_CPF_1, PATIENT_PHONE_1, demoAddress()));
        entityManager.persist(patient);
        return patient;
    }

    protected void scheduleAppointment(Doctor doctor, Patient patient, LocalDateTime schedule){
        entityManager.persist(new Appointment(null, patient, doctor, schedule));
    }

    protected AddressDto demoAddress(){
        return new AddressDto(
                "rua 1",
                "bairro 1",
                "11111111",
                "st",
                "city 1",
                null,
                null
        );
    }
}
