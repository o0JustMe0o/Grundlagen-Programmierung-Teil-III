import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello and welcome to:");

        Scanner input = new Scanner(System.in);
        Scanner menu = new Scanner(System.in);

        int menuChoice = 0;

        while (menuChoice == 0) {
            System.out.println(" _   _                   ___");
            System.out.println("| | | |                 / _ \\");
            System.out.println("| |_| | ___ _ __ ___   / /_\\ \\_ __ ___ _ __   __ _");
            System.out.println("|  _  |/ _ \\ '__/ _ \\  |  _  | '__/ _ \\ '_ \\ / _` |");
            System.out.println("| | | |  __/ | | (_) | | | | | | |  __/ | | | (_| |");
            System.out.println("\\_| |_/\\___|_|  \\___/  \\_| |_/_|  \\___|_| |_|\\__,_|");
            System.out.println();
            //https://patorjk.com/software/taag/#p=display&f=Doom&t=Hero+Arena&x=none&v=4&h=4&w=80&we=false for title font design


            HeroClass paladin = new HeroClass("Paladin", "+3 extra Def (damage negation)");
            HeroClass rouge = new HeroClass("Rouge", "Sneak Attack every 4 turns (double damage)");
            HeroClass fighter = new HeroClass("Fighter", "Action Surge every 3 turns (+8 damage)");
            HeroClass mage = new HeroClass("Mage", "Shield cast every 5 turns (full damage negation)");
            List<Hero> heroes = new ArrayList<>();
            heroes.add(new Hero("Bjorn", paladin , 120, 10, 3));
            heroes.add(new Hero("Mira", rouge, 80, 14, 0));
            heroes.add(new Hero("Kael", fighter, 100, 12, 0));
            heroes.add(new Hero("Luna", mage, 90, 13, 3));

            System.out.println("Play (0)");
            System.out.println("Exit (1)");

            try {
                menuChoice = menu.nextInt();
                if (menuChoice == 0) {

                    System.out.println("Heroes present: " + Hero.countHeroes);
                    System.out.println();
                    for (Hero hero : heroes) {
                        hero.showInfo();
                        System.out.println();
                    }

                    // OneVsOne

                    OneVsOne oneVsOne = new OneVsOne(heroes);

                    System.out.println("Pick your Hero:");

                    for (int i = 0; i < heroes.size(); i++) {
                        System.out.println((i + 1) + " - " + heroes.get(i).heroName);
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
                        System.out.println((i + 1) + " - " + heroes.get(i).heroName);
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
                    System.out.println(winner.heroName + " wins!");
                }
                else if (menuChoice == 1) {
                    System.out.println("Goodbye!");
                    break;
                }
                else {
                    System.out.println("Error: Please enter a valid input!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Try again.");
                input.next();
            }
        }
    }
}