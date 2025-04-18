package Zantrum.cards;

public class AttackCard extends Card {
    int damage;
    CardType type;

    public AttackCard(String name, int life, int number, int damage, String description, int rarity, String origin) {
        super(name, life, number, description, rarity, origin, CardType.ATTACK);
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