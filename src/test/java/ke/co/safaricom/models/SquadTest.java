package ke.co.safaricom.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquadTest {
    @Test
    public void all_returnsAllProperties_true() {
        Squad squad = new Squad("5", "Speeders", "Saving the day");
        assertEquals(true, squad instanceof Squad);
    }
    @Test
    public void getMaxSize_sizeProperty_String() {
        Squad squad = new Squad("5", "Speeders", "Saving the day");
        assertEquals("5", squad.getMaxSize());
    }
    @Test
    public void getSquadName_nameProperty_String() {
        Squad squad = new Squad("5", "Speeders", "Saving the day");
        assertEquals("Speeders", squad.getSquadName());
    }
    @Test
    public void getSquadCause_causeProperty_String() {
        Squad squad = new Squad("5", "Speeders", "Saving the day");
        assertEquals("Saving the day", squad.getSquadCause());
    }
    @Test
    public void getHeroId_idProperty_int() {
        Squad squad = new Squad( "5", "Speeders", "Saving the day");
        assertEquals(0, squad.getId());
    }
}

