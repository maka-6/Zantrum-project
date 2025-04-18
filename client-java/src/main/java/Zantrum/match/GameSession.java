package Zantrum.match;

import Zantrum.game.Round;

import java.util.ArrayList;

public class GameSession {

    private final ArrayList<Round> games;
    private final int result;
    private int turn;
    private boolean turnOver;

    public GameSession() {
        this.result = 0;  // Inizializzare con un risultato predefinito, ad esempio 0
        this.turn = 1;    // Inizializzare con il primo turno
        this.games = new ArrayList<>();
        this.turnOver = false;
    }

    public void addGame(Round game) {
        this.games.add(game);
    }

    public void removeGame(Round game) {
        this.games.remove(game);
    }

    // Metodo per aggiornare il turno
    public void nextTurn() {
        if (this.turnOver) {
            this.turn++;
            this.turnOver = false;
        }
    }

    // in caso sia giocata una carta che dia piu turni
    public void setTurnOver(boolean turnOver) {
        this.turnOver = turnOver;
    }

    public int getResult() {
        return result;
    }

    public int getTurn() {
        return turn;
    }

    public ArrayList<Round> getGames() {
        return games;
    }

    public void GameLoop(ArrayList<Round> games) {
        Round currentRound = new Round();
        games.add(currentRound);

        // la partita se rimarrà su questa classe..
    }
}
