package med.Voll.API.controller;

import jakarta.validation.Valid;
import med.Voll.API.model.doctor.RegisterDoctorDto;
import med.Voll.API.model.doctor.ReturnDoctorDto;
import med.Voll.API.model.doctor.UpdateDoctorDto;
import med.Voll.API.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<ReturnDoctorDto> getListOfDoctors(Pageable pageable){
        return doctorService.getListOfDoctors(pageable);
    }

    @PutMapping()
    public void updateDoctor(@RequestBody @Valid UpdateDoctorDto updateDoctorDto){
        doctorService.updateDoctor(updateDoctorDto);
    }
}
