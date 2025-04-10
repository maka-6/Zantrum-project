import java.util.ArrayList;

import Cards.Card;

public class Deck {

    private ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<>();
    }

    // get
    public ArrayList<Card> getDeck() {
        return deck;
    }
    public int getNumCards() {
        return deck.size();
    }

    public void addCard(Card card) {
        if ( deck.size() < 20 ) {
            deck.add(card);
        }
    }

    public void removeCard(Card card) {
        deck.remove(card);
    }
}
