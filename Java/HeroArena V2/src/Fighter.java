public class Fighter extends Hero {

    public Fighter(String heroName, String heroClass, String flavourText, int heroHp, int heroMaxHp, int heroAtt, int heroDef) {
        super(heroName, heroClass, flavourText, heroHp, heroMaxHp, heroAtt, heroDef);
    }

    @Override
    public int modifyAtt(int damage, int attackCount, String heroName) {

        if (attackCount % 3 == 0) {
            damage = damage + 8;
            System.out.println(heroName + ": Action Surge!");
        }

        return damage;
    }

}
