package airport.controller;

import airport.model.Flight;
import airport.repository.FlightRepo;
import airport.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/flight")
public class FlightController {

    private final FlightService flightService;
    private final FlightRepo flightRepo;

    @Autowired
    public FlightController(FlightService flightService, FlightRepo flightRepo) {
        this.flightService = flightService;
        this.flightRepo = flightRepo;
    }

    @GetMapping(value = "/all")
    public List<Flight> getAll(){
        return flightService.getFlightList();
    }

    @GetMapping(value = "/{id}")
    public Flight getOneFlight(@PathVariable Integer id){
        return flightService.getFlightById(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Flight updateFlight(@RequestBody @Valid Flight flight, @PathVariable Integer id) {
        return flightRepo.findById(id)
                .map(flight1 -> {
                    flight1.setArrival(flight.getArrival());
                    flight1.setDeparture(flight.getDeparture());
                    flight1.setNumberOfSeat(flight.getNumberOfSeat());
                    flight1.setTicketPrice(flight.getTicketPrice());
                    return flightRepo.save(flight1);
                })
                .orElseGet(() -> {
                    flight.setId(id);
                    return flightRepo.save(flight);
                });

    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Flight addFlight(@RequestPart Flight flight) {
        return flightService.addFlight(flight);
    }

    @DeleteMapping(value = "/remove")
    public ResponseEntity removeFlightById(@PathVariable Integer id) {
        flightService.removeFlightById(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }


}
