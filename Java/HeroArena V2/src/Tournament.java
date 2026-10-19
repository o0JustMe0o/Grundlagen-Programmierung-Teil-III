import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Tournament {
    private List<Hero> heroList;

    public Tournament(List<Hero> heroList) {
        this.heroList = heroList;
    }

    public Hero startTournament() {

        Random shuffleSeed =  new Random(42);

        Collections.shuffle(heroList /*, shuffleSeed*/);
        //Cool Method for randomization: https://www.geeksforgeeks.org/java/collections-shuffle-method-in-java-with-examples/
        //Random shuffleSeed makes Collections.shuffle results repeatable

        //Round 1

        OneVsOne roundOne = new OneVsOne(heroList);

        roundOne.playerChoice(0);
        roundOne.opponentChoice(1);

        System.out.println("~ Round 1! " + heroList.get(0).getHeroName() + " VS " + heroList.get(1).getHeroName() + " ~");
        System.out.println();

        roundOne.startGame();

        Hero winnerOne = roundOne.determineWinner();

        //Round 2

        OneVsOne roundTwo = new OneVsOne(heroList);

        roundTwo.playerChoice(2);
        roundTwo.opponentChoice(3);

        System.out.println("~ Round 2! " + heroList.get(2).getHeroName() + " VS " + heroList.get(3).getHeroName() + " ~");
        System.out.println();

        roundTwo.startGame();

        Hero winnerTwo = roundTwo.determineWinner();

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

        roundFinal.startGame();

        Hero winnerFinal = roundFinal.determineWinner();

        return winnerFinal;
    }
}
