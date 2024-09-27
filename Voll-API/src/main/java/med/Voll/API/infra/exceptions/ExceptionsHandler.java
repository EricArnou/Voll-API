package med.Voll.API.infra.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity getNotExistsEntity(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity notValidArgs(MethodArgumentNotValidException exception){
        return ResponseEntity.badRequest().body(exception.getFieldErrors()
                .stream()
                .map(FieldErrorsDto::new));
    }

    @ExceptionHandler(VollMedException.class)
    public ResponseEntity VollMedBusinessRules(VollMedException exception){
        return ResponseEntity.badRequest().body(new ErrorMessageDto(exception.getMessage()));
    }

    private record FieldErrorsDto(String field, String message){
        public FieldErrorsDto(FieldError exception){
            this(exception.getField(), exception.getDefaultMessage());
        }
    }
}
