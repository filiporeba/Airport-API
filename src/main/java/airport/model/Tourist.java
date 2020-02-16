package airport.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "turysta", insertable = false, updatable = false)
    private Integer id;
    private String name;
    private String surname;
    private String sex;
    private String country;
    private String note;
    private LocalDate birthDate;
    private Integer flightId;


    public Tourist() {
    }


    public Tourist(String name, String surname, String sex, String country, String note, LocalDate birthDate, Integer flightId) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.country = country;
        this.note = note;
        this.birthDate = birthDate;
        this.flightId = flightId;
    }
}
