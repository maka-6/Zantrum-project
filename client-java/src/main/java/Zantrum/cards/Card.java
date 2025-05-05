package Zantrum.cards;

import com.raylib.Raylib;

public class Card {

    private final String name;
    private final int number;
    private int life;
    private final String description;
    private final String origin;
    String texturePath;
    Raylib.Texture texture;
    boolean available;

    // scelte future sulle carte
    private int xp;
    private int level;

    public enum CardType {
        ATTACK,
        DEFENSE,
        HEAL,
        SPECIAL
    }

    private final CardType type;

    // rarità
    private final int rarity;

    // se la carta e stata eliminata
    private boolean action;


    public Card(String name, int number, int life, String description, int rarity, String origin, CardType type, String texturePath, boolean available) {
        this.name = name;
        this.number = number;
        this.life = life;
        this.description = description;
        this.rarity = rarity;
        this.action = true;
        this.origin = origin;
        this.type = type;
        this.texturePath = texturePath;
        this.available = available;
        this.xp = 0;
        this.level = 0;
    }

    // get
    public String getName() {
        return name;
    }
    public int getNumber() {
        return number;
    }
    public int getLife() {
        return life;
    }
    public String getDescription() {
        return description;
    }
    public int getRarity() {
        return rarity;
    }
    public boolean isOnAction() {
        return action;
    }
    public String getOrigin() {
        return origin;
    }
    public CardType getType() {
        return type;
    }
    public String getTexturePath() {
        return texturePath;
    }
    public boolean isAvailable() {
        return available;
    }
    public int getXp() {
        return xp;
    }
    public int getLevel() {
        return level;
    }

    public void addXp(int xp) {
        this.xp += xp;
    }
    public void addLevel() {
        this.level++;
    }
    public void addLife(int life) {
        this.life += life;
    }


    // set
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public void setAction(boolean action) {
        this.action = action;
    }

    public void loadTextureIfNeeded() {
        if (texture == null && texturePath != null) {
            texture = Raylib.LoadTexture(texturePath.replace("\\", "/"));
        }
    }

    public void unloadTexture() {
        if (texture != null) {
            Raylib.UnloadTexture(texture);
            texture = null;
        }
    }

    public Raylib.Texture getTexture() {
        return texture;
    }
}