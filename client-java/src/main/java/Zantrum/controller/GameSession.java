package Zantrum.controller;

import Zantrum.view.Interfaces;
// import Zantrum.model.Player;
import Zantrum.model.GameState;
import com.raylib.Raylib;
import Zantrum.view.InitWindow;

import java.util.ArrayList;

import static Zantrum.view.FontUtils.loadHighQualityFont;
import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

public class GameSession {

    private final ArrayList<Round> rounds;
    /*
    private ArrayList<Player> players;
    private final CardDb cards;
    private final int result;
    private int turn;
    private boolean turnOver;
    */
    private Interfaces interfaces;
    public Raylib.Font font;

    private GameState gameState;

    InitWindow window;

    public GameSession() {

        this.gameState = GameState.START;
        this.rounds = new ArrayList<>();

        //this.result = 0;  // Inizializzare con un risultato predefinito, ad esempio 0
        //this.turn = 1;    // Inizializzare con il primo turno
        // this.turnOver = false;
        // cards = new CardDb();
        window = new InitWindow();
        this.font = window.font;
        this.interfaces = window.interfaces;
    }

    public void startGame() {

        /*
        // 🔽 1. Carica tutte le texture una volta sola
        for (int i = 0; i < cards.getCardCount(); i++) {
            cards.getCardById(i).loadTextureIfNeeded();
        }
        */

        gameLoop();
        /*
        // 🧹 3. Scarica tutte le texture alla fine
        for ( int i = 0; i < cards.getCardCount(); i++ ) {
            cards.getCardById(i).unloadTexture();
        }
        */
        CloseWindow();
    }

    // game loop
    public void gameLoop() {
        // 🔁 2. Loop di rendering
        while (!WindowShouldClose()) {
            BeginDrawing();
            //drawCard.draw(cards.getCardById(0));
            update();
            render(font);
            DrawText("FPS: " + GetFPS(), 10, 10, 20, GREEN);
            EndDrawing();
        }
    }

    public ArrayList<Round> getRounds() {
        return rounds;
    }

    public void update() {
        // Gestisci input e cambia stato se necessario
        if (IsKeyPressed(KEY_ENTER) && gameState == GameState.START) {
            //interfaces.transition(BLACK, 1);
            gameState = GameState.MAIN_MENU;
        }
        else if (IsKeyPressed(KEY_ENTER) && gameState == GameState.MAIN_MENU) {
            gameState = GameState.GAME_OVER;
        }
        // ...
    }

    public void render(Font font) {
        interfaces.draw(font, GetScreenWidth(), GetScreenHeight(), gameState);
    }
}
