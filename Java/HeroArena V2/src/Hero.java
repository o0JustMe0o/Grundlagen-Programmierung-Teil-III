import java.util.Random;

public class Hero {
    String heroName;
    String heroClass;
    String flavourText;
    int heroHp;
    int heroMaxHp;
    int heroAtt;
    int heroDef;

    static Random r = new Random(42);

    private int attackCount = 0;
    private int incomingAttackCounter = 0;

    private boolean healUsed = false;

    public Hero(String heroName, String heroClass, String flavourText, int heroHp, int heroMaxHp, int heroAtt, int heroDef) {
        this.heroName = heroName;
        this.heroClass = heroClass;
        this.flavourText = flavourText;
        this.heroHp = heroHp;
        this.heroMaxHp = heroMaxHp;
        this.heroAtt = heroAtt;
        this.heroDef = heroDef;
    }

    public void showInfo() {
        System.out.println("Name: " + heroName);
        System.out.println("Class: " + heroClass + " ∙ " + flavourText);
        System.out.println("HP: " + heroHp);
        System.out.println("Att: " + heroAtt);
        System.out.println("Def: " + heroDef);
    }

    public int modifyAtt(int damage, int attackCount, String heroName) {
        return damage;
    }

    public int modifyDef(int damage, int incomingAttackCounter, String heroName) {
        return damage;
    }

    public int modifyHp(int hp, String heroName) {
        return hp;
    }

    public int attack() {

        attackCount++;

        int damage = heroAtt + r.nextInt(5);

        damage = modifyAtt(damage, attackCount, heroName);

        System.out.println(heroName + " attaks for " + damage + " damage.");

        return damage;
    }

    public void takeDamage(int incomingDamage) {

        incomingAttackCounter++;

        int dealtDamage = incomingDamage - heroDef;

        dealtDamage = modifyDef(dealtDamage, incomingAttackCounter, heroName);

        if (dealtDamage <= 0) {
            System.out.println("The incoming attack was ineffective! " + heroName + " wasn't dealt any damage.");
        }

        else {
            System.out.println(heroName + " takes " + dealtDamage + " points of damage. (Damage negation from Def: " + heroDef + ")");

            heroHp = heroHp - dealtDamage;

            if (!healUsed && "Cleric".equals(heroClass) && heroHp < heroMaxHp / 2 && heroHp > 0) {
                heroHp = modifyHp(heroHp, heroName);

                healUsed = true;
            }
        }

        System.out.println(heroName + " has " + heroHp + " left.");
        System.out.println();
    }

    public boolean isDefeated() {
        return heroHp <= 0;
    }
}

