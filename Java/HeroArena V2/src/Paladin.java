public class Paladin extends Hero {

    public Paladin(String heroName, String heroClass, String flavourText, int heroHp, int heroMaxHp, int heroAtt, int heroDef) {
        super(heroName, heroClass, flavourText, heroHp, heroMaxHp, heroAtt, heroDef);
    }

    public int modifyDef(int dealtDamage, int incomingAttackCount, String heroName){
        dealtDamage = dealtDamage - 3;
        System.out.println(heroName + ": My faith protects me! (3 damage negation from class bonus)");

        return dealtDamage;
    }
}
