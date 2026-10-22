import java.util.List;

public class OneVsOne extends Combat {
    public String gameMode() { return "One vs One";}
    private Hero player;
    private Hero opponent;

    public OneVsOne(List<Hero> heroList) {
        super(heroList);
    }

    public void heroOneChoice(int index) {
        player = heroList.get(index);
    }

    public void heroTwoChoice(int index) {
        opponent = heroList.get(index);
    }

    public OneVsOne(Hero player, Hero opponent) {
        super(List.of(player, opponent));

        this.player = player;
        this.opponent = opponent;
    }

    @Override
    public void runCombat() {

        while (!player.isDefeated() && !opponent.isDefeated()) {

            player.fight(opponent);
            if (opponent.isDefeated()) {
                break;
            }

            opponent.fight(player);
        }
    }

    @Override
    public Hero determineWinner() {

        if (!player.isDefeated()) {
            return player;
        }

        if (!opponent.isDefeated()) {
            return opponent;
        }

        return null;
    }
}