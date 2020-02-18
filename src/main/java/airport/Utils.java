package airport;

import airport.model.Flight;
import airport.model.Lot;
import airport.model.Tourist;
import airport.repository.LotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class Utils {

    private final LotRepo lotRepo;

    @Autowired
    public Utils(LotRepo lotRepo) {
        this.lotRepo = lotRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        Flight flight = new Flight(LocalDateTime.now(),LocalDateTime.now(),16,100);
        List<Tourist> touristList = new ArrayList<>();
        touristList.add(new Tourist("John","Smith","Male","German","Note", LocalDate.now(),11));
        touristList.add(new Tourist("Rick","Sanchez","Male","France","Rick And Morty", LocalDate.now(),11));

        Lot lot = new Lot(flight,touristList);
        lotRepo.save(lot);

    }


}


   
   
   

