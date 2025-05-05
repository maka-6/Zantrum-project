package Zantrum.player;

import Zantrum.cards.Card;
import com.raylib.Raylib;

import java.io.*;

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
        downloadInventoryCSV(inventory);
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

    private void downloadInventoryCSV(Inventory inventory) {
        File file = new File("Data/inventario_db.csv");
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            if (inventory == null || inventory.getInventory() == null) {
                //System.err.println("Inventario nullo, impossibile salvare.");
                return;
            }
            // intestazione CSV
            writer.println("available,number,name,life,origin,texturePath,description,rarity,type,xp,level");

            for (Card card : inventory.getInventory()) {
                writer.printf("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s%n",
                        card.isAvailable() ? "1" : "0",
                        card.getNumber(),
                        escape(card.getName()),
                        card.getLife(),
                        escape(card.getOrigin()),
                        escape(card.getTexturePath()),
                        escape(card.getDescription()),
                        card.getRarity(),
                        card.getType().toString(),
                        card.getXp(),
                        card.getLevel()
                );
            }

        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio dell'inventario: " + e.getMessage());
        }
    }

    private String escape(String value) {
        if (value == null) return "";
        return value.replace(",", "\\,").replace("\n", " ");
    }
}