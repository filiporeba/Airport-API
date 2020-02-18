package airport.controller;

import airport.exception.TouristNotFoundException;
import airport.model.Lot;
import airport.model.Tourist;
import airport.service.LotService;
import airport.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/tourist")
@RestController
@CrossOrigin
public class TouristController {

    private final TouristService touristService;
    private final LotService lotService;


    @Autowired
    public TouristController(TouristService touristService, LotService lotService) {
        this.touristService = touristService;
        this.lotService = lotService;
    }

    @GetMapping(value = "/all")
    public List<Tourist> getTourists() {
        return touristService.getAllTourists();
    }

    @GetMapping(value = "/name/{name}")
    public List<Tourist> getName(@PathVariable("name") String name) {
        return touristService.getByName(name);
    }

    @GetMapping(value = "/{id}")
    public Tourist getOne(@PathVariable("id") Integer id) {
        return touristService.getOneById(id).orElseThrow(() -> new TouristNotFoundException(id));
    }

    @PostMapping(value = "/add")
    public Tourist addTourist(@RequestBody @Valid Tourist tourist) {
        return touristService.addTourist(tourist);
    }

    @PostMapping(value = "/lot/{id}")
    public ResponseEntity<Lot> addTouristToFlight(@RequestBody Tourist tourist, @PathVariable Integer id) {
        Lot lot1 = null;
        Optional<Lot> lot = lotService.getOneByID(id);

        if (lot.isPresent()) {
            Integer flightId = lot.get().getFlight().getFlightId();
            lot1 = lot.get();
            tourist.setFlightId(flightId);
            List<Tourist> idTourist = lot1.getTouristList();

            if (idTourist.size() < 16)
                idTourist.add(tourist);
            else
                return new ResponseEntity<Lot>(HttpStatus.NOT_ACCEPTABLE);

            Lot lots = lotService.addLot(lot1);
            return new ResponseEntity<Lot>(lots, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Lot>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteTouristById(@PathVariable Integer id) {
        if(touristService.getOneById(id).isPresent()) {
            touristService.deleteById(id);
            return new ResponseEntity<String>(HttpStatus.OK);
        } else {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }
}

