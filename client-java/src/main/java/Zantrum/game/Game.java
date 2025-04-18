package Zantrum.game;

import Zantrum.cards.CardDb;
import Zantrum.match.Match;
import Zantrum.player.Player;

public class Game {

    private Player player;
    private CardDb cardDb;
    private Match currentMatch;

    private int score;
    private int damage;

    public Game() {
        cardDb = new CardDb();
        this.player = new Player(0, "Zantrum", 0, 0, null);
        currentMatch = new Match();
    }
}
