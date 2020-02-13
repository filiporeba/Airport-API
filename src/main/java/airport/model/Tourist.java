package airport.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String sex;
    private String country;
    private String note;
    private LocalDate birthDate;
    @ManyToMany(targetEntity = Flight.class)
    private List<Flight> flightList;

    public Tourist() {
    }

    public Tourist(String name, String surname, String sex, String country, String note, LocalDate birthDate, List<Flight> flightList) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.country = country;
        this.note = note;
        this.birthDate = birthDate;
        this.flightList = flightList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tourist tourist = (Tourist) o;
        return Objects.equals(id, tourist.id) &&
                Objects.equals(name, tourist.name) &&
                Objects.equals(surname, tourist.surname) &&
                Objects.equals(sex, tourist.sex) &&
                Objects.equals(country, tourist.country) &&
                Objects.equals(note, tourist.note) &&
                Objects.equals(birthDate, tourist.birthDate) &&
                Objects.equals(flightList, tourist.flightList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, sex, country, note, birthDate, flightList);
    }

    @Override
    public String toString() {
        return "Tourist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex='" + sex + '\'' +
                ", country='" + country + '\'' +
                ", note='" + note + '\'' +
                ", birthDate=" + birthDate +
                ", flightList=" + flightList +
                '}';
    }
}
