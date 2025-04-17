package Zantrum.Player;

import java.util.ArrayList;

import Zantrum.Cards.AttackCard;
import Zantrum.Cards.Card;
import Zantrum.Cards.DefenseCard;
import Zantrum.Cards.HealCard;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Inventory {

    ArrayList<Card> inventory;
    ArrayList<Card> cardsDb;
    ArrayList<Deck> deck;

    public Inventory() {
        inventory = new ArrayList<>();
        cardsDb = new ArrayList<>();
        LoadCardsDb(cardsDb);
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

    public void deleteDeck(Deck deck) {
        this.deck.remove(deck);
    }

    private void LoadCardsDb(ArrayList<Card> cards) {
        try (BufferedReader br = new BufferedReader(new FileReader("Data/carte_db.csv"))) {

            String line;
            int damage = 0;
            int heal = 0;
            int defense = 0;

            while ((line = br.readLine()) != null) {

                // Salta righe vuote o di intestazione
                if (line.trim().isEmpty() || line.startsWith("id;")) continue;

                String[] parts = line.split(";", -1); // -1 per prendere anche i campi vuoti
                if (parts.length < 4) continue;  // ignora righe con troppi pochi campi

                // lettura carta
                int id = Integer.parseInt(parts[0].replace("\uFEFF", "").trim());
                String name = parts[1].trim();
                int life = parts[2].isEmpty() ? 0 : Integer.parseInt(parts[2].trim());
                String description = parts[3].trim();
                int rarity = parts[4].isEmpty() ? 1 : Integer.parseInt(parts[4].trim());
                int type = (parts.length > 5 && !parts[5].isEmpty()) ? Integer.parseInt(parts[5].trim()) : 1;
                int effect = (parts.length > 6 && !parts[6].isEmpty()) ? Integer.parseInt(parts[6].trim()) : 0;
                String origin = parts.length > 7 ? parts[7].trim() : "";

                switch (type){
                    case 1:
                        damage = effect;
                        break;
                    case 2:
                        defense = effect;
                        break;
                    case 3:
                        heal = effect;
                }

                Card card;

                switch (Card.CardType.values()[type]) {
                    case ATTACK:
                        card = new AttackCard(name, life, id, damage, description, rarity, origin);
                        break;
                    case DEFENSE:
                        card = new DefenseCard(name, life, id, defense, description, rarity, origin);
                        break;
                    // altri tipi
                    case HEAL:
                        card = new HealCard(name, life, id, heal, description, rarity, origin);
                        break;
                        //
                    case SPECIAL:
                    default:
                        card = new Card(name, id, life, description, rarity, origin, Card.CardType.values()[type]);
                }
                cards.add(card);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}