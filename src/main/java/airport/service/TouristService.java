package airport.service;

import airport.model.Tourist;
import airport.repository.TouristRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristService {

    private final TouristRepo touristRepo;

    @Autowired
    public TouristService(TouristRepo touristRepo) {
        this.touristRepo = touristRepo;
    }

    public List<Tourist> getAllTourists() {
        return touristRepo.findAll();
    }

    public List<Tourist> getByName(String name) {
        return touristRepo.findByName(name);
    }

    public Tourist addTourist(Tourist tourist) {
        return touristRepo.save(tourist);
    }

    public void deleteById(Integer id) {
        touristRepo.deleteById(id);
    }

    public Optional<Tourist> getOneById(Integer id) {
        return touristRepo.findById(id);
    }


}
