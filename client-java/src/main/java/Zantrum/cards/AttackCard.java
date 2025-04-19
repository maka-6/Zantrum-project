package Zantrum.cards;

import com.raylib.Raylib;

public class AttackCard extends Card {
    int damage;
    CardType type;

    public AttackCard(String name, int life, int number, int damage, String description, int rarity, String origin, String texture, boolean available ) {
        super(name, life, number, description, rarity, origin, CardType.ATTACK, texture, available);
        this.damage = damage;
    }

    // get
    public int getDamage() {
        return damage;
    }

    // set
    public void setDamage(int damage) {
        this.damage = damage;
    }
}