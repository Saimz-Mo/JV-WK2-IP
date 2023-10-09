package ke.co.safaricom.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroTest {
    @Test
    public void all_returnsAllProperties_true(){
        Hero hero = new Hero("BatMan","40", "flying", "water");
        assertEquals(true, hero instanceof Hero);
    }
    @Test
    public void getName_nameProperty_String() {
        Hero hero = new Hero("BatMan","40", "flying", "water");
        assertEquals("BatMan", hero.getName());
    }
    @Test
    public void getAge_ageProperty_String() {
        Hero hero = new Hero("BatMan","40", "flying", "water");
        assertEquals("40", hero.getAge());

    }
    @Test
    public void getSpecialPower_powerProperty_String() {
        Hero hero = new Hero("BatMan","40", "flying", "water");
        assertEquals("flying", hero.getSpecialPower());

    }
    @Test
    public void getWeakness_weaknessProperty_String() {
        Hero hero = new Hero("BatMan","40", "flying", "water");
        assertEquals("water", hero.getWeakness());

    }
    @Test
    public void getHeroId_idProperty_int() {
        Hero hero = new Hero("BatMan","40", "flying", "water");

        assertEquals(0, hero.getHeroId());

    }

}

