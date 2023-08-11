public class Game extends BukkitRunnable {

    /*
    Every Game instance is a countdown for the next game to happen. If there's no next game, it goes to results.
     */

    private GameTypes gameType;
    private PCNParty pp;


    public Game(PCNParty pp, GameTypes gameType) {
        this.pp = pp;
        this.gameType = gameType;

        for (Player player : Bukkit.getOnlinePlayers()) {
            player.teleport(gameType.getLoc());
        }

        MessageUtils.TITLE_LINE.sendToAll();
        MessageUtils.GAME_TITLE.sendToAllWithParam("%game%", gameType.getName());
        for (String line : gameType.getDesc()) {
            MessageUtils.GAME_DESC.sendToAllWithParam("%desc%", line);
        }

        registerEvent();

        runTaskLater(pp, gameType.getTicks());
    }

    private void registerEvent() {
        Listener listener = (Listener) gameType.getGameClass().cast(gameType.getGameClass());
        Bukkit.getPluginManager().registerEvents(listener, pp);
    }

    private void unregisterEvents() {
        Listener listener = (Listener) gameType.getGameClass().cast(gameType.getGameClass());
        HandlerList.unregisterAll(listener);
    }

    @Override
    public void run() {
        unregisterEvents();

        GameManager.nextGame(pp);
    }
}
