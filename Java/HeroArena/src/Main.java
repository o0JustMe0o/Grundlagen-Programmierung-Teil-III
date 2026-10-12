import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome to:");

        System.out.println(" _   _                   ___");
        System.out.println("| | | |                 / _ \\");
        System.out.println("| |_| | ___ _ __ ___   / /_\\ \\_ __ ___ _ __   __ _");
        System.out.println("|  _  |/ _ \\ '__/ _ \\  |  _  | '__/ _ \\ '_ \\ / _` |");
        System.out.println("| | | |  __/ | | (_) | | | | | | |  __/ | | | (_| |");
        System.out.println("\\_| |_/\\___|_|  \\___/  \\_| |_/_|  \\___|_| |_|\\__,_|");
        System.out.println();
        //https://patorjk.com/software/taag/#p=display&f=Doom&t=Hero+Arena&x=none&v=4&h=4&w=80&we=false for title font design

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

    }
}