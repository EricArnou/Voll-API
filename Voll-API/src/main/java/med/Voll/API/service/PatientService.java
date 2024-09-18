package med.Voll.API.service;

import med.Voll.API.model.patient.Patient;
import med.Voll.API.model.patient.PatientRepository;
import med.Voll.API.model.patient.RegisterPatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Transactional
    public void registerPatient(RegisterPatientDto registerPatientDto) {
        patientRepository.save(new Patient(registerPatientDto));
    }
}
