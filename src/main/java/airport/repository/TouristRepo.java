package airport.repository;

import airport.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TouristRepo extends JpaRepository<Tourist, Integer> {

    @Query(value = "SELECT * FROM Tourist where name = ?1", nativeQuery = true)
    List<Tourist> findByName(String name);
}
