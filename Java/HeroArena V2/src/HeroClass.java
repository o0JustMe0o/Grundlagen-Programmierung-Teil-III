/*public class HeroClass {
    private String className;
    private String flavourText;

    public HeroClass(String className, String flavourText) {
        this.className = className;
        this.flavourText = flavourText;
    }

    public String getClassName() {
        return className;
    }

    public String getFlavourText() {
        return flavourText;
    }

    public int modifyAtt(int damage, int attackCount, String heroName){
        if (className.equals("Rogue") && attackCount % 4 == 0) {
            damage = damage * 2;
            System.out.println(heroName + ": Sneak Attack!");
        }

        if (className.equals("Fighter") && attackCount % 3 == 0) {
            damage = damage + 8;
            System.out.println(heroName + ": Action Surge!");
        }

        return damage;
    }

    public int modifyDef(int dealtDamage, int incomingAttackCount, String heroName){
        if (className.equals("Paladin")) {
            dealtDamage = dealtDamage - 3;
            System.out.println(heroName + ": My faith protects me! (3 damage negation from class bonus)");
        }

        if (className.equals("Mage") && incomingAttackCount % 5 == 0) {
            dealtDamage = 0;
            System.out.println(heroName + ": I cast shield!");
        }

        return dealtDamage;
    }

    public int modifyHp(int heroHp, String heroName){
        heroHp = heroHp + 25;
        System.out.println(heroName + ": I cast heal! (+25 HP)");

        return heroHp;
    }
}*/
