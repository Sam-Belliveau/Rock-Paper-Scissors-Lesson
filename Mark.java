public class Mark extends Player{ 
    public Mark(){
        
    }
    
    public Player.Choice play() {
        return Player.Choice.SCISSORS;
    }

    public String name() {
        return "Mark";
    }
}
