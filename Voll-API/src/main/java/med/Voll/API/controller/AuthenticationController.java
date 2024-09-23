package med.Voll.API.controller;

import jakarta.validation.Valid;
import med.Voll.API.domain.user.AuthDto;
import med.Voll.API.domain.user.User;
import med.Voll.API.infra.security.TokenGeneratorService;
import med.Voll.API.infra.security.tokenJWTDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenGeneratorService tokenGeneratorService;

    @PostMapping()
    public ResponseEntity login (@RequestBody @Valid AuthDto authDto){
        var userAuthentication = new UsernamePasswordAuthenticationToken(authDto.login(), authDto.password());
        var authentication = authenticationManager.authenticate(userAuthentication);

        var tokenJWT = tokenGeneratorService.generateToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new tokenJWTDto(tokenJWT));
    }
}
