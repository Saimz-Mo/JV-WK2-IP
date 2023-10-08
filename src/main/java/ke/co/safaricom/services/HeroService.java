package ke.co.safaricom.services;

import ke.co.safaricom.models.Hero;

import java.util.ArrayList;
import java.util.List;

public class HeroService {
    private List<Hero> heroList = new ArrayList<>();

    public void addHero(List<Hero>myHeroes, Hero hero) {
        if (myHeroes != null) {
            heroList = myHeroes;
        }
        else
        {
            myHeroes = new ArrayList<>();
        }
        hero.setHeroId(heroList.size()+1);
        heroList.add(hero);
    }

    public List<Hero> getHeroList() {
        return heroList;
    }


}
