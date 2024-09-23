package med.Voll.API.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import med.Voll.API.domain.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenGeneratorService {

    @Value("${Voll.api.security.token.secret}")
    private String secret;

    public String generateToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("Voll_med.api")
                    .withClaim("id", user.getId())
                    .withExpiresAt(tokenExpire())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("error generating token", exception);
        }
    }

    private Instant tokenExpire() {
        return LocalDateTime.now().plusMinutes(30).toInstant(ZoneOffset.of("-03:00"));
    }
}
