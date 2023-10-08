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

    public Hero(String name, String age, String specialPower, String weakness) {
            this.name = name;
            this.age = age;
            this.specialPower = specialPower;
            this.weakness = weakness;
            allHeroes.add(this);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getSpecialPower() {
            return specialPower;
        }

        public void setSpecialPower(String specialPower) {
            this.specialPower = specialPower;
        }

        public String getWeakness() {
            return weakness;
        }

        public void setWeakness(String weakness) {
            this.weakness = weakness;
        }
    }

}

