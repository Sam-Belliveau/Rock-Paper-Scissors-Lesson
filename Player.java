
public class Player {
    public static enum Choice {
        ROCK(0,2,1), PAPER(1,0,2), SCISSORS(2,1,0);
        
        public int val, win, lose;
        Choice(int v, int w, int l) {
            val = v; win = w; lose = l;
        }

        public boolean beats(Choice other) {
            return this.win == other.val;
        }
    }

    public Player() {

    }

    public Choice play() {
        return null;
    }

    public String name() {
        return "default player";
    }
}