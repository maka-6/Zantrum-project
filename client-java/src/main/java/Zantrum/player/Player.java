package Zantrum.player;

import com.raylib.Raylib;

import javax.swing.*;

public class Player {

    private final int id;
    // private boolean banned;

    private String name;
    private int level;
    private int xp;
    private Inventory inventory;
    private Raylib.Texture icon;

    public Player(int id, String name, int level, int xp, Inventory inventory) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.xp = xp;
        this.inventory = inventory;
        icon = new Raylib.Texture(null);
    }

    // get
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getLevel(){
        return level;
    }
    public int getXp(){
        return xp;
    }
    public Inventory getInventory(){
        return inventory;
    }
    public Raylib.Texture getIcon(){
        return icon;
    }

    // set
    public void setName(String name){
        this.name = name;
    }
    public void setLevel(int level){
        this.level = level;
    }
    public void setXp(int xp){
        this.xp = xp;
    }
    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }
    public void setIcon(Raylib.Texture icon){
        this.icon = icon;
    }
}