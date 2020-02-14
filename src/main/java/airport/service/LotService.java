package airport.service;

import airport.model.Flight;
import airport.model.Lot;
import airport.model.Tourist;
import airport.repository.LotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LotService {

    private final LotRepo lotRepo;

    @Autowired
    public LotService(LotRepo lotRepo) {
        this.lotRepo = lotRepo;
    }

    public List<Lot> showAll() {
        return lotRepo.findAll();
    }

    public Lot showOne(Integer id) {
        if(lotRepo.findById(id).isPresent())
            return lotRepo.findById(id).get();
        else
            return null;
    }

    public Lot addLot(Lot lot) {
        return lotRepo.save(lot);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        Flight flight = new Flight(LocalDate.now(),LocalDate.now(),16,100);
        List<Tourist> touristList = new ArrayList<>();
        touristList.add(new Tourist("name2","surname2","sex2","country","note", LocalDate.now(),0));
        touristList.add(new Tourist("name222","surname222","sex222","country22","note22", LocalDate.now(),0));

        Lot lot = new Lot(flight,touristList);
        lotRepo.save(lot);
    }
}