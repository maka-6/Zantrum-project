package Zantrum.session;

import Zantrum.FontUtils;
import Zantrum.cards.CardDb;
import Zantrum.player.Player;
import Zantrum.round.Round;
import Zantrum.session.Menu;
import com.raylib.Raylib;

import java.util.ArrayList;

import static Zantrum.FontUtils.loadHighQualityFont;
import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

public class GameSession {

    private final ArrayList<Round> rounds;
    private ArrayList<Player> players;
    private final CardDb cards;
    private final int result;
    private int turn;
    private boolean turnOver;
    private Menu menu;

    private GameState gameState;

    enum GameState {
        MAIN_MENU,
        GAME,
        PAUSE,
        GAME_OVER,
        EXIT
    }

    public GameSession() {
        this.gameState = GameState.MAIN_MENU;
        this.result = 0;  // Inizializzare con un risultato predefinito, ad esempio 0
        this.turn = 1;    // Inizializzare con il primo turno
        this.rounds = new ArrayList<>();
        this.turnOver = false;

        cards = new CardDb();
        GameLoop(rounds);
    }

    public void addGame(Round game) {
        this.rounds.add(game);
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

    public ArrayList<Round> getRounds() {
        return rounds;
    }

    public void GameLoop(ArrayList<Round> games) {

        // La partita se rimarrà su questa classe...
        int fps = 60;
        Raylib.Image icon = LoadImage("resources/icon.png");

        SetWindowIcon(icon);
        InitWindow(GetMonitorWidth(0), GetMonitorHeight(0), "Zantrum");
        ToggleFullscreen();
        SetTargetFPS(fps);

        menu = new Menu();
        Font font = loadHighQualityFont("resources/fonts/BungeeSpice-Regular.ttf",200);

        /*
        // 🔽 1. Carica tutte le texture una volta sola
        for (int i = 0; i < cards.getCardCount(); i++) {
            cards.getCardById(i).loadTextureIfNeeded();
        }
        */

        //DrawCard drawCard = new DrawCard(cards.getCardById(0),new Vector2().x(0).y(0), new Vector2().x(0).y(0),font);


        // 🔁 2. Loop di rendering
        while (!WindowShouldClose()) {
            BeginDrawing();
            ClearBackground(BLACK);

            //drawCard.draw(cards.getCardById(0));

            switch (gameState) {
                case MAIN_MENU:
                    menu.drawMainMenu(font,GetScreenWidth(),GetScreenHeight()); // Disegna il menu solo una volta
                    if (IsKeyPressed(KEY_ENTER)) gameState = GameState.GAME;
                    break;

                case GAME:
                    //drawGame();
                    //updateGameLogic();
                    if (IsKeyPressed(KEY_SPACE)) gameState = GameState.PAUSE;
                    break;

                case PAUSE:
                    //drawPauseScreen();
                    if (IsKeyPressed(KEY_ENTER)) gameState = GameState.GAME;
                    break;

                case GAME_OVER:
                    //drawGameOver();
                    break;
                case EXIT:
                    gameState = GameState.EXIT;
                    break;
            }

            DrawText("FPS: " + GetFPS(), 20, 20, 20, GREEN);
            EndDrawing();
        }

        /*
        // 🧹 3. Scarica tutte le texture alla fine
        for (int i = 0; i < cards.getCardCount(); i++) {
            cards.getCardById(i).unloadTexture();
        }
        */

        CloseWindow();
    }
}
