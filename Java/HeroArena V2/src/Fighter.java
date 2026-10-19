public class Fighter extends Hero {

    public Fighter(String heroName, HeroClass heroClass, int heroHp, int heroMaxHp, int heroAtt, int heroDef) {
        super(heroName, heroClass, heroHp, heroMaxHp, heroAtt, heroDef);
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
