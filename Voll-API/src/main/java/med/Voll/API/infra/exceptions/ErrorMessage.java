package med.Voll.API.infra.exceptions;

public enum ErrorMessage {
    PATIENT_NOT_FOUND("This patient does not exists"),
    DOCTOR_NOT_FOUND("This doctor does not exists"),
    CLINIC_DOES_NOT_OPEN("The clinic's opening hours are Monday to Saturday from 7 a.m. to 7 p.m."),
    NO_ADVANCE_NOTICE_NECESSARY("Appointments must be schedule at least 30 minutes in advance "),
    PATIENT_IS_NOT_ACTIVE("The patient must be active"),
    DOCTOR_IS_NOT_ACTIVE("The doctor must be active"),
    PATIENT_ALREADY_HAS_AN_APPOINTMENT("The patient already has an appointment for that day"),
    DOCTOR_NOT_AVAILABLE("The doctor already has an appointment for that date and time"),
    SPECIALTY_IS_REQUIRED("Specialty must be specified when the doctor is not");

    public final String label;

    ErrorMessage(String label){
        this.label = label;
    }

}
