import java.util.HashMap;


public class Myles extends Player {
    
    private static final Player.Choice DEFAULT_CHOICE = Player.Choice.SCISSORS;

    private static final Player.Choice getDefaultChoice() {
        double rand = Math.random();

        if (rand < (1.0/3.0))
            return Player.Choice.ROCK;
        else if (rand < (2.0/3.0))
            return Player.Choice.PAPER;
        else
            return Player.Choice.SCISSORS;
    }

    public Myles() {

    }

    private Player getBestPlayer() {
        int max = -1;
        Player p = null;
        for (HashMap.Entry<Player, Integer> player : Main.wins.entrySet()) {
            if (player.getValue() > max) {
                max = player.getValue();
                p = player.getKey();
            }
        }
        return p;
    }

    public Player.Choice play() {
        Player bestPlayer = getBestPlayer();
        // bestPlayer = Main.players[0];

        if (bestPlayer == null || bestPlayer == this)
            return getDefaultChoice();

        final Player.Choice tmp = bestPlayer.play();
        if (tmp == null)
            return getDefaultChoice();

        return tmp;    
    }

    public String name() {
        return "Myles";
    }

}
