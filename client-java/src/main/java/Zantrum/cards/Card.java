package Zantrum.cards;

import com.raylib.Raylib;

public class Card {

    private String name;
    private int number;
    private int life;
    private String description;
    private String origin;
    Raylib.Texture texture;
    boolean available;

    public enum CardType {
        ATTACK,
        DEFENSE,
        HEAL,
        SPECIAL
    }

    private CardType type;

    // rarità
    private int rarity;

    // se la carta e stata eliminata
    private boolean action;


    public Card(String name, int number, int life, String description, int rarity, String origin, CardType type, Raylib.Texture texture, boolean available) {
        this.name = name;
        this.number = number;
        this.life = life;
        this.description = description;
        this.rarity = rarity;
        this.action = true;
        this.origin = origin;
        this.type = type;
        this.texture = texture;
        this.available = available;
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
    public boolean isAction() {
        return action;
    }
    public String getOrigin() {
        return origin;
    }
    public CardType getType() {
        return type;
    }
    public Raylib.Texture getTexture() {
        return texture;
    }
    public boolean isAvailable() {
        return available;
    }


    // set
    public void setName(String name) {
        this.name = name;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setLife(int life) {
        this.life = life;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setRarity(int rarity) {
        this.rarity = rarity;
    }
    public void setAction(boolean action) {
        this.action = action;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public void setType(CardType type) {
        this.type = type;
    }
    public void setTexture(Raylib.Texture texture) {
        this.texture = texture;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
}