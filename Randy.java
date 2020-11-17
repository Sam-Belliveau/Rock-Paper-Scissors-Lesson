public class Randy extends Player{
    
    // Private Variables
    private int totalGames = 0;
    private int ScissorWins = 0;
    private int RockWins = 0;
    private int PaperWins = 0;
    private int selection = -1;
    
    public void Randy() {
    }

    // Gets wins stolen from the main file
    private int getWins() {
        return Main.wins.getOrDefault(this, 0);
    }

    // Chooses the best selection to make for the rest of the game
    private void makeSelection () {
        if (RockWins > PaperWins && RockWins > ScissorWins)
            selection = 0;
        else if (PaperWins > RockWins && PaperWins > ScissorWins)
            selection = 1;
        else 
            selection = 2;
    }

    // Plays a move
    public Player.Choice play() {
        if (selection != -1) {
            switch (selection) {
                case 0:
                    return Player.Choice.ROCK;
                case 1:
                    return Player.Choice.PAPER;
                case 2:
                    return Player.Choice.SCISSORS;
            }
        }
        totalGames++;
        if (totalGames < 333) {
            return Player.Choice.ROCK;
        } else if (totalGames < 666) {
            if (totalGames == 333) {
                RockWins = getWins();
            }
            return Player.Choice.PAPER;
        } else if (totalGames < 999){
            if (totalGames == 666) {
                PaperWins = getWins() - RockWins;
            }
            return Player.Choice.SCISSORS;
        } 

        if (totalGames == 999) {
            ScissorWins = getWins() - PaperWins + RockWins;
            makeSelection();
        }
        
        return Player.Choice.PAPER;
    }

    public String name() {
        return "Randy";
    }
}
