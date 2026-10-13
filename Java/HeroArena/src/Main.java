import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome to:");

        ArrayList<Integer> heroNumber = new ArrayList<>();
        heroNumber.add(1);
        heroNumber.add(2);
        heroNumber.add(3);
        heroNumber.add(4);

        ArrayList<String> heroNames = new ArrayList<>();
        heroNames.add("Bjorn");
        heroNames.add("Mira");
        heroNames.add("Kael");
        heroNames.add("Luna");

        ArrayList<String> heroClass = new ArrayList<>();
        heroClass.add("Paladin");
        heroClass.add("Rouge");
        heroClass.add("Fighter");
        heroClass.add("Mage");

        ArrayList<Integer> heroHp = new ArrayList<>();
        heroHp.add(120);
        heroHp.add(80);
        heroHp.add(100);
        heroHp.add(90);

        ArrayList<Integer> heroAt = new ArrayList<>();
        heroAt.add(10);
        heroAt.add(14);
        heroAt.add(12);
        heroAt.add(13);

        Random r= new Random(42);

        Scanner menu = new Scanner(System.in);
        Scanner userInput = new Scanner(System.in);
        
        int menuChoice = 0;

        while (menuChoice == 0) {

            System.out.println();
            System.out.println(" _   _                   ___");
            System.out.println("| | | |                 / _ \\");
            System.out.println("| |_| | ___ _ __ ___   / /_\\ \\_ __ ___ _ __   __ _");
            System.out.println("|  _  |/ _ \\ '__/ _ \\  |  _  | '__/ _ \\ '_ \\ / _` |");
            System.out.println("| | | |  __/ | | (_) | | | | | | |  __/ | | | (_| |");
            System.out.println("\\_| |_/\\___|_|  \\___/  \\_| |_/_|  \\___|_| |_|\\__,_|");
            System.out.println();
            //https://patorjk.com/software/taag/#p=display&f=Doom&t=Hero+Arena&x=none&v=4&h=4&w=80&we=false for title font design

            System.out.println("Play (0)");
            System.out.println("Exit (1)");

            try {
                menuChoice = menu.nextInt();

                if (menuChoice == 0) {
                    System.out.println("Meet the heros: ");

                    int i;

                    for (i = 0; i < heroNumber.size(); i++) {
                        System.out.println(heroNumber.get(i) + ": " + heroNames.get(i) + " (" +  heroClass.get(i) + ")");
                    }

                    System.out.println();

                    int playerChoice = 0;

                    while (true) {
                        try {
                            System.out.println("Choose your fighter (Input Hero Number and press Enter.):");
                            playerChoice = userInput.nextInt();

                            if (playerChoice >= 1 && playerChoice <= heroNumber.size()) {
                                break;
                            }

                            System.out.println("Error: Please enter a valid Hero Number!");

                        } catch (InputMismatchException e) {
                            System.out.println("Error: Please enter a valid Hero Number!");
                            userInput.next();
                        }
                    }

                    System.out.println();

                    int opponentChoice = 0;

                    int opponentType = 0;

                    while (true) {
                        try {
                            System.out.println("Choose your opponent or pick one at random? (0 for choice, 1 for random):");
                            opponentType = userInput.nextInt();

                            if (opponentType == 0 || opponentType == 1) {
                                break;
                            }

                            System.out.println("Error: Please choose a valid modi!");

                        } catch (InputMismatchException e) {
                            System.out.println("Error: Please choose a valid modi!");
                            userInput.next();
                        }
                    }

                    if (opponentType == 0) {
                        while (true) {
                            try {
                                System.out.println("Choose your opponent (Input Hero Number and press Enter, don't pick your Hero again!):");
                                opponentChoice = userInput.nextInt();

                                if (opponentChoice >= 1 && opponentChoice <= heroNumber.size() && opponentChoice != playerChoice) {
                                    break;
                                }

                                System.out.println("Error: Please enter a valid Hero Number!");

                            } catch (InputMismatchException e) {
                                System.out.println("Error: Please enter a valid Hero Number!");
                                userInput.next();
                            }
                        }
                    }
                    else {
                        do {
                            opponentChoice = r.nextInt(heroNumber.size()) + 1;
                        } while (opponentChoice == playerChoice);
                    }



                    System.out.println();

                    while (heroHp.get(playerChoice - 1) > 0 && heroHp.get(opponentChoice - 1) > 0) {

                        int damagePlayer = heroAt.get(playerChoice - 1) + r.nextInt(5);

                        System.out.println(heroNames.get(playerChoice - 1) + " attackiert " + heroNames.get(opponentChoice - 1) + "!");

                        System.out.println(heroNames.get(playerChoice - 1) + " fügt " + heroNames.get(opponentChoice - 1) + " " + damagePlayer + " Schaden zu!");
                        System.out.println("Übrige HP von " + heroNames.get(opponentChoice - 1) + ": " + (heroHp.get(opponentChoice - 1) - damagePlayer));
                        heroHp.set(opponentChoice - 1, heroHp.get(opponentChoice - 1) - damagePlayer);

                        System.out.println();

                        if (heroHp.get(opponentChoice - 1) > 0) {

                            int damageOpponent = heroAt.get(opponentChoice - 1) + r.nextInt(5);

                            System.out.println(heroNames.get(opponentChoice - 1) + " attackiert " + heroNames.get(playerChoice - 1) + "!");
                            System.out.println(heroNames.get(opponentChoice - 1) + " fügt " + heroNames.get(playerChoice - 1) + " " + damageOpponent + " Schaden zu!");
                            System.out.println("Übrige HP von " + heroNames.get(playerChoice - 1) + ": " + (heroHp.get(playerChoice - 1) - damageOpponent));
                            heroHp.set(playerChoice - 1, heroHp.get(playerChoice - 1) - damageOpponent);

                            System.out.println();
                        }
                        else  {
                            System.out.println(heroNames.get(playerChoice - 1) + " hat gewonnen! " + heroNames.get(opponentChoice - 1) + " wurde besiegt!");
                            break;
                        }
                    }

                    if (heroHp.get(playerChoice - 1) <= 0) {
                        System.out.println(heroNames.get(opponentChoice - 1) + " hat gewonnen! " + heroNames.get(playerChoice - 1) + " wurde besiegt!");
                    }
                }
                else if (menuChoice == 1) {
                    System.out.println("Goodbye!");
                    break;
                }
                else {
                    System.out.println("Error: Please enter a valid input!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid input!");
                userInput.next();
            }
        }

    }
}