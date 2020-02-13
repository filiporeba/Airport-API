package airport.repository;

import airport.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristRepo extends JpaRepository<Tourist, Integer> {
}
