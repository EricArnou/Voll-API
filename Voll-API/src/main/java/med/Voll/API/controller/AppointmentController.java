package med.Voll.API.controller;

import jakarta.validation.Valid;
import med.Voll.API.domain.appointment.RegisterAppointmentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
public class AppointmentController {

    @PostMapping()
    public ResponseEntity scheduleAnAppointment(@RequestBody @Valid RegisterAppointmentDto registerAppointmentDto){
        return null;
    }
}
