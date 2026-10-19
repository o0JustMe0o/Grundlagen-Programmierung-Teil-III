import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello and welcome to:");

        Scanner input = new Scanner(System.in);

        int menuChoice = 0;
        int gameChoice = 0;

        while (menuChoice == 0) {
            System.out.println(" _   _                   ___");
            System.out.println("| | | |                 / _ \\");
            System.out.println("| |_| | ___ _ __ ___   / /_\\ \\_ __ ___ _ __   __ _");
            System.out.println("|  _  |/ _ \\ '__/ _ \\  |  _  | '__/ _ \\ '_ \\ / _` |");
            System.out.println("| | | |  __/ | | (_) | | | | | | |  __/ | | | (_| |");
            System.out.println("\\_| |_/\\___|_|  \\___/  \\_| |_/_|  \\___|_| |_|\\__,_|");
            System.out.println();
            //https://patorjk.com/software/taag/#p=display&f=Doom&t=Hero+Arena&x=none&v=4&h=4&w=80&we=false for title font design


            List<Hero> heroes = new ArrayList<>();
            heroes.add(new Paladin("Bjorn","Paladin","+2 extra Def (damage negation)", 120, 120, 10, 3));
            heroes.add(new Rogue("Mira","Rogue","Sneak Attack every 4 turns (double damage)", 80,80, 14, 0));
            heroes.add(new Fighter("Kael","Fighter","Action Surge every 3 turns (+8 damage)", 100,100, 12, 0));
            heroes.add(new Mage("Luna","Mage","Shield cast every 5 turns (full damage negation)", 90,90, 13, 3));
            heroes.add(new Hero("Jimmy the Wall","Normie", "Your average Joe (or Jimmy in this case)",50,50, 15, 8));
            heroes.add(new Cleric("Pious Pete","Cleric", "Casts heal on self at half health (+25 HP).",75,75, 11, 3));

            System.out.println("Play (0)");
            System.out.println("Exit (1)");

            try {
                menuChoice = input.nextInt();
                if (menuChoice == 0) {

                    System.out.println("Heroes present: " + heroes.size());
                    System.out.println();
                    for (Hero hero : heroes) {
                        hero.showInfo();
                        System.out.println();
                    }

                    while (true) {
                        try {
                            System.out.println("Choose your play mode:");
                            System.out.println("Player vs PC (0)");
                            System.out.println("Tournament (1)");

                            gameChoice = input.nextInt();

                            if (gameChoice == 0) {

                                // OneVsOne
                                OneVsOne oneVsOne = new OneVsOne(heroes);

                                System.out.println("Pick your Hero:");

                                for (int i = 0; i < heroes.size(); i++) {
                                    System.out.println((i + 1) + " - " + heroes.get(i).getHeroName());
                                }

                                int playerChoice = 0;

                                while (true) {
                                    try {
                                        playerChoice = input.nextInt();
                                        if (playerChoice >= 1 && playerChoice <= heroes.size()) {
                                            break;
                                        } System.out.println("Invalid input. Try again.");

                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input. Try again.");
                                        input.next();
                                    }
                                }

                                oneVsOne.playerChoice(playerChoice - 1);

                                System.out.println("Pick your Opponent (Don't pick your Hero again):");

                                for (int i = 0; i < heroes.size(); i++) {
                                    System.out.println((i + 1) + " - " + heroes.get(i).getHeroName());
                                }

                                int opponentChoice = 0;

                                while (true) {
                                    try {
                                        opponentChoice = input.nextInt();
                                        if (opponentChoice >= 1 && opponentChoice <= heroes.size() && opponentChoice != playerChoice) {
                                            break;
                                        } System.out.println("Invalid input. Try again.");

                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input. Try again.");
                                        input.next();
                                    }
                                }

                                oneVsOne.opponentChoice(opponentChoice - 1);

                                oneVsOne.startGame();

                                Hero winner = oneVsOne.determineWinner();
                                System.out.println(winner.getHeroName() + " wins!");
                                break;
                            }

                            else if (gameChoice == 1) {

                                //Tournament
                                Tournament tournament = new Tournament(heroes);

                                Hero winner = tournament.startTournament();
                                System.out.println(winner.getHeroName() + " wins the tournament!");

                                break;
                            }
                            System.out.println("Invalid input. Try again.");

                        } catch (InputMismatchException e) {
                            input.next();
                        }
                    }
                }
                else if (menuChoice == 1) {
                    System.out.println("Goodbye!");
                    break;
                }
                else {
                    System.out.println("Invalid input. Try again.");
                    menuChoice = 0;
                }

            } catch (InputMismatchException e) {
                System.out.println("Menu Error");
                input.next();
            }
        }

    }
}

/*
⠀  ⠀  (\__/)
      (•ㅅ•)      Don’t talk to
  ＿ ノヽ ノ＼_＿     me or my son
 /　`/ ⌒Ｙ⌒ Ｙ  ヽ     ever again.
( 　(三ヽ人　 /　  |
|　ﾉ⌒＼ ￣￣ヽ   ノ
ヽ＿＿＿＞､＿ _ ／
    ｜( 王 ﾉ〈   (\__/)
    /ﾐ`ー――彡\ (•ㅅ•)
   / ╰     ╯   \/   \>


*/