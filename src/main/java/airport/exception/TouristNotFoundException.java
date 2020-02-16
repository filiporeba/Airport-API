package airport.exception;

public class TouristNotFoundException extends RuntimeException {

        public TouristNotFoundException(Integer id) {
            super("Could not find tourist with id " + id);
        }
}
