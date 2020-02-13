package airport.controller;

import airport.model.Tourist;
import airport.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TouristController {

    private final TouristService touristService;

    @Autowired
    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping(value = "/tourists")
    public List<Tourist> getTourists() {
        return touristService.getAllTourists();
    }
}
