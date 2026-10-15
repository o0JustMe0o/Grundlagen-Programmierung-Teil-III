import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello and welcome to:");

        System.out.println();
        System.out.println(" _   _                   ___");
        System.out.println("| | | |                 / _ \\");
        System.out.println("| |_| | ___ _ __ ___   / /_\\ \\_ __ ___ _ __   __ _");
        System.out.println("|  _  |/ _ \\ '__/ _ \\  |  _  | '__/ _ \\ '_ \\ / _` |");
        System.out.println("| | | |  __/ | | (_) | | | | | | |  __/ | | | (_| |");
        System.out.println("\\_| |_/\\___|_|  \\___/  \\_| |_/_|  \\___|_| |_|\\__,_|");
        System.out.println();
        //https://patorjk.com/software/taag/#p=display&f=Doom&t=Hero+Arena&x=none&v=4&h=4&w=80&we=false for title font design

        Hero[] heroes = {
                new Hero("Bjorn","Paladin", 120, 10, 3),
                new Hero("Mira","Rouge", 80, 14, 0),
                new Hero("Kael","Fighter", 100, 12, 0),
                new Hero("Luna","Mage", 90, 13, 3)
        };

        System.out.println("Heroes present: " + Hero.countHeroes);
        System.out.println();

        for (Hero hero : heroes) {
            hero.showInfo();
            System.out.println();
        }

        while (heroes[0].heroHp > 0) {
            heroes[0].takeDamage();
            System.out.println("Ouchie!");
        }
        heroes[0].isDefeted();


    }
}