import com.lastma.data.models.Officer;
import com.lastma.data.repositories.OfficerRepository;
import com.lastma.data.repositories.OfficerRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class OfficerRepositoryImplTest {

    private OfficerRepository officerRepository;

    @BeforeEach
    public void setUp() {
        officerRepository = new OfficerRepositoryImpl();
    }

    @Test
    public void testThatISaveOfficerResultIsOfficerSavedWithGeneratedId() {
        Officer officer = new Officer("Officer Amaka", "LMA-101", "08012345678", "amaka@lastma.gov.ng");
        Officer savedOfficer = officerRepository.save(officer);

        assertNotNull(savedOfficer);
        assertTrue(savedOfficer.getId() > 0);
        assertEquals(1, officerRepository.count());
    }

    @Test
    public void testThatISaveTwoOfficersResultIsCountEqualsTwo() {
        Officer firstOfficer = new Officer("Officer Amaka", "LMA-101", "08012345678", "amaka@lastma.gov.ng");
        Officer secondOfficer = new Officer("Officer Babatunde", "LMA-102", "08087654321", "babatunde@lastma.gov.ng");

        officerRepository.save(firstOfficer);
        officerRepository.save(secondOfficer);

        long actualCount = officerRepository.count();
        long expectedCount = 2;
        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testThatIFindOfficerByIdResultIsCorrectOfficerReturned() {
        Officer officer = new Officer("Officer Sunday", "LMA-103", "08033334444", "sunday@lastma.gov.ng");
        Officer savedOfficer = officerRepository.save(officer);

        Officer foundOfficer = officerRepository.findById(savedOfficer.getId());
        assertNotNull(foundOfficer);
        assertEquals("Officer Sunday", foundOfficer.getName());
        assertEquals("LMA-103", foundOfficer.getBadgeNumber());
    }

    @Test
    public void testThatIFindOfficerByBadgeNumberResultIsCorrectOfficerReturned() {
        Officer officer = new Officer("Officer Kelechi", "LMA-104", "08055556666", "kelechi@lastma.gov.ng");
        officerRepository.save(officer);

        Officer foundOfficer = officerRepository.findByBadgeNumber("LMA-104");
        assertNotNull(foundOfficer);
        assertEquals("Officer Kelechi", foundOfficer.getName());
    }

    @Test
    public void testThatIFindOfficerByBadgeNumberCaseInsensitiveResultIsCorrectOfficerReturned() {
        Officer officer = new Officer("Officer Kelechi", "LMA-104", "08055556666", "kelechi@lastma.gov.ng");
        officerRepository.save(officer);

        Officer foundOfficer = officerRepository.findByBadgeNumber("lma-104");
        assertNotNull(foundOfficer);
        assertEquals("Officer Kelechi", foundOfficer.getName());
    }

    @Test
    public void testThatIUpdateExistingOfficerResultIsOfficerDetailsUpdated() {
        Officer officer = new Officer("Officer Taiwo", "LMA-105", "08077778888", "taiwo@lastma.gov.ng");
        Officer savedOfficer = officerRepository.save(officer);

        savedOfficer.setName("Senior Officer Taiwo");
        savedOfficer.setPhoneNumber("08099990000");
        officerRepository.save(savedOfficer);

        assertEquals(1, officerRepository.count());
        Officer updatedOfficer = officerRepository.findById(savedOfficer.getId());
        assertEquals("Senior Officer Taiwo", updatedOfficer.getName());
        assertEquals("08099990000", updatedOfficer.getPhoneNumber());
    }

    @Test
    public void testThatIDeleteOfficerByIdResultIsOfficerRemovedAndCountDecreased() {
        Officer firstOfficer = new Officer("Officer First", "LMA-201", "08011112222", "first@lastma.gov.ng");
        Officer secondOfficer = new Officer("Officer Second", "LMA-202", "08022223333", "second@lastma.gov.ng");

        officerRepository.save(firstOfficer);
        officerRepository.save(secondOfficer);
        assertEquals(2, officerRepository.count());

        officerRepository.deleteById(firstOfficer.getId());
        assertEquals(1, officerRepository.count());
        assertNull(officerRepository.findById(firstOfficer.getId()));
    }

    @Test
    public void testThatIDeleteOfficerResultIsOfficerRemovedFromRepository() {
        Officer officer = new Officer("Officer Single", "LMA-301", "08099991111", "single@lastma.gov.ng");
        Officer savedOfficer = officerRepository.save(officer);
        assertEquals(1, officerRepository.count());

        officerRepository.delete(savedOfficer);
        assertEquals(0, officerRepository.count());
        assertNull(officerRepository.findById(savedOfficer.getId()));
    }

    @Test
    public void testThatIDeleteAllOfficersResultIsRepositoryIsEmpty() {
        Officer firstOfficer = new Officer("Officer One", "LMA-401", "0801", "one@lastma.gov.ng");
        Officer secondOfficer = new Officer("Officer Two", "LMA-402", "0802", "two@lastma.gov.ng");

        officerRepository.save(firstOfficer);
        officerRepository.save(secondOfficer);
        assertEquals(2, officerRepository.count());

        officerRepository.deleteAll();
        assertEquals(0, officerRepository.count());
        assertTrue(officerRepository.findAll().isEmpty());
    }

    @Test
    public void testThatIFindAllOfficersResultIsAllSavedOfficersReturned() {
        Officer firstOfficer = new Officer("Officer Alpha", "LMA-501", "0801111", "alpha@lastma.gov.ng");
        Officer secondOfficer = new Officer("Officer Beta", "LMA-502", "0802222", "beta@lastma.gov.ng");

        officerRepository.save(firstOfficer);
        officerRepository.save(secondOfficer);

        ArrayList allOfficersList = officerRepository.findAll();
        assertEquals(2, allOfficersList.size());
    }

    @Test
    public void testThatICheckOfficerExistsByIdResultIsTrueWhenOfficerExists() {
        Officer officer = new Officer("Officer Check", "LMA-601", "0803333", "check@lastma.gov.ng");
        Officer savedOfficer = officerRepository.save(officer);

        boolean officerExists = officerRepository.existsById(savedOfficer.getId());
        assertTrue(officerExists);
    }

    @Test
    public void testThatICheckOfficerExistsByIdResultIsFalseWhenOfficerDoesNotExist() {
        boolean officerExists = officerRepository.existsById(999);
        assertFalse(officerExists);
    }
}


// javac -d out -cp junit-platform-console-standalone-1.11.0.jar src/com/lastma/data/models/*.java src/com/lastma/data/repositories/*.java test/*.java && java -jar junit-platform-console-standalone-1.11.0.jar --class-path out --scan-class-path

