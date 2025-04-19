package Zantrum;

import Zantrum.cards.CardDb;
import Zantrum.game.Round;
import Zantrum.match.*;

import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

public class Main {
    public static void main(String[] args) {
        GameSession game = new GameSession();
        Round round = new Round();
        CardDb cards = round.getCardDb();
        game.addGame(round);

        System.out.println("Hello World!");

        int height = GetMonitorHeight(0), width = GetMonitorWidth(0);  // Usa 0 per il primo monitor
        InitWindow(width, height, "Zantrum - creato con Raylib Java");
        SetTargetFPS(60);

        // 🔽 1. Carica tutte le texture una volta sola
        for (int i = 0; i < cards.getCardCount(); i++) {
            cards.getCardById(i).loadTextureIfNeeded();
        }

        // 🔁 2. Loop di rendering
        while (!WindowShouldClose()) {
            BeginDrawing();
            ClearBackground(RAYWHITE);

            DrawText("Zantrum", 0, 0, 200, BLACK);

            for (int i = 0; i < cards.getCardCount(); i++) {

                /*
                Card card = cards.getCardById(i);
                DrawTexture(card.getTexture(), 100, 100 + (150 * i), WHITE);
                DrawText("Name: " + card.getName(), 300, 120 + (150 * i), 20, BLACK);
                DrawText("life: " + card.getLife(), 300, 150 + (150 * i), 20, BLACK);
                DrawText("id: " + card.getNumber(), 300, 180 + (150 * i), 20, BLACK);
                DrawText("Type: " + card.getType(), 300, 210 + (150 * i), 20, RED);
                DrawText("description:", 300, 240 + (150 * i), 20, BLACK);
                DrawText(card.getDescription(), 300, 270 + (150 * i), 20, BLACK);
                */

            }

            EndDrawing();
        }

        // 🧹 3. Scarica tutte le texture alla fine
        for (int i = 0; i < cards.getCardCount(); i++) {
            cards.getCardById(i).unloadTexture();
        }

        CloseWindow();
    }
}