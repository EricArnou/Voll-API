package med.Voll.API.service;

import med.Voll.API.model.doctor.Doctor;
import med.Voll.API.model.doctor.DoctorRepository;
import med.Voll.API.model.doctor.RegisterDoctorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Transactional
    public void registerDoctor(RegisterDoctorDto registerDoctorDto){
        doctorRepository.save(new Doctor(registerDoctorDto));
    }
}
