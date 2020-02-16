package airport.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "lots")
public class Lot {

    @Id
    @Column(name = "id")
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
