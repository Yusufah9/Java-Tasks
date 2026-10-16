import com.lastma.data.models.Ticket;
import com.lastma.data.models.ViolationType;
import com.lastma.data.repositories.TicketRepository;
import com.lastma.data.repositories.TicketRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TicketRepositoryImplTest {

    private TicketRepository ticketRepository;

    @BeforeEach
    public void setUp() {
        ticketRepository = new TicketRepositoryImpl();
    }

    @Test
    public void testThatISaveTicketResultIsTicketSavedWithGeneratedIdAndCountIncreases() {
        Ticket ticket = new Ticket(1, 1, "KJA-123-AB", ViolationType.SPEEDING, 10000.0, "Ikeja Along");
        Ticket savedTicket = ticketRepository.save(ticket);

        assertNotNull(savedTicket);
        assertEquals(1, savedTicket.getId());
        assertEquals(1, ticketRepository.count());
    }

    @Test
    public void testThatISaveTwoTicketsResultIsCountEqualsTwo() {
        Ticket firstTicket = new Ticket(1, 1, "KJA-123-AB", ViolationType.SPEEDING, 10000.0, "Ikeja Along");
        Ticket secondTicket = new Ticket(2, 1, "JJJ-999-ZZ", ViolationType.RUNNING_RED_LIGHT, 15000.0, "Allen Junction");

        ticketRepository.save(firstTicket);
        ticketRepository.save(secondTicket);

        long actualCount = ticketRepository.count();
        long expectedCount = 2;
        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testThatIFindTicketByIdResultIsCorrectTicketReturned() {
        Ticket ticket = new Ticket(1, 2, "JJJ-999-ZZ", ViolationType.RUNNING_RED_LIGHT, 15000.0, "Allen Junction");
        Ticket savedTicket = ticketRepository.save(ticket);

        Ticket foundTicket = ticketRepository.findById(savedTicket.getId());
        assertNotNull(foundTicket);
        assertEquals("JJJ-999-ZZ", foundTicket.getPlateNumber());
        assertEquals(ViolationType.RUNNING_RED_LIGHT, foundTicket.getViolationType());
    }

    @Test
    public void testThatIFindTicketsByDriverIdResultIsAllTicketsForDriverReturned() {
        Ticket firstTicketForDriver = new Ticket(10, 1, "ABC-111", ViolationType.SPEEDING, 10000.0, "Ojota");
        Ticket secondTicketForDriver = new Ticket(10, 2, "ABC-111", ViolationType.ILLEGAL_PARKING, 10000.0, "Yaba");
        Ticket ticketForOtherDriver = new Ticket(20, 1, "XYZ-222", ViolationType.SEATBELT_VIOLATION, 5000.0, "Maryland");

        ticketRepository.save(firstTicketForDriver);
        ticketRepository.save(secondTicketForDriver);
        ticketRepository.save(ticketForOtherDriver);

        ArrayList driverTicketsList = ticketRepository.findByDriverId(10);
        assertEquals(2, driverTicketsList.size());
    }

    @Test
    public void testThatIFindTicketsByPlateNumberResultIsAllTicketsForPlateReturned() {
        Ticket firstTicket = new Ticket(1, 1, "EPE-404-AA", ViolationType.SPEEDING, 10000.0, "Ajah");
        Ticket secondTicket = new Ticket(1, 1, "EPE-404-AA", ViolationType.ONE_WAY_VIOLATION, 50000.0, "Lekki");

        ticketRepository.save(firstTicket);
        ticketRepository.save(secondTicket);

        ArrayList plateTicketsList = ticketRepository.findByPlateNumber("EPE-404-AA");
        assertEquals(2, plateTicketsList.size());
    }

    @Test
    public void testThatIFindTicketsByPlateNumberCaseInsensitiveResultIsCorrectTicketsReturned() {
        Ticket firstTicket = new Ticket(1, 1, "EPE-404-AA", ViolationType.SPEEDING, 10000.0, "Ajah");
        Ticket secondTicket = new Ticket(1, 1, "EPE-404-AA", ViolationType.ONE_WAY_VIOLATION, 50000.0, "Lekki");

        ticketRepository.save(firstTicket);
        ticketRepository.save(secondTicket);

        ArrayList plateTicketsList = ticketRepository.findByPlateNumber("epe-404-aa");
        assertEquals(2, plateTicketsList.size());
    }

    @Test
    public void testThatIUpdateExistingTicketResultAndTicketDetailsUpdated() {
        Ticket ticket = new Ticket(1, 1, "KJA-123-AB", ViolationType.SPEEDING, 10000.0, "Ikeja Along");
        Ticket savedTicket = ticketRepository.save(ticket);

        savedTicket.setPaid(true);
        savedTicket.setAmountPaid(10000.0);
        ticketRepository.save(savedTicket);

        assertEquals(1, ticketRepository.count());
        Ticket updatedTicket = ticketRepository.findById(savedTicket.getId());
        assertTrue(updatedTicket.isPaid());
        assertEquals(10000.0, updatedTicket.getAmountPaid());
    }

    @Test
    public void testThatIDeleteTicketByIdResultIsTicketRemovedAndCountDecreased() {
        Ticket ticket = new Ticket(1, 1, "KJA-123", ViolationType.SPEEDING, 10000.0, "Ikeja");
        Ticket savedTicket = ticketRepository.save(ticket);
        assertEquals(1, ticketRepository.count());

        ticketRepository.deleteById(savedTicket.getId());
        assertEquals(0, ticketRepository.count());
        assertNull(ticketRepository.findById(savedTicket.getId()));
    }

    @Test
    public void testThatIDeleteTicketResultIsTicketRemovedFromRepository() {
        Ticket ticket = new Ticket(2, 1, "KJA-456", ViolationType.ONE_WAY_VIOLATION, 50000.0, "Oshodi");
        Ticket savedTicket = ticketRepository.save(ticket);
        assertEquals(1, ticketRepository.count());

        ticketRepository.delete(savedTicket);
        assertEquals(0, ticketRepository.count());
        assertNull(ticketRepository.findById(savedTicket.getId()));
    }

    @Test
    public void testThatIDeleteAllTicketsResultIsRepositoryIsEmpty() {
        Ticket firstTicket = new Ticket(1, 1, "AAA-111", ViolationType.SPEEDING, 10000.0, "CMS");
        Ticket secondTicket = new Ticket(2, 1, "BBB-222", ViolationType.ILLEGAL_PARKING, 10000.0, "Costain");

        ticketRepository.save(firstTicket);
        ticketRepository.save(secondTicket);
        assertEquals(2, ticketRepository.count());

        ticketRepository.deleteAll();
        assertEquals(0, ticketRepository.count());
        assertTrue(ticketRepository.findAll().isEmpty());
    }

    @Test
    public void testThatIFindAllTicketsResultIsAllSavedTicketsReturned() {
        Ticket firstTicket = new Ticket(1, 1, "AAA-111", ViolationType.SPEEDING, 10000.0, "CMS");
        Ticket secondTicket = new Ticket(2, 1, "BBB-222", ViolationType.ILLEGAL_PARKING, 10000.0, "Costain");

        ticketRepository.save(firstTicket);
        ticketRepository.save(secondTicket);

        ArrayList allTicketsList = ticketRepository.findAll();
        assertEquals(2, allTicketsList.size());
    }

    @Test
    public void testThatICheckTicketExistsByIdResultIsTrueWhenTicketExists() {
        Ticket ticket = new Ticket(1, 1, "CHK-123", ViolationType.SPEEDING, 10000.0, "Ikeja");
        Ticket savedTicket = ticketRepository.save(ticket);

        boolean ticketExists = ticketRepository.existsById(savedTicket.getId());
        assertTrue(ticketExists);
    }

    @Test
    public void testThatICheckTicketExistsByIdResultIsFalseWhenTicketDoesNotExist() {
        boolean ticketExists = ticketRepository.existsById(999);
        assertFalse(ticketExists);
    }
}

// javac -d out -cp junit-platform-console-standalone-1.11.0.jar src/com/lastma/data/models/*.java src/com/lastma/data/repositories/*.java test/*.java && java -jar junit-platform-console-standalone-1.11.0.jar --class-path out --scan-class-path

