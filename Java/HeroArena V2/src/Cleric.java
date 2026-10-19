public class Cleric extends Hero {

    public Cleric(String heroName, HeroClass heroClass, int heroHp, int heroMaxHp, int heroAtt, int heroDef) {
        super(heroName, heroClass, heroHp, heroMaxHp, heroAtt, heroDef);
    }

    @Override
    public int modifyHp(int hp, String heroName) {
        hp += 25;

        if (hp > getHeroMaxHp()) {
            hp = getHeroMaxHp();
        }

        System.out.println(
                heroName + " casts Heal and restores 25 HP!"
        );

        return hp;
    }
}