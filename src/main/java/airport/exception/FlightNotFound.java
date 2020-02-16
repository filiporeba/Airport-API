package airport.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class FlightNotFound {

    @ResponseBody
    @ExceptionHandler(FlightNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String flightNotFoundHandler(FlightNotFoundException ex) {
        return ex.getMessage();
    }
}
