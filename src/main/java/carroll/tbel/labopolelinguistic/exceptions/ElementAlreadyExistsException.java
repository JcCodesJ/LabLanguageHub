package carroll.tbel.labopolelinguistic.exceptions;

public class ElementAlreadyExistsException extends RuntimeException{

    public ElementAlreadyExistsException() {
        super("The element already exists");
    }

}
