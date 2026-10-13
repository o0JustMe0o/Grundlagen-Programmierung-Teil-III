import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello and welcome to:");

        Random r= new Random(42);
        int counterBR = 0;
        int counterTourn = 0;

        Scanner menu = new Scanner(System.in);
        Scanner userInput = new Scanner(System.in);
        
        int menuChoice = 0;

        //game-loop menu
        while (menuChoice == 0) {

            //lists for hero attributes
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
            heroClass.add("Paladin");   // extra defense +3
            heroClass.add("Rouge");     // crit hit (double damage) after 4 tuns
            heroClass.add("Fighter");   // extra damage +8 every 3 turns
            heroClass.add("Mage");      // "I cast shield!" full damage negation every 5 turns

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

            ArrayList<Integer> heroDef = new ArrayList<>();
            heroDef.add(3);
            heroDef.add(0);
            heroDef.add(0);
            heroDef.add(3);

            //menu title card
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

            System.out.println();
            System.out.println("Battle Royale rounds: " + counterBR);
            System.out.println("Tournament rounds: " + counterTourn);
            System.out.println();

            //menu choice
            try {
                menuChoice = menu.nextInt();

                if (menuChoice == 0) {

                    int playModi = 1;

                    while (true) {

                        System.out.println("Meet the heros: ");

                        //for loop to list the heroes
                        int i;

                        for (i = 0; i < heroNumber.size(); i++) {
                            System.out.println(heroNumber.get(i) + ": " + heroNames.get(i) + " (" +  heroClass.get(i) + ", HP: "  + heroHp.get(i) + ", Atk: " + heroAt.get(i) + ")");
                        }

                        System.out.println();

                        //play modi choice
                        try {
                            System.out.println("Choose your play mode:");
                            System.out.println("Player vs PC (0)");
                            System.out.println("Battle Royale (1)");
                            System.out.println("Tournament (2)");
                            playModi = userInput.nextInt();

                            if (playModi == 0) {
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

                                    System.out.println("The battle commences!");

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

                                int playerTurnCount = 0;
                                int opponentTurnCount = 0;

                                //combat loop
                                while (heroHp.get(playerChoice - 1) > 0 && heroHp.get(opponentChoice - 1) > 0) {

                                    int damagePlayer;

                                    playerTurnCount++;

                                    switch (heroClass.get(playerChoice - 1)) {


                                        case "Rouge":
                                            if (playerTurnCount % 4 != 0) {
                                                damagePlayer = heroAt.get(playerChoice - 1) + r.nextInt(5) - heroDef.get(opponentChoice -1);
                                            }
                                            else {
                                                System.out.println("Sneak attack!");
                                                damagePlayer = ((heroAt.get(playerChoice - 1) + r.nextInt(5)) * 2 ) - heroDef.get(opponentChoice -1);
                                            }
                                            break;

                                        case "Fighter":
                                            if (playerTurnCount % 3 != 0) {
                                                damagePlayer = heroAt.get(playerChoice - 1) + r.nextInt(5) - heroDef.get(opponentChoice -1);
                                            }
                                            else {
                                                System.out.println("Action Surge! *bonk* *bonk* *bonk*");
                                                damagePlayer = (heroAt.get(playerChoice - 1) + r.nextInt(5) + 8 ) - heroDef.get(opponentChoice -1);
                                            }
                                            break;

                                        default:
                                            damagePlayer = heroAt.get(playerChoice - 1) + r.nextInt(5) - heroDef.get(opponentChoice -1);
                                    }


                                    if (heroClass.get(opponentChoice -1).equals("Paladin")) {
                                        damagePlayer = heroAt.get((playerChoice - 1) + r.nextInt(5) - 3) - heroDef.get(opponentChoice -1);
                                    }

                                    if (heroClass.get(opponentChoice -1).equals("Mage") && playerTurnCount % 5 == 0) {
                                        System.out.println(heroNames.get(opponentChoice -1) + ": I cast shield!");
                                        damagePlayer = 0;
                                    }


                                    System.out.println(heroNames.get(playerChoice - 1) + " attacks " + heroNames.get(opponentChoice - 1) + "!");

                                    System.out.println(heroNames.get(playerChoice - 1) + " deals " + heroNames.get(opponentChoice - 1) + " " + damagePlayer + " damage! (Damage negation from armour: " + heroDef.get(opponentChoice -1) + ")");
                                    System.out.println(heroNames.get(opponentChoice - 1) + " has " + (heroHp.get(opponentChoice - 1) - damagePlayer) + " HP left.");

                                    heroHp.set(opponentChoice - 1, heroHp.get(opponentChoice - 1) - damagePlayer);

                                    System.out.println();

                                    if (heroHp.get(opponentChoice - 1) > 0) {

                                        int damageOpponent;

                                        opponentTurnCount++;

                                        switch (heroClass.get(opponentChoice - 1)) {


                                            case "Rouge":
                                                if (opponentTurnCount % 4 != 0) {
                                                    damageOpponent = heroAt.get(opponentChoice - 1) + r.nextInt(5) - heroDef.get(playerChoice -1);
                                                }
                                                else {
                                                    System.out.println("Sneak attack!");
                                                    damageOpponent = ((heroAt.get(opponentChoice - 1) + r.nextInt(5)) * 2 ) - heroDef.get(playerChoice -1);
                                                }
                                                break;

                                            case "Fighter":
                                                if (opponentTurnCount % 3 != 0) {
                                                    damageOpponent = heroAt.get(opponentChoice - 1) + r.nextInt(5) - heroDef.get(playerChoice -1);
                                                }
                                                else {
                                                    System.out.println("Action Surge! *bonk* *bonk* *bonk*");
                                                    damageOpponent = (heroAt.get(opponentChoice - 1) + r.nextInt(5) + 8 ) - heroDef.get(playerChoice -1);
                                                }
                                                break;

                                            default:
                                                damageOpponent = heroAt.get(opponentChoice - 1) + r.nextInt(5) - heroDef.get(playerChoice -1);
                                        }


                                        if (heroClass.get(playerChoice -1).equals("Paladin")) {
                                            damageOpponent = heroAt.get(opponentChoice - 1) + r.nextInt(5) - heroDef.get(playerChoice -1) -3;
                                        }

                                        if (heroClass.get(playerChoice -1).equals("Mage") && opponentTurnCount % 5 == 0) {
                                            System.out.println(heroNames.get(playerChoice -1) + ": I cast shield!");
                                            damageOpponent = 0;
                                        }

                                        System.out.println(heroNames.get(opponentChoice - 1) + " attacks " + heroNames.get(playerChoice - 1) + "!");
                                        System.out.println(heroNames.get(opponentChoice - 1) + " deals " + heroNames.get(playerChoice - 1) + " " + damageOpponent + " damage! (Damage negation from armour: " + heroDef.get(playerChoice -1) + ")");
                                        System.out.println(heroNames.get(playerChoice - 1) + " has " + (heroHp.get(playerChoice - 1) - damageOpponent) + " HP left.");
                                        heroHp.set(playerChoice - 1, heroHp.get(playerChoice - 1) - damageOpponent);

                                        System.out.println();
                                    }
                                    else  {
                                        System.out.println(heroNames.get(playerChoice - 1) + " wins! " + heroNames.get(opponentChoice - 1) + " has been defeated!");
                                        break;
                                    }
                                }

                                if (heroHp.get(playerChoice - 1) <= 0) {
                                    System.out.println(heroNames.get(opponentChoice - 1) + " wins! " + heroNames.get(playerChoice - 1) + " has been defeated!");
                                }
                                break;
                            }
                            else if (playModi == 1) {

                                System.out.println("The Battle Royale commences!");

                                //battle royale bs
                                int playerChoice = r.nextInt(heroNumber.size()) + 1;   //random hero...
                                int opponentChoice;

                                do {
                                    opponentChoice = r.nextInt(heroNumber.size()) + 1; //...vs random hero
                                } while (opponentChoice == playerChoice);

                                System.out.println();

                                //for loop to see how many heroes have more than 0 HP left to continue combat loop
                                int aliveHeroes = 0;

                                for (int hp : heroHp) {
                                    if (hp > 0) {
                                        aliveHeroes++;
                                    }
                                }

                                //combat loop
                                while (aliveHeroes > 1) {

                                    do {
                                        opponentChoice = r.nextInt(heroNumber.size()) + 1;
                                    } while (opponentChoice == playerChoice || heroHp.get(opponentChoice -1) <= 0);

                                    do {
                                        playerChoice = r.nextInt(heroNumber.size()) + 1;
                                    } while (playerChoice == opponentChoice || heroHp.get(playerChoice -1) <= 0);

                                    int damagePlayer = heroAt.get(playerChoice - 1) + r.nextInt(5) - heroDef.get(opponentChoice -1);

                                    System.out.println(heroNames.get(playerChoice - 1) + " attacks " + heroNames.get(opponentChoice - 1) + "!");

                                    System.out.println(heroNames.get(playerChoice - 1) + " deals " + heroNames.get(opponentChoice - 1) + " " + damagePlayer + " damage! (Damage negation from armour: " + heroDef.get(opponentChoice -1) + ")");
                                    System.out.println(heroNames.get(opponentChoice - 1) + " has " + (heroHp.get(opponentChoice - 1) - damagePlayer) + " HP left.");
                                    heroHp.set(opponentChoice - 1, heroHp.get(opponentChoice - 1) - damagePlayer);

                                    System.out.println();

                                    if (heroHp.get(opponentChoice - 1) > 0) {

                                        do {
                                            opponentChoice = r.nextInt(heroNumber.size()) + 1;
                                        } while (opponentChoice == playerChoice || heroHp.get(opponentChoice -1) <= 0);

                                        do {
                                            playerChoice = r.nextInt(heroNumber.size()) + 1;
                                        } while (playerChoice == opponentChoice || heroHp.get(playerChoice -1) <= 0);

                                        int damageOpponent = heroAt.get(opponentChoice - 1) + r.nextInt(5) - heroDef.get(playerChoice -1);

                                        System.out.println(heroNames.get(opponentChoice - 1) + " attacks " + heroNames.get(playerChoice - 1) + "!");
                                        System.out.println(heroNames.get(opponentChoice - 1) + " deals " + heroNames.get(playerChoice - 1) + " " + damageOpponent + " damage! (Damage negation from armour: " + heroDef.get(playerChoice -1) + ")");
                                        System.out.println(heroNames.get(playerChoice - 1) + " has " + (heroHp.get(playerChoice - 1) - damageOpponent) + " HP left.");
                                        heroHp.set(playerChoice - 1, heroHp.get(playerChoice - 1) - damageOpponent);

                                        System.out.println();

                                    }
                                    else  {
                                        System.out.println(heroNames.get(opponentChoice - 1) + " has been defeated!");

                                        System.out.println();

                                        aliveHeroes--;
                                    }

                                    if (heroHp.get(playerChoice - 1) <= 0) {
                                        System.out.println(heroNames.get(playerChoice - 1) + " has been defeated!");

                                        System.out.println();

                                        aliveHeroes--;
                                    }
                                }
                                //combat loop over | for loop to determine which hero still has more than 0 HP left to declare winner
                                for (int j = 0; j < heroHp.size(); j++) {
                                    if (heroHp.get(j) > 0) {
                                        System.out.println(heroNames.get(j) + " has won the Battle Royale!");
                                        counterBR ++;
                                        break;
                                    }
                                }
                                //!important! closes battle royale loop to return to menu, otherwise it loops back to play modi choice
                                break;
                            }

                            else if (playModi == 2){
                                System.out.println("The tournament commences!");
                                counterTourn ++;
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