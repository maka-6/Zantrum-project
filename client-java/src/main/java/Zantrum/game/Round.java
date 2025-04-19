package Zantrum.game;

import Zantrum.cards.CardDb;
import Zantrum.player.Player;
import com.raylib.Raylib;

public class Round {

    private Player player;
    private CardDb cardDb;

    private int score;
    private int totalDamage;

    public Round() {
        this.cardDb = new CardDb();
        this.player = new Player(0, "Zantrum", 0, 0, null);
        this.score = 0;
        this.totalDamage = 0;
    }

    public void setPlayerPicture(Raylib.Texture playerPicture) {
        this.player.setIcon(playerPicture);
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