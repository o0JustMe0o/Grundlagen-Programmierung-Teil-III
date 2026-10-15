import java.util.Random;

public class Hero {
    String heroName;
    HeroClass heroClass;
    int heroHp;
    int heroAtt;
    int heroDef;

    Random r = new Random(42);

    public static int countHeroes = 0;

    public Hero(String heroName, HeroClass heroClass, int heroHp, int heroAtt, int heroDef) {
        this.heroName = heroName;
        this.heroClass = heroClass;
        this.heroHp = heroHp;
        this.heroAtt = heroAtt;
        this.heroDef = heroDef;

        Hero.countHeroes++;
    }

    public void showInfo() {
        System.out.println("Name: " + heroName);
        System.out.println("Class: " + heroClass.getClassName() + " ∙ " + heroClass.getFlavourText());
        System.out.println("HP: " + heroHp);
        System.out.println("Att: " + heroAtt);
        System.out.println("Def: " + heroDef);
    }

    public int attack() {
        int damage = heroAtt + r.nextInt(5);
        System.out.println(heroName + " attaks for " + damage + " damage.");

        return damage;
    }

    public void takeDamage(int incomingDamage) {
        int dealtDamage = incomingDamage - heroDef;
        System.out.println(heroName + " takes " + dealtDamage + " points of damage. (Damage negation from Def: " + heroDef + ")");

        heroHp = heroHp - dealtDamage;

        System.out.println(heroName + " has " + heroHp + " left.");
        System.out.println();
    }

    public boolean isDefeated() {
        return heroHp <= 0;
    }



}

