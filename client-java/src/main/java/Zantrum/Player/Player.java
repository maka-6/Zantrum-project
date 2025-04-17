package Zantrum.Player;

public class Player {

    private String name;
    private int level;
    private int xp;
    private Inventory inventory;

    public Player(String name, int level, int xp, Inventory inventory) {
        this.name = name;
        this.level = level;
        this.xp = xp;
        this.inventory = inventory;
    }


}