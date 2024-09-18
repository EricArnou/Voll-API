package med.Voll.API.controller;

import jakarta.validation.Valid;
import med.Voll.API.model.doctor.RegisterDoctorDto;
import med.Voll.API.model.doctor.ReturnDoctorDto;
import med.Voll.API.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping()
    public void registerDoctor(@RequestBody @Valid RegisterDoctorDto registerDoctorDto){
        doctorService.registerDoctor(registerDoctorDto);
    }

    @GetMapping()
    public List<ReturnDoctorDto> getListOfDoctors(){
        return doctorService.getListOfDoctors();
    }
}
