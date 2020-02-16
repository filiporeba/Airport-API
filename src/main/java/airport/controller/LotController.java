package airport.controller;

import airport.model.Lot;
import airport.model.Tourist;
import airport.service.LotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequestMapping(value = "/lot")
@RestController
public class LotController {

    private final LotService lotService;

    @Autowired
    public LotController(LotService lotService) {
        this.lotService = lotService;
    }

    @GetMapping(value = "/all")
    public List<Lot> show() {
        return lotService.showAll();
    }

    @GetMapping(value = "/{id}")
    public Lot showOne(@PathVariable Integer id) {
        return lotService.showOne(id);
    }

//    @GetMapping(value = "/turysta")
//    public Lot addClient() {
//        Lot lot1 = lotService.showOne(1);
//        List<Tourist> idTourist = lot1.getTouristList();
//        idTourist.add(new Tourist("FiFI","FiFI","FiFI","FiFI","note", LocalDate.now(),1));
//        return lotService.addLot(lot1);
//    }
}
