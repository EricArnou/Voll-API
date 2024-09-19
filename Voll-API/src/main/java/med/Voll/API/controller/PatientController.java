package med.Voll.API.controller;

import jakarta.validation.Valid;
import med.Voll.API.model.patient.RegisterPatientDto;
import med.Voll.API.model.patient.ReturnPatientDto;
import med.Voll.API.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping()
    public void registerPatient(@RequestBody @Valid RegisterPatientDto registerPatientDto){
        patientService.registerPatient(registerPatientDto);
    }

    @GetMapping()
    public Page<ReturnPatientDto> getListOfPatients(Pageable pageable){
        return patientService.getListOfPatients(pageable);
    }
}
