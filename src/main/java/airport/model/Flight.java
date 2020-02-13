package airport.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate departure;
    private LocalDate arrival;
    private Integer numberOfSeat;
    @ManyToMany(targetEntity = Tourist.class)
    private List<Tourist> touristList;
    private Integer ticketPrice;

    public Flight() {
    }

    public Flight(LocalDate departure, LocalDate arrival, Integer numberOfSeat, List<Tourist> touristList, Integer ticketPrice) {
        this.departure = departure;
        this.arrival = arrival;
        this.numberOfSeat = numberOfSeat;
        this.touristList = touristList;
        this.ticketPrice = ticketPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDate departure) {
        this.departure = departure;
    }

    public LocalDate getArrival() {
        return arrival;
    }

    public void setArrival(LocalDate arrival) {
        this.arrival = arrival;
    }

    public Integer getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(Integer numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public List<Tourist> getTouristList() {
        return touristList;
    }

    public void setTouristList(List<Tourist> touristList) {
        this.touristList = touristList;
    }

    public Integer getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Integer ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id) &&
                Objects.equals(departure, flight.departure) &&
                Objects.equals(arrival, flight.arrival) &&
                Objects.equals(numberOfSeat, flight.numberOfSeat) &&
                Objects.equals(touristList, flight.touristList) &&
                Objects.equals(ticketPrice, flight.ticketPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departure, arrival, numberOfSeat, touristList, ticketPrice);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", departure=" + departure +
                ", arrival=" + arrival +
                ", numberOfSeat=" + numberOfSeat +
                ", touristList=" + touristList +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
