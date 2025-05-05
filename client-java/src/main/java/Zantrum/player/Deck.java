package Zantrum.player;

import java.util.ArrayList;

import Zantrum.cards.Card;

public class Deck {

    private final ArrayList<Card> deck;
    private final int deckNum;
    private String deckName;

    public Deck(String deckName, int deckNum) {
        deck = new ArrayList<>();
        this.deckNum = deckNum;
        this.deckName = deckName;
    }

    // get
    public ArrayList<Card> getDeck() {
        return deck;
    }
    public int getNumCards() {
        return deck.size();
    }
    public String getDeckName() {
        return deckName;
    }
    public int getDeckNum() {
        return deckNum;
    }

    public void addCard(Card card) {
        if ( deck.size() < 20 ) {
            deck.add(card);
        }
    }

    public void removeCard(Card card) {
        deck.remove(card);
    }

    public void setDeck(String deckName) {
        this.deckName = deckName;
    }
}
