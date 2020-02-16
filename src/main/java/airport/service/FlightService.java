package airport.service;

import airport.model.Flight;
import airport.repository.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightService {

    private final FlightRepo flightRepo;

    @Autowired
    public FlightService(FlightRepo flightRepo) {
        this.flightRepo = flightRepo;
    }

    public List<Flight> getFlightList() {
        return flightRepo.findAll();
    }

    public Flight addFlight(Flight flight) {
        return flightRepo.save(flight);
    }

    public Flight getFlightById(Integer id) {
        if(flightRepo.findById(id).isPresent())
            return flightRepo.findById(id).get();
        else
            return null;
    }

    public void removeFlightById(Integer id) {
        flightRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        Flight flight = new Flight(LocalDateTime.now(),LocalDateTime.now(),16,200);
        flightRepo.save(flight);
    }
}
