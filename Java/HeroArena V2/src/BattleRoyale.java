import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BattleRoyale extends Combat {

    private Hero heroOne;
    private Hero heroTwo;

    public String gameMode() {
        return "Battle Royale";
    }

    public BattleRoyale(List<Hero> heroList) {
        super(heroList);
    }

    private Hero battleRoyaleWinner;

    @Override
    public void runCombat() {

        Collections.shuffle(heroList , Hero.getRandom());

        while (heroList.size() > 1) {
            heroOne = heroList.get(Hero.getRandom().nextInt(heroList.size()));
            do {
                heroTwo = heroList.get(Hero.getRandom().nextInt(heroList.size()));
            } while (heroTwo == heroOne);

            heroOne.fight(heroTwo);

            heroList.removeIf(hero -> hero.getHeroHp() <= 0);
            /* Lambda: for every hero in heroList getHeroHp()
                            if getHeroHp() <= 0
                                -> remove that hero from heroList*/
        }

        battleRoyaleWinner = heroList.getFirst();
    }

    @Override
    public Hero determineWinner() {
        return battleRoyaleWinner;
    }
}