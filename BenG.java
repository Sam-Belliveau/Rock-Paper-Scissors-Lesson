
public class BenG extends Player {

    private double rand;

    public BenG() {
    }


    public Player.Choice play() {
        rand = Math.random();

        if (rand < 0.333)
            return Player.Choice.ROCK;
        else if (rand < 0.666)
            return Player.Choice.PAPER;
        else
            return Player.Choice.SCISSORS;
    }

    public String name() {
        return "Ben";
    }
}