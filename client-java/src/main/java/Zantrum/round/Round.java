package Zantrum.round;

import Zantrum.cards.CardDb;
import Zantrum.player.Player;
import com.raylib.Raylib;

public class Round {

    private CardDb cardDb;

    private int score;
    private int totalDamage;
    private int roundNum;

    public Round(int roundNum) {
        this.cardDb = new CardDb();
        this.score = 0;
        this.totalDamage = 0;
        this.roundNum = roundNum;
    }

    public void updateScore(int points) {
        this.score += points;  // Aggiungi punti al punteggio
    }

    public void updateDamage(int damage) {
        this.totalDamage += damage;  // Aggiungi danno totale
    }

    public int getScore() {
        return score;
    }
    public CardDb getCardDb() {
        return cardDb;
    }

    public int getTotalDamage() {
        return totalDamage;
    }
}