import java.lang.reflect.Method; 

public class Sam extends Player {

    Player.Choice pTrick = null;

    public Sam() {
        /// empty
    }
    
    public Player.Choice play() {

        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement e = stacktrace[2];//maybe this number needs to be corrected
        String methodName = e.getMethodName();
        String className = e.getClassName();

        if(className.equals("Main")) {
            Player other = this;
            int max = -1;
            for(Player p : Main.players) {
                int t;
                if((t = Main.wins.getOrDefault(p,0)) > max && p != this) {
                    max = t;
                    other = p;
                } 
            }
            while(other == this) {
                other = Main.players[(int)(Math.random()*Main.players.length)];
            }        
    
            Player.Choice otherC = other.play();
            Player.Choice choice = Player.Choice.values()[otherC.lose];
            pTrick = null;
            return choice;
        } else {
            if(pTrick != null) {
                return Player.Choice.values()[pTrick.lose];
            } 
    
            Player.Choice choice = Player.Choice.ROCK;
            pTrick = Player.Choice.values()[choice.lose];
            return choice;
        }
    }

    public String name() {
        return "Sam";
    }
}