package Zantrum.view;

import com.raylib.Raylib;

import static Zantrum.view.FontUtils.loadHighQualityFont;
import static com.raylib.Raylib.*;
import static com.raylib.Raylib.GetMonitorHeight;
import static com.raylib.Raylib.GetMonitorWidth;
import static com.raylib.Raylib.InitWindow;
import static com.raylib.Raylib.SetTargetFPS;
import static com.raylib.Raylib.ToggleFullscreen;

public class InitWindow {

    public Raylib.Font font;
    public Interfaces interfaces;

    public InitWindow() {
        initWindow();
    }

    public void initWindow() {
        // La partita se rimarrà su questa classe...
        int fps = 165;
        Raylib.Image icon = LoadImage("resources/icon.png");

        SetWindowIcon(icon);
        InitWindow(GetMonitorWidth(0), GetMonitorHeight(0), "Zantrum");
        ToggleFullscreen();
        SetTargetFPS(fps);


        this.font = loadHighQualityFont("resources/fonts/BungeeSpice-Regular.ttf",200);

        interfaces = new Interfaces();
    }
}
