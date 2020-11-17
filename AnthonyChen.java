public class AnthonyChen extends Player{
    public AnthonyChen() {
        // i can spell my own name properly
    }

    public Player.Choice play() {
        return Player.Choice.SCISSORS;
    }

    public String name() {
        return "Anthony";
    }
}
