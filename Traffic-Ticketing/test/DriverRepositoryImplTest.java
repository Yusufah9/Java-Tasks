import com.lastma.data.models.Driver;
import com.lastma.data.repositories.DriverRepository;
import com.lastma.data.repositories.DriverRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DriverRepositoryImplTest {

    private DriverRepository driverRepository;

    @BeforeEach
    public void setUp() {
        driverRepository = new DriverRepositoryImpl();
    }

    @Test
    public void testThatISaveDriverResultIsDriverSavedWithGeneratedId() {
        Driver driver = new Driver("Babajide Sanwo", "LAG-11223-CC", "08055554444", "babajide@example.com", "Marina, Lagos");
        Driver savedDriver = driverRepository.save(driver);

        assertNotNull(savedDriver);
        assertTrue(savedDriver.getId() > 0);
        assertEquals(1, driverRepository.count());
    }

    @Test
    public void testThatISaveTwoDriversResultIsCountEqualsTwo() {
        Driver firstDriver = new Driver("Adewale Adeleke", "LAG-29402-AA", "08012345678", "adewale@example.com", "Ikeja, Lagos");
        Driver secondDriver = new Driver("Chioma Okonkwo", "LAG-78392-BB", "08098765432", "chioma@example.com", "Surulere, Lagos");

        driverRepository.save(firstDriver);
        driverRepository.save(secondDriver);

        long actualCount = driverRepository.count();
        long expectedCount = 2;
        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testThatIFindDriverByIdResultIsCorrectDriverReturned() {
        Driver driver = new Driver("Kudirat Abiola", "LAG-44556-DD", "08033332222", "kudirat@example.com", "Yaba, Lagos");
        Driver savedDriver = driverRepository.save(driver);

        Driver foundDriver = driverRepository.findById(savedDriver.getId());
        assertNotNull(foundDriver);
        assertEquals("Kudirat Abiola", foundDriver.getName());
        assertEquals("LAG-44556-DD", foundDriver.getLicenseNumber());
    }

    @Test
    public void testThatIFindDriverByLicenseNumberResultIsCorrectDriverReturned() {
        Driver driver = new Driver("Femi Otedola", "LAG-99887-EE", "08077778888", "femi@example.com", "Ikoyi, Lagos");
        driverRepository.save(driver);

        Driver foundDriver = driverRepository.findByLicenseNumber("LAG-99887-EE");
        assertNotNull(foundDriver);
        assertEquals("Femi Otedola", foundDriver.getName());
    }

    @Test
    public void testThatIFindDriverByLicenseNumberCaseInsensitiveResultIsCorrectDriverReturned() {
        Driver driver = new Driver("Femi Otedola", "LAG-99887-EE", "08077778888", "femi@example.com", "Ikoyi, Lagos");
        driverRepository.save(driver);

        Driver foundDriver = driverRepository.findByLicenseNumber("lag-99887-ee");
        assertNotNull(foundDriver);
        assertEquals("Femi Otedola", foundDriver.getName());
    }

    @Test
    public void testThatIUpdateExistingDriverResultIsDriverDetailsUpdated() {
        Driver driver = new Driver("Tunde Bakare", "LAG-33221-FF", "08066667777", "tunde@example.com", "Ogba, Lagos");
        Driver savedDriver = driverRepository.save(driver);

        savedDriver.setName("Pastor Tunde Bakare");
        savedDriver.setAddress("Lekki Phase 1, Lagos");
        driverRepository.save(savedDriver);

        assertEquals(1, driverRepository.count());
        Driver updatedDriver = driverRepository.findById(savedDriver.getId());
        assertEquals("Pastor Tunde Bakare", updatedDriver.getName());
        assertEquals("Lekki Phase 1, Lagos", updatedDriver.getAddress());
    }

    @Test
    public void testThatIDeleteDriverByIdResultIsDriverRemovedAndCountDecreased() {
        Driver firstDriver = new Driver("Driver One", "LIC-001", "08011111111", "one@example.com", "Lagos");
        Driver secondDriver = new Driver("Driver Two", "LIC-002", "08022222222", "two@example.com", "Lagos");

        driverRepository.save(firstDriver);
        driverRepository.save(secondDriver);
        assertEquals(2, driverRepository.count());

        driverRepository.deleteById(firstDriver.getId());
        assertEquals(1, driverRepository.count());
        assertNull(driverRepository.findById(firstDriver.getId()));
    }

    @Test
    public void testThatIDeleteDriverResultIsDriverRemovedFromRepository() {
        Driver driver = new Driver("Driver Single", "LIC-SINGLE", "08099999999", "single@example.com", "Lagos");
        Driver savedDriver = driverRepository.save(driver);
        assertEquals(1, driverRepository.count());

        driverRepository.delete(savedDriver);
        assertEquals(0, driverRepository.count());
        assertNull(driverRepository.findById(savedDriver.getId()));
    }

    @Test
    public void testThatIDeleteAllDriversResultIsRepositoryIsEmpty() {
        Driver firstDriver = new Driver("Driver A", "LIC-A", "0801", "a@test.com", "Lagos");
        Driver secondDriver = new Driver("Driver B", "LIC-B", "0802", "b@test.com", "Lagos");

        driverRepository.save(firstDriver);
        driverRepository.save(secondDriver);
        assertEquals(2, driverRepository.count());

        driverRepository.deleteAll();
        assertEquals(0, driverRepository.count());
        assertTrue(driverRepository.findAll().isEmpty());
    }

    @Test
    public void testThatIFindAllDriversResultIsAllSavedDriversReturned() {
        Driver firstDriver = new Driver("Driver A", "LIC-A", "0801", "a@test.com", "Lagos");
        Driver secondDriver = new Driver("Driver B", "LIC-B", "0802", "b@test.com", "Lagos");

        driverRepository.save(firstDriver);
        driverRepository.save(secondDriver);

        ArrayList allDriversList = driverRepository.findAll();
        assertEquals(2, allDriversList.size());
    }

    @Test
    public void testThatICheckDriverExistsByIdResultIsTrueWhenDriverExists() {
        Driver driver = new Driver("Driver Exists", "LIC-EXISTS", "08012344321", "exists@test.com", "Lagos");
        Driver savedDriver = driverRepository.save(driver);

        boolean driverExists = driverRepository.existsById(savedDriver.getId());
        assertTrue(driverExists);
    }

    @Test
    public void testThatICheckDriverExistsByIdResultIsFalseWhenDriverDoesNotExist() {
        boolean driverExists = driverRepository.existsById(999);
        assertFalse(driverExists);
    }
}



// javac -d out -cp junit-platform-console-standalone-1.11.0.jar src/com/lastma/data/models/*.java src/com/lastma/data/repositories/*.java test/*.java && java -jar junit-platform-console-standalone-1.11.0.jar --class-path out --scan-class-path

