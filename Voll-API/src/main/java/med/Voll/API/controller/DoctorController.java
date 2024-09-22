package med.Voll.API.controller;

import jakarta.validation.Valid;
import med.Voll.API.domain.doctor.RegisterDoctorDto;
import med.Voll.API.domain.doctor.UpdateDoctorDto;
import med.Voll.API.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping()
    public ResponseEntity registerDoctor(@RequestBody @Valid RegisterDoctorDto registerDoctorDto, UriComponentsBuilder uriComponentsBuilder){
        return doctorService.registerDoctor(registerDoctorDto, uriComponentsBuilder);
    }

    @GetMapping()
    public ResponseEntity getListOfDoctors(Pageable pageable){
        return doctorService.getListOfDoctors(pageable);
    }

    @PutMapping()
    public ResponseEntity updateDoctor(@RequestBody @Valid UpdateDoctorDto updateDoctorDto){
        return doctorService.updateDoctor(updateDoctorDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDoctor(@PathVariable Long id){
        return doctorService.deleteDoctor(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity getDoctor(@PathVariable Long id){
        return doctorService.getDoctor(id);
    }
}
