package med.Voll.API.domain.appointment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.Voll.API.domain.doctor.Doctor;
import med.Voll.API.domain.patient.Patient;

import java.time.LocalDateTime;

@Table(name = "appointments")
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_patient")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_doctor")
    private Doctor doctor;

    private LocalDateTime schedule;
}
