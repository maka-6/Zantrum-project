package Zantrum.cards;

import com.raylib.Raylib;

public class DefenseCard extends Card{
    int defense;

    public DefenseCard(String name, int life, int number, int defense, String description, int rarity, String origin, Raylib.Texture texture, boolean available ) {
        super(name, life, number, description, rarity, origin, CardType.DEFENSE, texture, available);
        this.defense = defense;
    }

    // get
    public int getDefense() {
        return defense;
    }

    // set
    public void setDefense(int defense) {
        this.defense = defense;
    }
}