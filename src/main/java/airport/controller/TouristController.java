package airport.controller;

import airport.model.Lot;
import airport.model.Tourist;
import airport.service.LotService;
import airport.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(name = "/tourist")
@RestController
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

    @GetMapping(value = "/{name}")
    public List<Tourist> getName(@PathVariable("name") String name) {
        return touristService.getByName(name);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteTouristById(@PathVariable Integer id) {
        touristService.deleteById(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public Tourist addTourist(@RequestBody Tourist tourist) {
        return touristService.save(tourist);
    }

    @PostMapping(value = "/add/{id}")
    public ResponseEntity<Lot> addTouristToFlight(@RequestBody Tourist tourist, @PathVariable Integer id) {
        Lot lot1 = lotService.showOne(id);
        tourist.setFlightId(id);
        List<Tourist> idTourist = lot1.getTouristList();

        if(idTourist.size() < 16)
            idTourist.add(tourist);
        else
            return new ResponseEntity<Lot>(HttpStatus.NOT_ACCEPTABLE);

        Lot lots = lotService.addLot(lot1);
        return  new ResponseEntity<Lot>(lots,HttpStatus.CREATED);
    }
}

