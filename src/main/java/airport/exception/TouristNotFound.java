package airport.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class TouristNotFound {

    @ResponseBody
    @ExceptionHandler(TouristNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String touristNotFoundHandler(TouristNotFoundException ex) {
        return ex.getMessage();
    }
}
