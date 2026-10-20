import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Tournament extends Combat{
    public String gameMode() {
        return "Tournament";
    }
    public Tournament(List<Hero> heroList) {
        super(heroList);
    }
    private Hero tournamentWinner;

    @Override
    public void runCombat() {

        Random shuffleSeed =  new Random(42);

        Collections.shuffle(heroList , shuffleSeed);
        //Cool Method for randomization: https://www.geeksforgeeks.org/java/collections-shuffle-method-in-java-with-examples/
        //Random shuffleSeed makes Collections.shuffle results repeatable

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
        winnerOne.reset();
        winnerTwo.reset();

        //Final Round

        OneVsOne roundFinal = new OneVsOne(finalists);

        roundFinal.playerChoice(0);
        roundFinal.opponentChoice(1);

        System.out.println("~ Final round! " + finalists.get(0).getHeroName() + " VS " + finalists.get(1).getHeroName() + " ~");
        System.out.println();

        roundFinal.runCombat();

        tournamentWinner = roundFinal.determineWinner();
    }

    @Override
    public Hero determineWinner() {
        return tournamentWinner;
    }

}
