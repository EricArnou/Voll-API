package med.Voll.API.service;

import med.Voll.API.model.patient.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Transactional
    public void registerPatient(RegisterPatientDto registerPatientDto) {
        patientRepository.save(new Patient(registerPatientDto));
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Page<ReturnPatientDto> getListOfPatients(Pageable pageable) {
        return patientRepository.findAll(pageable).map(ReturnPatientDto::new);
    }

    @Transactional
    public void updatePatient(UpdatePatientDto updatePatientDto) {
        var patient = patientRepository.getReferenceById(updatePatientDto.id());
        patient.updateInformation(updatePatientDto);
    }
}
