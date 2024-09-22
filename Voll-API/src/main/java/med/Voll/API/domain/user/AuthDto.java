package med.Voll.API.domain.user;

import jakarta.validation.constraints.NotBlank;

public record AuthDto(@NotBlank String login, @NotBlank String password) {

    public AuthDto(User user){
        this(user.getLogin(), user.getPassword());
    }
}
