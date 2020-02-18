package airport.service;

import airport.model.Flight;
import airport.repository.FlightRepo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;


public class FlightServiceTest {

    @Mock
    FlightRepo flightRepo;

    @InjectMocks
    FlightService flightService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    private final Flight flightExample = new Flight(LocalDateTime.now(), LocalDateTime.now(), 16, 555);

    private List<Flight> flightMockList() {
        List<Flight> flightList = new ArrayList<>();
        flightList.add(new Flight(LocalDateTime.now(), LocalDateTime.now(), 16, 555));
        return flightList;
    }

    @Test
    public void shouldAddFlight() {
        when(flightRepo.save(flightExample)).thenReturn(flightExample);

        Flight result = flightService.addFlight(flightExample);

        assertThat(result).isEqualTo(flightExample);
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void shouldThrowExceptionToFindFlightWithIdZero() {
        doThrow(EmptyResultDataAccessException.class).when(flightRepo).deleteById(0);

        flightService.removeFlightById(0);
    }

    @Test
    public void shouldCountOneElementInList() {
        when(flightRepo.findAll()).thenReturn(flightMockList());

        List<Flight> flightList = flightService.getFlightList();

        assertEquals(1, flightList.size());
    }

    @Test
    public void shouldFindFlightWithIdOne() {
        when(flightRepo.findById(1)).thenReturn(java.util.Optional.of(flightExample));

        Flight result = flightService.getFlightById(1).get();

        assertThat(result).isEqualTo(flightExample);
    }
}