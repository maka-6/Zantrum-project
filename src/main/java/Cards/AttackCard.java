package Cards;

public class AttackCard extends Card {
    int damage;

    public AttackCard(String name, int life, int number, int damage, String description, int rarity) {
        super(name, life, number, description, rarity);
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