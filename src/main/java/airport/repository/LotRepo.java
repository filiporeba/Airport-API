package airport.repository;


import airport.model.Lot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LotRepo  extends JpaRepository<Lot,Integer> {

    @Query(value = "SELECT * FROM Flight_Wrapper InNEr JOIN Tourist ON Flight_Wrapper.id=Tourist.fly_Id", nativeQuery = true)
    List<String> finds();
}
