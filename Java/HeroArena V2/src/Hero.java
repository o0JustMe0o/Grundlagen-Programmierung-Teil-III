import java.util.Random;

public class Hero {
    private String heroName;
    public enum HeroClass {
        PALADIN("Paladin", "+2 extra Def (damage negation)"),
        ROGUE("Rogue","Sneak Attack every 4 turns (double damage)"),
        FIGHTER("Fighter","Action Surge every 3 turns (+8 damage)"),
        MAGE("Mage","Shield cast every 5 turns (full damage negation)"),
        CLERIC("Cleric","Casts heal on self at half health (+25 HP)."),
        NORMIE("Normie","Your average Joe (or Jimmy in this case).");

        private final String className;
        private final String flavourText;

        HeroClass(String className, String flavourText) {
            this.className = className;
            this.flavourText = flavourText;
        }

    }
    private HeroClass heroClass;
    private int heroHp;
    private int heroMaxHp;
    private int heroAtt;
    private int heroDef;

    public static Random r = new Random(42);
    private int attackCounter = 0;
    private int incomingAttackCounter = 0;
    private boolean healUsed = false;

    public Hero(String heroName, HeroClass heroClass, int heroHp, int heroMaxHp, int heroAtt, int heroDef) {
        this.heroName = heroName;
        this.heroClass = heroClass;
        this.heroHp = heroHp;
        this.heroMaxHp = heroMaxHp;
        this.heroAtt = heroAtt;
        this.heroDef = heroDef;
    }

    public void showInfo() {
        System.out.println("Name: " + heroName);
        System.out.println("Class: " + heroClass.className + " ∙ " + heroClass.flavourText);
        System.out.println("HP: " + heroHp);
        System.out.println("Att: " + heroAtt);
        System.out.println("Def: " + heroDef);
    }

    public String getHeroName() {
        return heroName;
    }

    public int getHeroHp() {
        return heroHp;
    }

    public int getHeroMaxHp() {
        return heroMaxHp;
    }

    public boolean getHealUsed() {
        return healUsed;
    }

    public void setHealUsed(boolean healUsed) {
        this.healUsed = healUsed;
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

    public static Random getRandom() {
        return r;
    }

    public int attack() {

        attackCounter++;

        int damage = heroAtt + r.nextInt(5);

        damage = modifyAtt(damage, attackCounter, heroName);

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

            heroHp = modifyHp(heroHp, heroName);
        }

        System.out.println(heroName + " has " + heroHp + " left.");
        System.out.println();
    }

    public void fight(Hero opponent) {
        int damage = this.attack();
        opponent.takeDamage(damage);
    }


    public boolean isDefeated() {
        return heroHp <= 0;
    }

    public void resetHero() {
        heroHp = heroMaxHp;
        attackCounter = 0;
        incomingAttackCounter = 0;
        healUsed = false;
    }
}

