package Zantrum.model;

import com.raylib.Raylib;

public class Card {

    private final String name;
    private final int number;
    private int life;
    private final String description;
    private final String origin;
    private Raylib.Texture texture;
    private String texturePath;
    private boolean available;

    // Caratteristiche specifiche delle carte
    private int damage = 0;  // solo per ATTACK
    private int defense = 0; // solo per DEFENSE
    private int healAmount = 0; // solo per HEAL
    private int specialEffect = 0; // per SPECIAL EFFECT


    private int xp;
    private int level;

    public enum CardType {
        ATTACK,
        DEFENSE,
        HEAL,
        SPECIAL
    }

    private final CardType type;
    private final int rarity;
    private boolean action;

    public Card(String name, int life,  int number, int effect, String description, int rarity, String origin, CardType type,
                String texturePath, boolean available) {
        this.name = name;
        this.number = number;
        this.life = life;
        this.description = description;
        this.rarity = rarity;
        this.origin = origin;
        this.type = type;
        this.texturePath = texturePath;
        this.available = available;

        // Assegna il valore in base al tipo di carta
        switch (type) {
            case ATTACK : this.damage = effect;break;
            case DEFENSE : this.defense = effect;break;
            case HEAL : this.healAmount = effect;break;
            case SPECIAL : this.specialEffect = effect;break;
        }
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