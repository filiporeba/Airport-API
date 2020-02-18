package airport.service;

import airport.model.Tourist;
import airport.repository.TouristRepo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;


public class TouristServiceTest {

    @Mock
    TouristRepo touristRepo;

    @InjectMocks
    TouristService touristService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    private final Tourist touristExample = new Tourist("NameTest","SurnameTest","Male","Poland","Note", LocalDate.now(),1);

    private List<Tourist> touristMockList() {
        List<Tourist> touristList = new ArrayList<>();
        touristList.add(new Tourist("NameTest","SurnameTest","Male","Poland","Note", LocalDate.now(),1));
        touristList.add(new Tourist("NameTest","SurnameTest","Male","Poland","Note", LocalDate.now(),1));
        return touristList;
    }

    @Test
    public void shouldAddTourist() {
        when(touristRepo.save(touristExample)).thenReturn(touristExample);

        Tourist touristExpected = touristService.addTourist(touristExample);

        assertNotNull(touristExpected);
        assertThat(touristExpected).isEqualTo(touristExample);
    }

    @Test
    public void shouldFindTouristByName() {
        when(touristRepo.findByName("NameTest")).thenReturn(touristMockList());

        List<Tourist> nameTest = touristService.getByName("NameTest");

        assertNotNull(nameTest);
        assertThat(nameTest).isEqualTo(touristMockList());
    }

    @Test
    public void shouldFindTouristWithIdOne() {
        when(touristRepo.findById(1)).thenReturn(java.util.Optional.of(touristExample));

        Tourist expected = touristService.getOneById(1).get();

        assertThat(expected).isEqualTo(touristExample);
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void shouldThrowExceptionToFindTouristWithIdZero() {
        doThrow(EmptyResultDataAccessException.class).when(touristRepo).deleteById(0);

        touristService.deleteById(0);
    }

    @Test
    public void shouldCountTwoObjectsInList() {
        when(touristRepo.findAll()).thenReturn(touristMockList());

        List<Tourist> allTourists = touristService.getAllTourists();

        assertEquals(2, allTourists.size());
    }
}