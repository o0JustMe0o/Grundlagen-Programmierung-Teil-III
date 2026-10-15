import java.util.Random;

public class Hero {
    String heroName;
    String heroClass;
    int heroHp;
    int heroAtt;
    int heroDef;

    Random r = new Random(42);

    public static int countHeroes = 0;

    public Hero(String heroName, String heroClass, int heroHp, int heroAtt, int heroDef) {
        this.heroName = heroName;
        this.heroClass = heroClass;
        this.heroHp = heroHp;
        this.heroAtt = heroAtt;
        this.heroDef = heroDef;

        Hero.countHeroes++;
    }

    public void showInfo() {
        System.out.println("Name: " + heroName);
        System.out.println("Class: " + heroClass);
        System.out.println("HP: " + heroHp);
        System.out.println("Att: " + heroAtt);
        System.out.println("Def: " + heroDef);
    }

    public void attack() {
        int damage = heroAtt + r.nextInt(5);
        System.out.println(heroName + " attaks for " + damage + " damage.");
    }

    public void takeDamage() {
        int dealtDamage = 10/*placeholder 10 =opponentAttack damage*/ - heroDef;
        System.out.println(heroName + " takes " + dealtDamage + " points of damage.");
        int remainingHp = heroHp - dealtDamage;
        System.out.println(heroName + " has " + remainingHp + " left.");
        heroHp = remainingHp;
    }

    public void isDefeted() {
        if (heroHp <= 0) {
            System.out.println(heroName + " has been defeted.");
        }
    }



}

