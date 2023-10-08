package ke.co.safaricom.models;

import java.util.ArrayList;
import java.util.List;
public class Hero {
    private String name;
    private String age;
    private String specialPower;
    private String weakness;
    private int heroId;

    private static List<Hero>allHeroes = new ArrayList<>();

    public static List<Hero> getAllHeroes() {
        return allHeroes;
    }

    public static void  setAllHeroes(List<Hero> allHeroes) {
        Hero.allHeroes = allHeroes;

    }

    public int getHeroId() {
        return heroId;
    }

    public void setHeroId(int heroId) {
        this.heroId = heroId;
    }
}
