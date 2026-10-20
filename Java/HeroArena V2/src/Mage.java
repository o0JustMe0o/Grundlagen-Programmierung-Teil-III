public class Mage extends Hero {

    public Mage(String heroName, int heroHp, int heroMaxHp, int heroAtt, int heroDef) {
        super(heroName, HeroClass.MAGE, heroHp, heroMaxHp, heroAtt, heroDef);
    }

    @Override
    public int modifyDef(int dealtDamage, int incomingAttackCount, String heroName){

        if (incomingAttackCount % 5 == 0) {
            dealtDamage = 0;
            System.out.println(heroName + ": I cast shield!");
        }
        return dealtDamage;
    }
}
