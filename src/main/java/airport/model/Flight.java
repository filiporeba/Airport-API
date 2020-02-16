package airport.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime departure;
    private LocalDateTime arrival;
    private Integer numberOfSeat;
    private Integer ticketPrice;

    public Flight() {
    }

    public Flight(LocalDateTime departure, LocalDateTime arrival, Integer numberOfSeat, Integer ticketPrice) {
        this.departure = departure;
        this.arrival = arrival;
        this.numberOfSeat = numberOfSeat;
        this.ticketPrice = ticketPrice;
    }
}

