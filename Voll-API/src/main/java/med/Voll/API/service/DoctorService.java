package med.Voll.API.service;

import med.Voll.API.model.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Transactional
    public void registerDoctor(RegisterDoctorDto registerDoctorDto){
        doctorRepository.save(new Doctor(registerDoctorDto));
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Page<ReturnDoctorDto> getListOfDoctors(Pageable pageable) {
        return doctorRepository.findAllByActiveTrue(pageable)
                .map(ReturnDoctorDto::new);
    }

    @Transactional
    public void updateDoctor(UpdateDoctorDto updateDoctorDto){
        var doctor = doctorRepository.getReferenceById(updateDoctorDto.id());
        doctor.updateInformation(updateDoctorDto);
    }

    @Transactional
    public void deleteDoctor(Long id) {
        var doctor = doctorRepository.getReferenceById(id);
        doctor.disableDoctor();
    }
}
