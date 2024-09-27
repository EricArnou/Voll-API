package med.Voll.API.service.AppointmentValidator;

import med.Voll.API.domain.appointment.RegisterAppointmentDto;
import med.Voll.API.domain.patient.PatientRepository;
import med.Voll.API.infra.exceptions.ErrorMessage;
import med.Voll.API.infra.exceptions.VollMedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateActivePatient implements AppointmentValidatorInterface {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public void validate(RegisterAppointmentDto registerAppointmentDto) {
        var patient = patientRepository.getReferenceById(registerAppointmentDto.idPatient());

        if(!patient.isActive())
            throw new VollMedException(ErrorMessage.PATIENT_IS_NOT_ACTIVE);
    }
}
