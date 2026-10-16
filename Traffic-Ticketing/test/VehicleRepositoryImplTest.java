import com.lastma.data.models.Vehicle;
import com.lastma.data.models.VehicleType;
import com.lastma.data.repositories.VehicleRepository;
import com.lastma.data.repositories.VehicleRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleRepositoryImplTest {

    private VehicleRepository vehicleRepository;

    @BeforeEach
    public void setUp() {
        vehicleRepository = new VehicleRepositoryImpl();
    }

    @Test
    public void testThatISaveVehicleResultIsVehicleSavedWithGeneratedId() {
        Vehicle vehicle = new Vehicle("KJA-123-AB", "Toyota", "Corolla", "Silver", VehicleType.CAR, 1);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        assertNotNull(savedVehicle);
        assertTrue(savedVehicle.getId() > 0);
        assertEquals(1, vehicleRepository.count());
    }

    @Test
    public void testThatISaveTwoVehiclesResultIsCountEqualsTwo() {
        Vehicle firstVehicle = new Vehicle("KJA-123-AB", "Toyota", "Corolla", "Silver", VehicleType.CAR, 1);
        Vehicle secondVehicle = new Vehicle("APP-456-XY", "Honda", "Civic", "Black", VehicleType.CAR, 2);

        vehicleRepository.save(firstVehicle);
        vehicleRepository.save(secondVehicle);

        long actualCount = vehicleRepository.count();
        long expectedCount = 2;
        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testThatIFindVehicleByIdResultIsCorrectVehicleReturned() {
        Vehicle vehicle = new Vehicle("JJJ-999-ZZ", "Mercedes", "C300", "Blue", VehicleType.CAR, 3);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        Vehicle foundVehicle = vehicleRepository.findById(savedVehicle.getId());
        assertNotNull(foundVehicle);
        assertEquals("JJJ-999-ZZ", foundVehicle.getPlateNumber());
        assertEquals("Mercedes", foundVehicle.getMake());
        assertEquals("C300", foundVehicle.getModel());
    }

    @Test
    public void testThatIFindVehicleByPlateNumberResultIsCorrectVehicleReturned() {
        Vehicle vehicle = new Vehicle("MUS-888-AA", "Toyota", "Camry", "Red", VehicleType.CAR, 4);
        vehicleRepository.save(vehicle);

        Vehicle foundVehicle = vehicleRepository.findByPlateNumber("MUS-888-AA");
        assertNotNull(foundVehicle);
        assertEquals("MUS-888-AA", foundVehicle.getPlateNumber());
        assertEquals("Toyota", foundVehicle.getMake());
    }

    @Test
    public void testThatIFindVehicleByPlateNumberCaseInsensitiveResultIsCorrectVehicleReturned() {
        Vehicle vehicle = new Vehicle("MUS-888-AA", "Toyota", "Camry", "Red", VehicleType.CAR, 4);
        vehicleRepository.save(vehicle);

        Vehicle foundVehicle = vehicleRepository.findByPlateNumber("mus-888-aa");
        assertNotNull(foundVehicle);
        assertEquals("MUS-888-AA", foundVehicle.getPlateNumber());
    }

    @Test
    public void testThatIFindVehiclesByDriverIdResultIsAllVehiclesForDriverReturned() {
        Vehicle firstVehicleForDriver = new Vehicle("ABC-111", "Toyota", "Yaris", "Grey", VehicleType.CAR, 10);
        Vehicle secondVehicleForDriver = new Vehicle("ABC-222", "Honda", "Accord", "White", VehicleType.CAR, 10);
        Vehicle vehicleForOtherDriver = new Vehicle("XYZ-999", "Ford", "Explorer", "Black", VehicleType.SUV, 20);

        vehicleRepository.save(firstVehicleForDriver);
        vehicleRepository.save(secondVehicleForDriver);
        vehicleRepository.save(vehicleForOtherDriver);

        ArrayList driverVehiclesList = vehicleRepository.findByDriverId(10);
        assertEquals(2, driverVehiclesList.size());
    }

    @Test
    public void testThatIUpdateExistingVehicleResultIsVehicleDetailsUpdated() {
        Vehicle vehicle = new Vehicle("EPE-555-BB", "Nissan", "Altima", "Green", VehicleType.CAR, 5);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        savedVehicle.setColor("Matte Black");
        savedVehicle.setMake("Nissan Updated");
        vehicleRepository.save(savedVehicle);

        assertEquals(1, vehicleRepository.count());
        Vehicle updatedVehicle = vehicleRepository.findById(savedVehicle.getId());
        assertEquals("Matte Black", updatedVehicle.getColor());
        assertEquals("Nissan Updated", updatedVehicle.getMake());
    }

    @Test
    public void testThatIDeleteVehicleByIdResultIsVehicleRemovedAndCountDecreased() {
        Vehicle firstVehicle = new Vehicle("LIC-101", "Kia", "Rio", "White", VehicleType.CAR, 1);
        Vehicle secondVehicle = new Vehicle("LIC-102", "Hyundai", "Elantra", "Silver", VehicleType.CAR, 2);

        vehicleRepository.save(firstVehicle);
        vehicleRepository.save(secondVehicle);
        assertEquals(2, vehicleRepository.count());

        vehicleRepository.deleteById(firstVehicle.getId());
        assertEquals(1, vehicleRepository.count());
        assertNull(vehicleRepository.findById(firstVehicle.getId()));
    }

    @Test
    public void testThatIDeleteVehicleResultIsVehicleRemovedFromRepository() {
        Vehicle vehicle = new Vehicle("LIC-201", "Peugeot", "508", "Blue", VehicleType.CAR, 3);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        assertEquals(1, vehicleRepository.count());

        vehicleRepository.delete(savedVehicle);
        assertEquals(0, vehicleRepository.count());
        assertNull(vehicleRepository.findById(savedVehicle.getId()));
    }

    @Test
    public void testThatIDeleteAllVehiclesResultIsRepositoryIsEmpty() {
        Vehicle firstVehicle = new Vehicle("AAA-001", "Toyota", "Corolla", "Red", VehicleType.CAR, 1);
        Vehicle secondVehicle = new Vehicle("BBB-002", "Honda", "Civic", "Blue", VehicleType.CAR, 2);

        vehicleRepository.save(firstVehicle);
        vehicleRepository.save(secondVehicle);
        assertEquals(2, vehicleRepository.count());

        vehicleRepository.deleteAll();
        assertEquals(0, vehicleRepository.count());
        assertTrue(vehicleRepository.findAll().isEmpty());
    }

    @Test
    public void testThatIFindAllVehiclesResultIsAllSavedVehiclesReturned() {
        Vehicle firstVehicle = new Vehicle("AAA-001", "Toyota", "Corolla", "Red", VehicleType.CAR, 1);
        Vehicle secondVehicle = new Vehicle("BBB-002", "Honda", "Civic", "Blue", VehicleType.CAR, 2);

        vehicleRepository.save(firstVehicle);
        vehicleRepository.save(secondVehicle);

        ArrayList allVehiclesList = vehicleRepository.findAll();
        assertEquals(2, allVehiclesList.size());
    }

    @Test
    public void testThatICheckVehicleExistsByIdResultIsTrueWhenVehicleExists() {
        Vehicle vehicle = new Vehicle("EXISTS-1", "Toyota", "RAV4", "White", VehicleType.SUV, 1);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        boolean vehicleExists = vehicleRepository.existsById(savedVehicle.getId());
        assertTrue(vehicleExists);
    }

    @Test
    public void testThatICheckVehicleExistsByIdResultIsFalseWhenVehicleDoesNotExist() {
        boolean vehicleExists = vehicleRepository.existsById(999);
        assertFalse(vehicleExists);
    }
}


// javac -d out -cp junit-platform-console-standalone-1.11.0.jar src/com/lastma/data/models/*.java src/com/lastma/data/repositories/*.java test/*.java && java -jar junit-platform-console-standalone-1.11.0.jar --class-path out --scan-class-path

