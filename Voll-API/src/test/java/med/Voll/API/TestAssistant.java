package med.Voll.API;

import med.Voll.API.domain.address.AddressDto;
import med.Voll.API.domain.appointment.Appointment;
import med.Voll.API.domain.doctor.Doctor;
import med.Voll.API.domain.doctor.RegisterDoctorDto;
import med.Voll.API.domain.doctor.Specialty;
import med.Voll.API.domain.patient.Patient;
import med.Voll.API.domain.patient.RegisterPatientDto;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class TestAssistant {

    //dates
    public static final LocalDateTime NEXT_MONDAY_AT_10AM = LocalDateTime.now()
            .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
            .withHour(10);

    public static final LocalDateTime NEXT_MONDAY_AT_7AM = LocalDateTime.now()
            .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
            .withHour(7);

    public static final LocalDateTime NEXT_MONDAY_AT_19PM = LocalDateTime.now()
            .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
            .withHour(19);
    public static final LocalDateTime NEXT_THURSDAY_AT_10AM = LocalDateTime.now()
            .with(TemporalAdjusters.next(DayOfWeek.THURSDAY))
            .withHour(10);

    //doctor
    public static final Long DOCTOR_ID_1 = 1L;
    public static final String DOCTOR_NAME_1 = "doctor 1";
    public static final String DOCTOR_EMAIL_1 = "email 1";
    public static final String DOCTOR_CRM_1 = "123456";
    public static final String DOCTOR_PHONE_1 = "11111111111";
    public static final Long DOCTOR_ID_2 = 2L;
    public static final String DOCTOR_NAME_2 = "doctor 2";
    public static final String DOCTOR_EMAIL_2 = "email 2";
    public static final String DOCTOR_CRM_2 = "123450";
    public static final String DOCTOR_PHONE_2 = "11111111112";



    //patient
    public static final Long PATIENT_ID_1 = 1L;
    public static final String PATIENT_NAME_1 = "patient 1";
    public static final String PATIENT_EMAIL_1 = "email 1";
    public static final String PATIENT_CPF_1 = "12345678901";
    public static final String PATIENT_PHONE_1 = "11111111111";

    public static Doctor createDemoDoctor1(Specialty specialty){
        var doctor = new Doctor(new RegisterDoctorDto(DOCTOR_NAME_1, DOCTOR_EMAIL_1, DOCTOR_CRM_1, specialty, DOCTOR_PHONE_1, demoAddress()));
        return doctor;
    }

    public static Doctor createDemoDoctor2(Specialty specialty){
        var doctor = new Doctor(new RegisterDoctorDto(DOCTOR_NAME_2, DOCTOR_EMAIL_2, DOCTOR_CRM_2, specialty, DOCTOR_PHONE_2, demoAddress()));
        return doctor;
    }

    public static Patient createDemoPatient(){
        var patient = new Patient(new RegisterPatientDto(PATIENT_NAME_1, PATIENT_EMAIL_1, PATIENT_CPF_1, PATIENT_PHONE_1, demoAddress()));
        return patient;
    }

    public static Appointment scheduleAppointment(Doctor doctor, Patient patient, LocalDateTime schedule){
        return new Appointment(null, patient, doctor, schedule);
    }

    public static AddressDto demoAddress(){
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
