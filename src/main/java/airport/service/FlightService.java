package airport.service;

import airport.model.Flight;
import airport.model.Tourist;
import airport.repository.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    private final FlightRepo flightRepo;

    @Autowired
    public FlightService(FlightRepo flightRepo) {
        this.flightRepo = flightRepo;
    }

    public List<Flight> getAll() {
        return flightRepo.findAll();
    }

    public Flight addFlight(Flight flight) {
        return flightRepo.save(flight);
    }

    public Flight getOne(Integer id) {
        if(flightRepo.findById(id).isPresent())
            return flightRepo.findById(id).get();
        else
            return null;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
//        List<Flight> flightList = new ArrayList<>();
//
//        List<Tourist> touristList = new ArrayList<>();
//        touristList.add(new Tourist("name2","surname2","sex2","country","note", LocalDate.now(),0));
//        touristList.add(new Tourist("name1","surname211","sex211","country","note", LocalDate.now(),0));
//        touristList.add(new Tourist("name1","surname211","sex211","country","note", LocalDate.now(),0));

        Flight flight = new Flight(LocalDate.now(),LocalDate.now(),16,200);

        flightRepo.save(flight);
    }
}
