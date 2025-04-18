package Zantrum.match;

import Zantrum.player.Player;

import java.util.ArrayList;

public class Match {

    private final ArrayList<Player> players;
    private int result;
    private int turn;

    public Match() {
        this.players = new ArrayList<Player>();
    }

    void addPlayer(Player player) {
        this.players.add(player);
    }
    void removePlayer(Player player) {
        this.players.remove(player);
    }
}
