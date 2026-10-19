public class Rogue extends Hero {

    public Rogue(String heroName, HeroClass heroClass, int heroHp, int heroMaxHp, int heroAtt, int heroDef) {
        super(heroName, heroClass, heroHp, heroMaxHp, heroAtt, heroDef);
    }

    @Override
    public int modifyAtt(int damage, int attackCount, String heroName){
        if (attackCount % 4 == 0) {
            damage = damage * 2;
            System.out.println(heroName + ": Sneak Attack!");
        }
        return damage;
    }
}
