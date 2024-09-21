package med.Voll.API.service;

import med.Voll.API.model.patient.*;
import med.Voll.API.patient.ReturnUpdatePatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Transactional
    public ResponseEntity registerPatient(RegisterPatientDto registerPatientDto, UriComponentsBuilder uriComponentsBuilder){
        var patient = new Patient(registerPatientDto);
        patientRepository.save(patient);

        var uri = uriComponentsBuilder.path("pacientes/{id}").buildAndExpand(patient.getId()).toUri();

        return ResponseEntity.created(uri).body(new ReturnUpdatePatientDto(patient));
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public ResponseEntity<Page<ReturnPatientDto>> getListOfPatients(Pageable pageable) {
        var page = patientRepository.findAllByActiveTrue(pageable).map(ReturnPatientDto::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    public ResponseEntity updatePatient(UpdatePatientDto updatePatientDto) {
        var patient = patientRepository.getReferenceById(updatePatientDto.id());
        patient.updateInformation(updatePatientDto);
        return ResponseEntity.ok(new ReturnUpdatePatientDto(patient));
    }

    @Transactional
    public ResponseEntity deletePatient(Long id) {
        var patient = patientRepository.getReferenceById(id);
        patient.disablePatient();
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity getPatient(Long id) {
        var patient = patientRepository.getReferenceById(id);
        return ResponseEntity.ok(new ReturnUpdatePatientDto(patient));
    }
}
