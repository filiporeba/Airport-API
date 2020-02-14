package airport.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate departure;
    private LocalDate arrival;
    private Integer numberOfSeat;
    private Integer ticketPrice;

    public Flight() {
    }

    public Flight(LocalDate departure, LocalDate arrival, Integer numberOfSeat, Integer ticketPrice) {
        this.departure = departure;
        this.arrival = arrival;
        this.numberOfSeat = numberOfSeat;
        this.ticketPrice = ticketPrice;
    }
}

