package med.Voll.API.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
public class AppointmentController {

    @PostMapping()
    public ResponseEntity scheduleAnAppointment(){
        return null;
    }
}
