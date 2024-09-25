CREATE TABLE appointments(
    id BIGSERIAL PRIMARY KEY,
    id_patient BIGINT NOT NULL ,
    id_doctor BIGINT NOT NULL ,
    schedule TIMESTAMP NOT NULL ,

    CONSTRAINT fk_appointment_doctor_id FOREIGN KEY (id_doctor) REFERENCES doctors(id),
    CONSTRAINT fk_appointment_patient_id FOREIGN KEY (id_patient) REFERENCES patients(id)
);