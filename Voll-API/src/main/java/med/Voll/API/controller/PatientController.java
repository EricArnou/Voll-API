package med.Voll.API.controller;

import med.Voll.API.model.patient.RegisterPatientDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PatientController {

    @PostMapping()
    public void registerPatient(@RequestBody RegisterPatientDto registerPatientDto){

    }
}
