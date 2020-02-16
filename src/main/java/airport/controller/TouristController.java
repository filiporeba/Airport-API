package airport.controller;

import airport.exception.TouristNotFoundException;
import airport.model.Flight;
import airport.model.Lot;
import airport.model.Tourist;
import airport.service.FlightService;
import airport.service.LotService;
import airport.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/tourist")
@RestController
public class TouristController {

    private final TouristService touristService;
    private final LotService lotService;
    private final FlightService flightService;

    @Autowired
    public TouristController(TouristService touristService, LotService lotService, FlightService flightService) {
        this.touristService = touristService;
        this.lotService = lotService;
        this.flightService = flightService;
    }

    @GetMapping(value = "/all")
    public List<Tourist> getTourists() {
        return touristService.getAllTourists();
    }

    @GetMapping(value = "/{name}")
    public List<Tourist> getName(@PathVariable("name") String name) {
        return touristService.getByName(name);
    }

    @GetMapping(value = "/id/{id}")
    public Tourist showone(@PathVariable("id") Integer id) {
        return touristService.findyById(id).orElseThrow(() -> new TouristNotFoundException(id));
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


//    @GetMapping(value = "/wow")
//    public Optional<Tourist> afaf() {
//        Lot lot1 = lotService.showOne(2);
//        List<Tourist> idTourist = lot1.getTouristList();
//        Integer lng = idTourist.size();
//        Optional<Tourist> tourist = touristService.findyById(4);
//        tourist.get().setFlightId(lng);
//        return tourist;
//    }


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

    @PostMapping(value = "/zero/{id}")
    public ResponseEntity<Lot> addToEmptyFlight(@RequestBody Tourist tourist, @PathVariable Integer id) {
        List<Tourist> touristList = new ArrayList<>();
        tourist.setFlightId(id);
        touristList.add(tourist);

        Flight flightById = flightService.getFlightById(id);
        Lot newLot = new Lot(flightById,touristList);

        Lot lott = lotService.addLot(newLot);

        return  new ResponseEntity<Lot>(lott,HttpStatus.CREATED);
    }
}

