package airport.service;

import airport.model.Flight;
import airport.model.Tourist;
import airport.repository.TouristRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TouristService {

    private final TouristRepo touristRepo;

    @Autowired
    public TouristService(TouristRepo touristRepo) {
        this.touristRepo = touristRepo;
    }

    public List<Tourist> getAllTourists() {
        return touristRepo.findAll();
    }


}
