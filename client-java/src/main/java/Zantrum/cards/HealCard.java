package Zantrum.cards;

import com.raylib.Raylib;

public class HealCard extends Card {
    int heal;

    public HealCard(String name, int life, int number, int heal, String description, int rarity, String origin, Raylib.Texture texture, boolean available ) {
        super(name, life, number, description, rarity, origin, CardType.HEAL, texture, available);
        this.heal = heal;
    }

    // get
    public int getHeal() {
        return heal;
    }

    // set
    public void setHeal(int heal) {
        this.heal = heal;
    }
}