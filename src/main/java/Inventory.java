import java.util.ArrayList;
import Cards.Card;

public class Inventory {

    ArrayList<Card> inventory;
    ArrayList<Deck> deck;

    public Inventory() {
        inventory = new ArrayList<>();
        deck = new ArrayList<>();
    }

    public int getNumDecks() {
        return deck.size();
    }
    public int getNumCards() {
        return inventory.size();
    }

    public void addCard(Card card) {
        inventory.add(card);
    }

    public void addDeck(Deck deck) {
        this.deck.add(deck);
    }

    public void changeDeck(Deck oldDeck, Deck newDeck) {
        deck.remove(oldDeck);
        deck.add(newDeck);
    }
}