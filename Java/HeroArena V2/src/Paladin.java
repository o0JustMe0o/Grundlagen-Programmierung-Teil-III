public class Paladin extends Hero {

    public Paladin(String heroName, HeroClass heroClass, int heroHp, int heroMaxHp, int heroAtt, int heroDef) {
        super(heroName, heroClass, heroHp, heroMaxHp, heroAtt, heroDef);
    }

    public int modifyDef(int dealtDamage, int incomingAttackCount, String heroName){
        dealtDamage = dealtDamage - 2;
        System.out.println(heroName + ": My faith protects me! (2 damage negation from class bonus)");

        return dealtDamage;
    }
}
