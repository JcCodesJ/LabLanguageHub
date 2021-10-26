package carroll.tbel.labopolelinguistic.exceptions;

public class RoleInvalidException  extends RuntimeException{

    public RoleInvalidException() {
        super("The role of a User must be either USER or ADMIN");
    }
}
