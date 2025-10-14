package Zantrum.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CardDb {

    private final ArrayList<Card> cardsDb;

    public CardDb() {
        cardsDb = new ArrayList<>();
        LoadCardsDb(cardsDb);
    }

    private void LoadCardsDb(ArrayList<Card> cards) {
        try (BufferedReader br = new BufferedReader(new FileReader("Data/carte_db.csv"))) {

            String line;
            int damage = 0;
            int heal = 0;
            int defense = 0;
            Card card;

            while ((line = br.readLine()) != null) {

                // Salta righe vuote o di intestazione
                if (line.trim().isEmpty() || line.startsWith("id;")) continue;

                String[] parts = line.split(";", -1); // -1 per prendere anche i campi vuoti
                if (parts.length < 4) continue;  // ignora righe con troppi pochi campi

                // se disponibile
                boolean available = parts[0].replace("\uFEFF", "").trim().equals("1");
                if (!available)
                    continue;

                // lettura carta
                int id = Integer.parseInt(parts[1].replace("\uFEFF", "").trim());

                String name = parts[2].trim();

                int life = parts[3].trim().isEmpty() ? 0 : Integer.parseInt(parts[3].trim());

                String cardImage = parts[4].trim().replace("\\", "/");

                String description = parts[5].trim();

                int rarity = parts[6].isEmpty() ? 1 : Integer.parseInt(parts[6].trim());

                int type = (parts.length > 7 && !parts[7].isEmpty()) ? Integer.parseInt(parts[7].trim()) : 1;

                int effect = (parts.length > 8 && !parts[8].isEmpty()) ? Integer.parseInt(parts[8].trim()) : 0;

                String origin = parts.length > 9 ? parts[9].trim() : "";

                card = new Card(name, life, id, effect, description, rarity, origin, Card.CardType.values()[type] ,cardImage, available);

                cards.add(card);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // get
    public int getCardsCount() {
        return cardsDb.size();
    }
    public Card getCardById(int id) {
        return cardsDb.get(id);
    }
    public Card getCardByName(String name) {
        for (Card card : cardsDb) {
            if (card.getName().equals(name)) return card;
        }
        return null;
    }
    public int getCardCount() {
        return cardsDb.size();
    }

    public void setAvailable(Card card, boolean available) {
        // Itera su tutte le carte nel database
        for (Card c : cardsDb) {
            // Controlla se l'ID della carta corrisponde
            if (c.getNumber() == card.getNumber()) {
                // Imposta il valore di 'available' per la carta trovata
                c.setAvailable(available);
                break; // Uscita dal ciclo, abbiamo trovato e aggiornato la carta
            }
        }
    }

}
