package med.Voll.API.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.Voll.API.domain.patient.RegisterPatientDto;
import med.Voll.API.domain.patient.UpdatePatientDto;
import med.Voll.API.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")
@SecurityRequirement(name = "bearer-key")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping()
    public ResponseEntity registerPatient(@RequestBody @Valid RegisterPatientDto registerPatientDto, UriComponentsBuilder uriComponentsBuilder){
        return patientService.registerPatient(registerPatientDto, uriComponentsBuilder);
    }

    @GetMapping()
    public ResponseEntity getListOfPatients(Pageable pageable){
        return patientService.getListOfPatients(pageable);
    }

    @PutMapping()
    public ResponseEntity updatePatient(@RequestBody @Valid UpdatePatientDto updatePatientDto){
        return patientService.updatePatient(updatePatientDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePatient(@PathVariable Long id){
        return patientService.deletePatient(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity getPatient(@PathVariable Long id){
        return patientService.getPatient(id);
    }
}
