package carroll.tbel.labopolelinguistic.exceptions;

public class ElementNotFoundException extends RuntimeException{

    public ElementNotFoundException() {
        super("The searched-for element was not found");
    }

}
