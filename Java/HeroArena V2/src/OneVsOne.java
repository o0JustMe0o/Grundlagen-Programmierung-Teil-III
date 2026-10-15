import java.util.List;

public class OneVsOne {
    private List<Hero>  heroList;
    private Hero player;
    private Hero opponent;

    public OneVsOne(List<Hero> heroList){
        this.heroList = heroList;
    }

    public void playerChoice(int index) {
        player = heroList.get(index);
    }

    public void opponentChoice(int index) {
        opponent = heroList.get(index);
    }

    public void startGame() {
        while (!player.isDefeated() && !opponent.isDefeated()) {

            int playerDamage = player.attack();
            opponent.takeDamage(playerDamage);

            if (opponent.isDefeated()) {
                break;
            }

            int opponentDamage = opponent.attack();
            player.takeDamage(opponentDamage);
        }
    }

    public Hero determineWinner() {
        if (player.isDefeated()) {
            return opponent;
        }
        return player;
    }

}
