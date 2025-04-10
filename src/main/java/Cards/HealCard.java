package Cards;

public class HealCard extends Card {
    int heal;

    public HealCard(String name, int life, int number, int damage, String description, int heal,int rarity) {
        super(name, life, number, description, rarity);
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