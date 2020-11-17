import java.util.HashMap; 

public class Main {

    
    static HashMap<Player, Integer> wins = new HashMap<>();

    public static void fight(Player a, Player b) {

        final Player.Choice aPlay = a.play();
        final Player.Choice bPlay = b.play() ;

        if(aPlay.beats(bPlay)) {
            wins.put(a, wins.getOrDefault(a, 0) + 1);
            wins.put(b, wins.getOrDefault(b, 0) - 0);
            //System.out.println(a.name() + " beat " + b.name());
        } else if (bPlay.beats(aPlay)) {
            wins.put(a, wins.getOrDefault(a, 0) - 0);
            wins.put(b, wins.getOrDefault(b, 0) + 1);
            //System.out.println(b.name() + " beat " + a.name());
        } else {
            wins.put(a, wins.getOrDefault(a, 0) + 0);
            wins.put(b, wins.getOrDefault(b, 0) + 0);
            ///System.out.println(a.name() + " tied " + b.name());
        }
    }


    public static Player[] players = {
        new Myles(),
        new Mark(),
        new BenG(),
        new AndrewLiu(),
        new AnthonyChen(),
        new ShauryaSen(),
        new Randy(),
        new Jin(),
        new Sam()
    };

    public static void main(String... args) {
        for(int i = 0; i < 10000; ++i) {
            for(Player a : players) 
                for(Player b : players) 
                    if(a != b) fight(a, b);
        }

        System.out.println("\n\n\nRESULTS:");
        for (HashMap.Entry<Player, Integer> entry : wins.entrySet()) {
            System.out.println("\n" + entry.getKey().name() + " \t - "  + entry.getValue());
        }
    }

}