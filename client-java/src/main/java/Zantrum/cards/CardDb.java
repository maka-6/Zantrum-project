package Zantrum.cards;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CardDb {

    private ArrayList<Card> cardsDb;

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

                Card card = switch (Card.CardType.values()[type]) {
                    case ATTACK -> new AttackCard(name, life, id, damage, description, rarity, origin);
                    case DEFENSE -> new DefenseCard(name, life, id, defense, description, rarity, origin);
                    // altri tipi
                    case HEAL -> new HealCard(name, life, id, heal, description, rarity, origin);
                    //
                    default -> new Card(name, id, life, description, rarity, origin, Card.CardType.values()[type]);
                };

                cards.add(card);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // get
    Card getCardById(int id) {
        return cardsDb.get(id);
    }
    Card getCardByName(String name) {
        for (Card card : cardsDb) {
            if (card.getName().equals(name)) return card;
        }
        return null;
    }
}
