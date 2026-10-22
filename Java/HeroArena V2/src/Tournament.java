import java.util.Collections;
import java.util.List;

public class Tournament extends Combat{
    public String gameMode() {
        return "Tournament";
    }
    private Hero tournamentWinner;

    public Tournament(List<Hero> heroList) {
        super(heroList);
    }

    @Override
    public void runCombat() {

        Collections.shuffle(heroList , Hero.getRandom());

        int roundCounter = 1;

            while(heroList.size() > 2){

                for (Hero hero : heroList) {
                    hero.resetHero();
                }

                for (int i = 0; i+1 < heroList.size(); i = i+1) {

                    Hero heroOne = heroList.get(i);
                    Hero heroTwo = heroList.get(i+1);

                    Hero winner;

                    System.out.println("~ Round " + roundCounter + "! " + heroOne.getHeroName() + " VS " + heroTwo.getHeroName() + " ~");
                    System.out.println();

                    OneVsOne round = new OneVsOne(heroOne, heroTwo);

                    round.runCombat();

                    heroList.removeIf(hero -> hero.getHeroHp() <= 0);

                    winner = round.determineWinner();

                    System.out.println(winner.getHeroName() + " wins the Round!");
                    System.out.println();

                    roundCounter++;
                }
            }

            heroList.getFirst().resetHero();
            heroList.getLast().resetHero();

            OneVsOne roundFinal = new OneVsOne(heroList);

            roundFinal.heroOneChoice(0);
            roundFinal.heroTwoChoice(1);

            System.out.println("~ Final round! " + heroList.get(0).getHeroName() + " VS " + heroList.get(1).getHeroName() + " ~");
            System.out.println();

            roundFinal.runCombat();

            tournamentWinner = roundFinal.determineWinner();
    }

    @Override
    public Hero determineWinner() {
        return tournamentWinner;
    }

}
