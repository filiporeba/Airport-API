package airport.controller;

import airport.exception.LotNotFoundException;
import airport.model.Flight;
import airport.model.Lot;
import airport.model.Tourist;
import airport.service.FlightService;
import airport.service.LotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/lot")
@CrossOrigin
public class LotController {

    private final LotService lotService;
    private final FlightService flightService;

    @Autowired
    public LotController(LotService lotService, FlightService flightService) {
        this.lotService = lotService;
        this.flightService = flightService;
    }

    @GetMapping(value = "/all")
    public List<Lot> show() {
        return lotService.showAll();
    }

    @GetMapping(value = "/{id}")
    public Lot showOne(@PathVariable Integer id) {
        return lotService.getOneByID(id).orElseThrow(() -> new LotNotFoundException(id));
    }

    @PostMapping(value = "/flight/{id}")
    public ResponseEntity<Lot> addLotByFlightID(@PathVariable Integer id) {
        Optional<Flight> flightById = flightService.getFlightById(id);
        Lot newLot = new Lot();
        List<Tourist> touristList = new ArrayList<>();

        if (flightById.isPresent()) {
            newLot.setFlight(flightById.get());
            newLot.setTouristList(touristList);
            lotService.addLot(newLot);
            return new ResponseEntity<Lot>(newLot, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity removeLotById(@PathVariable Integer id) {
        if(lotService.getOneByID(id).isPresent()) {
            lotService.removeLotById(id);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

}
