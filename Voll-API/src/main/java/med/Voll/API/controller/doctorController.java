package med.Voll.API.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class doctorController {

    @PostMapping()
    public void registerDoctor(){

    }
}
