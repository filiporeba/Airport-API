package airport.service;

import airport.model.Flight;
import airport.model.Lot;
import airport.model.Tourist;
import airport.repository.LotRepo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;


public class LotServiceTest {

    @Mock
    LotRepo lotRepo;

    @InjectMocks
    LotService lotService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    private final Flight flightExample = new Flight(LocalDateTime.now(), LocalDateTime.now(), 16, 555);
    private List<Tourist> touristMockList() {
        List<Tourist> touristList = new ArrayList<>();
        touristList.add(new Tourist("NameTest","SurnameTest","Male","Poland","Note", LocalDate.now(),1));
        touristList.add(new Tourist("NameTest","SurnameTest","Male","Poland","Note", LocalDate.now(),1));
        return touristList;
    }
    private final Lot lotExample = new Lot(flightExample,touristMockList());


    @Test
    public void shouldAddLot() {
        when(lotRepo.save(lotExample)).thenReturn(lotExample);

        Lot result = lotService.addLot(lotExample);

        assertThat(result).isEqualTo(lotExample);
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void shouldThrowExceptionToFindLotWithIdZero() {
        doThrow(EmptyResultDataAccessException.class).when(lotRepo).deleteById(0);

        lotService.removeLotById(0);
    }

    @Test
    public void shouldFindLotWithIdOne() {
        when(lotRepo.findById(1)).thenReturn(java.util.Optional.of(lotExample));

        Lot result = lotService.getOneByID(1).get();

        assertThat(result).isEqualTo(lotExample);
    }
}