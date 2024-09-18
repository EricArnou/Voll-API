package med.Voll.API.service;

import med.Voll.API.model.doctor.Doctor;
import med.Voll.API.model.doctor.DoctorRepository;
import med.Voll.API.model.doctor.RegisterDoctorDto;
import med.Voll.API.model.doctor.ReturnDoctorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Transactional
    public void registerDoctor(RegisterDoctorDto registerDoctorDto){
        doctorRepository.save(new Doctor(registerDoctorDto));
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<ReturnDoctorDto> getListOfDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(doctor -> new ReturnDoctorDto(doctor))
                .toList();
    }
}
