public class Cleric extends Hero {

    public Cleric(String heroName, int heroHp, int heroMaxHp, int heroAtt, int heroDef) {
        super(heroName, HeroClass.CLERIC, heroHp, heroMaxHp, heroAtt, heroDef);
    }

    @Override
    public int modifyHp(int heroHp, String heroName) {

        if (!getHealUsed() && heroHp < getHeroMaxHp() / 2 && heroHp > 0) {

            int healedHp = heroHp + 25;
            healedHp = Math.min(healedHp, getHeroMaxHp());

            System.out.println(heroName + " casts Heal and restores 25 HP!");

            setHealUsed(true);
            return healedHp;

        } else {
            return heroHp;
        }

    }
}