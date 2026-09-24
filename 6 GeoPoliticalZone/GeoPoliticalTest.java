import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GeoPoliticalZoneTest {

    @Test
    public void testGetZoneByState_ValidStates() {
        assertEquals(GeoPoliticalZone.NORTH_CENTRAL, GeoPoliticalZone.getZoneByState("Kogi"));
        assertEquals(GeoPoliticalZone.SOUTH_WEST, GeoPoliticalZone.getZoneByState("Lagos"));
        assertEquals(GeoPoliticalZone.SOUTH_SOUTH, GeoPoliticalZone.getZoneByState("Rivers"));
    }

    @Test
    public void testGetZoneByState_CaseInsensitive() {
        assertEquals(GeoPoliticalZone.NORTH_EAST, GeoPoliticalZone.getZoneByState("adamawa"));
        assertEquals(GeoPoliticalZone.NORTH_WEST, GeoPoliticalZone.getZoneByState("KANO"));
    }

    @Test
    public void testGetZoneByState_InvalidState() {
        assertNull(GeoPoliticalZone.getZoneByState("UnknownState"));
        assertNull(GeoPoliticalZone.getZoneByState(null));
    }

    @Test
    public void testGetStates_LengthAndValues() {
        GeoPoliticalZone zone = GeoPoliticalZone.SOUTH_EAST;
        String[] states = zone.getStates();

        assertEquals(5, states.length);
        assertArrayEquals(new String[]{"Abia", "Anambra", "Ebonyi", "Enugu", "Imo"}, states);
    }
}
