public class GameManager {
    /* 
    GAMES ARE LISTED IN ORDER
    */

    private static final GameTypes[] games = new GameTypes[]{
            GameTypes.OHOK,
            GameTypes.SPLEEF
            // YOUR GAMES ADDED HERE, IN ORDER
    };

    private static int currentIndex = 0;

    public static void nextGame(PCNParty pp) {
        new Game(pp, games[currentIndex]);
        currentIndex++;
    }

}
