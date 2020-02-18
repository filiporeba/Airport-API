package airport.service;


import airport.model.Lot;
import airport.repository.LotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LotService {

    private final LotRepo lotRepo;

    @Autowired
    public LotService(LotRepo lotRepo) {
        this.lotRepo = lotRepo;
    }

    public List<Lot> showAll() {
        return lotRepo.findAll();
    }

    public Optional<Lot> getOneByID(Integer id) {
        return lotRepo.findById(id);
    }

    public Lot addLot(Lot lot) {
        return lotRepo.save(lot);
    }

    public void removeLotById(Integer id) {
        lotRepo.deleteById(id);
    }


}
