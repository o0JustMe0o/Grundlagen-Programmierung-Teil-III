public class Mage extends Hero {

    public Mage(String heroName, HeroClass heroClass, int heroHp, int heroMaxHp, int heroAtt, int heroDef) {
        super(heroName, heroClass, heroHp, heroMaxHp, heroAtt, heroDef);
    }

    public int modifyDef(int dealtDamage, int incomingAttackCount, String heroName, String heroClass){
        if (heroClass.equals("Mage") && incomingAttackCount % 5 == 0) {
            dealtDamage = 0;
            System.out.println(heroName + ": I cast shield!");
        }
        return dealtDamage;
    }
}
