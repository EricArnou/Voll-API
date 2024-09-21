package med.Voll.API.service;

import med.Voll.API.model.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Transactional
    public ResponseEntity registerDoctor(RegisterDoctorDto registerDoctorDto, UriComponentsBuilder uriComponentsBuilder){
        var doctor = new Doctor(registerDoctorDto);
        doctorRepository.save(doctor);

        var uri = uriComponentsBuilder.path("medicos/{id}").buildAndExpand(doctor.getId()).toUri();

        return ResponseEntity.created(uri).body(new ReturnUpdateDoctorDto(doctor));
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public ResponseEntity<Page<ReturnDoctorDto>> getListOfDoctors(Pageable pageable) {
        var page = doctorRepository.findAllByActiveTrue(pageable)
                .map(ReturnDoctorDto::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    public ResponseEntity updateDoctor(UpdateDoctorDto updateDoctorDto){
        var doctor = doctorRepository.getReferenceById(updateDoctorDto.id());
        doctor.updateInformation(updateDoctorDto);
        return ResponseEntity.ok(new ReturnUpdateDoctorDto(doctor));
    }

    @Transactional
    public ResponseEntity deleteDoctor(Long id) {
        var doctor = doctorRepository.getReferenceById(id);
        doctor.disableDoctor();
        return ResponseEntity.noContent().build();
    }
}
