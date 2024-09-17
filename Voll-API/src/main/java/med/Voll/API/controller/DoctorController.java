package med.Voll.API.controller;

import med.Voll.API.model.doctor.RegisterDoctorDto;
import med.Voll.API.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping()
    public void registerDoctor(@RequestBody RegisterDoctorDto registerDoctorDto){
        doctorService.registerDoctor(registerDoctorDto);
    }
}
