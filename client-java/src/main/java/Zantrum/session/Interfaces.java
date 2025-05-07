package Zantrum.session;

import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

public class Interfaces {

    private Particle[] particles;
    private String title = "MAKA";
    private int textSize = 40;
    private int textWidth;

    public Interfaces() {
        textWidth = MeasureText(title, textSize);
        particles = new Particle[1000];
        for (int i = 0; i < particles.length; i++) {
            particles[i] = new Particle((float)(Math.random() * 2 * Math.PI), (float)Math.random() * 100);
        }
    }

    public void transition(Color color, int speed) {

        for (int alpha = 0; alpha <= 255; alpha += speed) {
            ClearBackground(RAYWHITE);
            // Qui puoi ridisegnare lo stato attuale o lasciare vuoto
            DrawRectangle(0, 0, GetScreenWidth(), GetScreenHeight(), Fade(color, alpha / 255.0f));
        }

        // Cambia stato qui se necessario

        for (int alpha = 255; alpha >= 0; alpha -= speed) {
            ClearBackground(RAYWHITE);
            // Qui puoi disegnare il nuovo stato o lasciare vuoto
            DrawRectangle(0, 0, GetScreenWidth(), GetScreenHeight(), Fade(color, alpha / 255.0f));
        }
    }

    public void draw(Font font, int screenWidth, int screenHeight, GameSession.GameState currentState) {
        switch (currentState) {
            case START: drawStart(font, screenWidth, screenHeight); break;
            case MAIN_MENU: drawMainMenu(font, screenWidth, screenHeight); break;
            case GAME_OVER: drawGameOver(font, screenWidth, screenHeight); break;
        }
    }

    private void drawStart(Font font, int screenWidth, int screenHeight) {

        ClearBackground(BLACK);

        // disegno le linee tutte in una volta + ottimizzata
        for (Particle p : particles) {
            p.update();
        }
        drawAllParticles(); // Tutto in una sola chiamata GPU

        // Calcola la dimensione del testo
        Vector2 textSize = MeasureTextEx(font, "Zantrum", 200, 2);
        // Posizione al centro dello schermo
        Vector2 position = new Vector2();  // leggermente sopra
        position.x(screenWidth / 2.0f).y(screenHeight / 2.5f);
        // Origine centrata rispetto alla scritta
        Vector2 origin = new Vector2();
        origin.x(textSize.x() / 2.0f).y(textSize.y() / 2.0f);

        // Calcola la dimensione del testo
        Vector2 textSize2 = MeasureTextEx(font, "Press enter", 50, 2);
        // Posizione al centro dello schermo
        Vector2 position2 = new Vector2();  // più visibile
        position2.x(screenWidth / 2.0f).y(screenHeight * 0.75f);
        // Origine centrata rispetto alla scritta
        Vector2 origin2 = new Vector2();
        origin2.x(textSize2.x() / 2.0f).y(textSize2.y() / 2.0f);

        // Titolo al centro
        DrawTextPro(font, "Zantrum", position, origin, 0.0f, 200, 2, RAYWHITE);

        // Sottotitolo sotto
        DrawTextPro(font, "Press any key", position2, origin2, 0.0f, 50, 2, GRAY);
    }

    private void drawMainMenu(Font font, int screenWidth, int screenHeight) {
        // TODO: Aggiungi voci di menu, sfondi, ecc.
        ClearBackground(BLACK);

        // disegno le linee tutte in una volta + ottimizzata
        for (Particle p : particles) {
            p.update();
        }
        drawAllParticles(); // Tutto in una sola chiamata GPU

        DrawRectangle(0,0, 200, 200, RED);
        DrawRectangle(screenWidth-200,screenHeight-200, 200, 200, BLUE);
        DrawRectangle(0,screenHeight-200, 200, 200, GREEN);
        DrawRectangle(screenWidth-200,0, 200, 200, VIOLET);

        DrawCircle(screenWidth/2, screenHeight/2,(screenHeight+screenWidth)/10,ORANGE);

        // Calcola la dimensione del testo
        Vector2 textSize = MeasureTextEx(font, "Benvenuto", 100, 2);
        // Posizione al centro dello schermo
        Vector2 position = new Vector2();  // leggermente sopra
        position.x(screenWidth / 2.0f).y(screenHeight / 2.0f);
        // Origine centrata rispetto alla scritta
        Vector2 origin = new Vector2();
        origin.x(textSize.x() / 2.0f).y(textSize.y() / 2.0f);

        DrawTextPro(font, "Benvenuto",position, origin, 0, 100,2, WHITE);


    }

