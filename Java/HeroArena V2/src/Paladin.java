public class Paladin extends Hero {

    public Paladin(String heroName, int heroHp, int heroMaxHp, int heroAtt, int heroDef) {
        super(heroName, HeroClass.PALADIN, heroHp, heroMaxHp, heroAtt, heroDef);
    }

    @Override
    public int modifyDef(int dealtDamage, int incomingAttackCount, String heroName){

        dealtDamage = dealtDamage - 2;
        System.out.println(heroName + ": My faith protects me! (2 damage negation from class bonus)");

        return dealtDamage;
    }
}
