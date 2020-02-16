package airport.controller;

import airport.model.Flight;
import airport.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping()
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/all")
    public List<Flight> getAll(){
        return flightService.getAll();
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Flight updateClient(@RequestBody @Valid Flight flight) {
        return flightService.addFlight(flight);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Flight addFlight(@RequestPart Flight flight) {
        return flightService.addFlight(flight);
    }

//    JSON TO ADD
//    {
//        "departure": "2020-02-22",
//            "arrival": "2020-02-22",
//            "numberOfSeat": 16,
//            "touristList": [
//        {
//            "name": "Filip",
//                "surname": "Poreba",
//                "sex": "Male",
//                "country": "country",
//                "note": "note",
//                "birthDate": "2020-02-13",
//                "flightList": []
//        }
//        ],
//        "ticketPrice": 100
//    }
}
