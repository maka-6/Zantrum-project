import Cards.Card;

import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello World!");

        int height = GetMonitorHeight(1080), width = GetMonitorWidth(1980);
        InitWindow(width, height, "Gioco di Carte - Raylib Java");
        System.out.println(height + " " + width);
        SetTargetFPS(60);               // Set our game to run at 60 frames-per-second

        Card card = new Card("Tum tum tum Saul", 1, 100, "Picchia con una mazza", 1);

        while (!WindowShouldClose()){
            BeginDrawing();
            ClearBackground(RAYWHITE);
            DrawText("Hello", width/2, height/2, 100, BLACK);

            DrawRectangle(100, 100, 200, 300, LIGHTGRAY);  // Rettangolo base
            DrawText("Nome: " + card.getName(), 110, 120, 20, BLACK);
            DrawText("Vita: " + card.getLife(), 110, 150, 20, DARKGREEN);
            DrawText("Descrizione:", 110, 180, 20, BLACK);
            DrawText(card.getDescription(), 110, 210, 18, GRAY);

            EndDrawing();
        }
        CloseWindow();
    }
}