    private void drawGameplayUI(Font font, int screenWidth, int screenHeight) {
        // HUD (vite, punteggio, ecc.)
    }

    private void drawPauseMenu(Font font, int screenWidth, int screenHeight) {
        // Menu di pausa
        ClearBackground(BLACK);

        // ... Testi di avvio
        // disegno le linee tutte in una volta + ottimizzata
        for (Particle p : particles) {
            p.update();
        }
        drawAllParticles(); // Tutto in una sola chiamata GPU
        DrawRectangle(0,0, 200, 200, RED);
    }

    private void drawGameOver(Font font, int screenWidth, int screenHeight) {
        // Schermata Game Over
        ClearBackground(BLACK);
        for (Particle p : particles) p.update();
        drawAllParticles();
        for (Particle p : particles) p.update();
        drawAllParticles(); // Tutto in una sola chiamata GPU
        for (Particle p : particles) p.update();
        drawAllParticles();
        // Calcola la dimensione del testo
        Vector2 textSize = MeasureTextEx(font, "Game Over :(", 100, 2);
        // Posizione al centro dello schermo
        Vector2 position = new Vector2();  // leggermente sopra
        position.x(screenWidth / 2.0f).y(screenHeight / 2.0f);
        // Origine centrata rispetto alla scritta
        Vector2 origin = new Vector2();
        origin.x(textSize.x() / 2.0f).y(textSize.y() / 2.0f);

        DrawTextPro(font, "Game Over :(",position, origin, 0, 100,2, WHITE);
    }

    private void drawAllParticles() {
        rlBegin(RL_LINES);
        for (Particle p : particles) {
            if (p.timeSinceStart < p.delayTime) continue;
            float centerX = GetScreenWidth() / 2.0f;
            float centerY = GetScreenHeight() / 2.0f;
            float x1 = centerX + (float) Math.cos(p.angle) * p.radius;
            float y1 = centerY + (float) Math.sin(p.angle) * p.radius;
            float x2 = centerX + (float) Math.cos(p.angle) * (p.radius + p.length);
            float y2 = centerY + (float) Math.sin(p.angle) * (p.radius + p.length);
            if (Float.isInfinite(x1) || Float.isInfinite(y1) || Float.isInfinite(x2) || Float.isInfinite(y2)) continue;
            rlColor4ub((byte)255, (byte)255, (byte)255, (byte)255);
            rlVertex2f(x1, y1);
            rlVertex2f(x2, y2);
        }
        rlEnd();
    }
}

class Particle {
    float radius;
    float angle;
    float length;
    float delayTime;
    float timeSinceStart;

    //
    static float SPEED = 600f;      //
    static final float MAX_RADIUS = GetScreenWidth() * 1.5f;        //

    public Particle(float angle, float length) {
        this.angle = angle;
        this.length = length;
        reset();
    }

    //
    private void reset() {
        this.radius = 0;
        this.timeSinceStart = 0;
        this.delayTime = (float)(Math.random() * 20.0);
    }

    //
    public void update() {
        float dt = GetFrameTime();
        timeSinceStart += GetFrameTime()*3;

        //
        if (timeSinceStart < delayTime)
            return;

        //
        radius += dt * SPEED;

        // rotazione
        angle+=0.00f;

        //
        if (radius > MAX_RADIUS || Float.isNaN(radius) || Float.isInfinite(radius)) {
            reset();
        }
    }

}