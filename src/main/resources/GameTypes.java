public enum GameTypes {
  
    /*
    ENUMNAME(
              <game name>,
              <game desc>,
              <amount of ticks game will last>,
              <starting location of game>,
              <game class - handles all of your listeners, logic, etc.>
    )
    */
  
    OHOK(
            "One Hit One Kill",
            new String[]{
                "Being hit by an arrow is an instant-kill.",
                "Everyone has infinite arrows and only one bow.",
                "Person with the most kills wins! Good luck :D"
            },
            1,
            new Location(Bukkit.getWorld("WorldName"), 1, 1, 1), // temporary 
            OHOKEvents.class
    ),
    SPLEEF(
            "Spleef",
            new String[]{
                    "Dig from under your opponents using your shovel.",
                    "Use snowballs to get rid of the snow.",
                    "Last person standing wins! Good luck :D"
            },
            1,
            new Location(Bukkit.getWorld("WorldName"), 1, 1, 1), // temporary
            SpleefEvents.class
    );

    /*
    Add your games here...
    */

    private String name;
    private String[] desc;
    private int ticks;
    private Location loc;
    private Class gameClass;

    GameTypes(String name, String[] desc, int ticks, Location loc, Class gameClass) {
        this.name = name;
        this.desc = desc;
        this.ticks = ticks;
        this.loc = loc;
        this.gameClass = gameClass; 
    }

    public String getName() { return name;}
    public String[] getDesc() { return desc; }
    public int getTicks() { return ticks; }
    public Location getLoc() { return loc; }
    public Class getGameClass() { return gameClass; }

}
