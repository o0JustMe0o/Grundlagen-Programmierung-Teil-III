import java.util.ArrayList;
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

        if (heroList.size() >= 4) {

            while (heroList.size() % 4 != 0) {
                heroList.remove(0);
            }

            while(heroList.size() > 2){

                for (Hero hero : heroList) {
                    hero.resetHero();
                }

                for (int i = 0; i < heroList.size(); i = i+1) {

                    Hero heroOne = heroList.get(i);
                    Hero heroTwo = heroList.get(i+1);

                    Hero winner;

                    System.out.println("~ Round " + (i+1) + "! " + heroOne.getHeroName() + " VS " + heroTwo.getHeroName() + " ~");
                    System.out.println();

                    OneVsOne round = new OneVsOne(heroOne, heroTwo);

                    round.runCombat();

                    heroList.removeIf(hero -> hero.getHeroHp() <= 0);

                    winner = round.determineWinner();

                    System.out.println(winner.getHeroName() + " wins the Round!");
                    System.out.println();
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

        } else {
            System.out.println("Not enough heroes to play. Minimum of 4 needed.");
        }


        /*
        //Round 1

        OneVsOne roundOne = new OneVsOne(heroList);

        roundOne.playerChoice(0);
        roundOne.opponentChoice(1);

        System.out.println("~ Round 1! " + heroList.get(0).getHeroName() + " VS " + heroList.get(1).getHeroName() + " ~");
        System.out.println();

        roundOne.runCombat();

        Hero winnerOne = roundOne.determineWinner();

        System.out.println(winnerOne.getHeroName() + "wins the Round!");
        System.out.println();

        //Round 2

        OneVsOne roundTwo = new OneVsOne(heroList);

        roundTwo.playerChoice(2);
        roundTwo.opponentChoice(3);

        System.out.println("~ Round 2! " + heroList.get(2).getHeroName() + " VS " + heroList.get(3).getHeroName() + " ~");
        System.out.println();

        roundTwo.runCombat();

        Hero winnerTwo = roundTwo.determineWinner();

        System.out.println(winnerTwo.getHeroName() + " wins the Round!");
        System.out.println();

        //List of winners from Round 1 and 2
        List<Hero> finalists = List.of(winnerOne, winnerTwo);

        //Reset Heroes
        winnerOne.resetHero();
        winnerTwo.resetHero();

        //Final Round

        OneVsOne roundFinal = new OneVsOne(finalists);

        roundFinal.playerChoice(0);
        roundFinal.opponentChoice(1);

        System.out.println("~ Final round! " + finalists.get(0).getHeroName() + " VS " + finalists.get(1).getHeroName() + " ~");
        System.out.println();

        roundFinal.runCombat();

        tournamentWinner = roundFinal.determineWinner();
        */
    }

    @Override
    public Hero determineWinner() {
        return tournamentWinner;
    }

}
