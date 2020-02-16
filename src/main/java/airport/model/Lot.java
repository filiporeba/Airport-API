package airport.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "lots")
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade=CascadeType.ALL)
    private Flight flight;

    @OneToMany(cascade=CascadeType.ALL)
    private List<Tourist> touristList;

    public Lot(Flight flight, List<Tourist> touristList) {
        this.flight = flight;
        this.touristList = touristList;
    }

    public Lot() {
    }
}
