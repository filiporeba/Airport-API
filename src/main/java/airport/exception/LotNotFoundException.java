package airport.exception;

public class LotNotFoundException extends  RuntimeException {

    public LotNotFoundException(Integer id) {
        super("Could not find lot with id " + id);
    }
}
