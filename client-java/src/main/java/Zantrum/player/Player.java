package Zantrum.player;

import javax.swing.*;

public class Player {

    private final int id;
    // private boolean banned;

    private String name;
    private int level;
    private int xp;
    private Inventory inventory;
    ImageIcon icon;

    public Player(int id, String name, int level, int xp, Inventory inventory) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.xp = xp;
        this.inventory = inventory;
    }

    // get
    int getId(){
        return id;
    }
    String getName(){
        return name;
    }
    int getLevel(){
        return level;
    }
    int getXp(){
        return xp;
    }
    Inventory getInventory(){
        return inventory;
    }

    // set
    void setName(String name){
        this.name = name;
    }
    void setLevel(int level){
        this.level = level;
    }
    void setXp(int xp){
        this.xp = xp;
    }
    void setInventory(Inventory inventory){
        this.inventory = inventory;
    }
}