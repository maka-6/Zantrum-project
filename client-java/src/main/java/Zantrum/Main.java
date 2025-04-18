package Zantrum;

import Zantrum.player.Player;
import Zantrum.match.*;

import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

public class Main {
    public static void main(String[] args) {

        GameSession game = new GameSession();

        System.out.println("Hello World!");

        int height = GetMonitorHeight(1080), width = GetMonitorWidth(1980);
        InitWindow(width, height, "Zantrum - crato con Raylib Java");
        SetTargetFPS(60);// Set our game to run at 60 frames-per-second

        while (!WindowShouldClose()){

            BeginDrawing();
            ClearBackground(RAYWHITE);

            DrawText("Zantrum", 110, 490, 100, BLACK);

            EndDrawing();
        }
        CloseWindow();
    }
}