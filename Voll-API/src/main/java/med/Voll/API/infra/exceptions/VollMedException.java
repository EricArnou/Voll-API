package med.Voll.API.infra.exceptions;

public class VollMedException extends RuntimeException{

    public VollMedException(ErrorMessage errorMessage){
        super(errorMessage.label);
    }

}
