package Zantrum.Player;

import java.util.ArrayList;

import Zantrum.Cards.Card;

public class Deck {

    private final ArrayList<Card> deck;

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
