package Zantrum.session;

import java.util.Random;

import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

public class Menu {

    // Disegna il titolo al centro
    String title;
    int textSize;
    int textWidth;
    Particle[] particles;

    public Menu() {
        title = "MAKA";
        textSize = 40;
        textWidth = MeasureText(title, textSize);

        // Inizializza particelle UNA SOLA VOLTA
        particles = new Particle[1000];
        for (int i = 0; i < particles.length; i++) {
            particles[i] = new Particle((float)(Math.random() * 2 * Math.PI), (float)Math.random() * 20);
        }
    }


    void drawMainMenu (Font font, int screenWidth, int screenHeight) {

        // Update e disegno delle particelle
        for (int i = 0; i < particles.length; i++) {
            particles[i].update();
            particles[i].draw();
        }

        // Calcola la dimensione del testo
        Vector2 textSize = MeasureTextEx(font, "Zantrum", 200, 2);
        // Posizione al centro dello schermo
        Vector2 position = new Vector2();  // leggermente sopra
        position.x(screenWidth / 2.0f).y(screenHeight / 2.5f);
        // Origine centrata rispetto alla scritta
        Vector2 origin = new Vector2();
        origin.x(textSize.x() / 2.0f).y(textSize.y() / 2.0f);

        // Calcola la dimensione del testo
        Vector2 textSize2 = MeasureTextEx(font, "Press any key", 50, 2);
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
}

class Particle {
    float radius;
    float angle;
    float length;
    float delayTime;
    float timeSinceStart;

    static final float SPEED = 100f;
    static final float MAX_RADIUS = 1500f;

    public Particle(float angle, float length) {
        this.angle = angle;
        this.length = length;
        reset();
    }

    private void reset() {
        this.radius = 0;
        this.timeSinceStart = 0;
        this.delayTime = (float)(Math.random() * 20.0);
    }

    public void update() {
        float dt = GetFrameTime();
        timeSinceStart += GetFrameTime();

        if (timeSinceStart < delayTime) return;

        radius += dt * SPEED;
        angle+=0.005f;

        if (radius > MAX_RADIUS || Float.isNaN(radius) || Float.isInfinite(radius)) {
            reset();
        }
    }

    public void draw() {
        if (timeSinceStart < delayTime) return;

        float centerX = GetScreenWidth() / 2.0f;
        float centerY = GetScreenHeight() / 2.0f;

        float x1 = centerX + (float) Math.cos(angle) * radius;
        float y1 = centerY + (float) Math.sin(angle) * radius;
        float x2 = centerX + (float) Math.cos(angle) * (radius + length);
        float y2 = centerY + (float) Math.sin(angle) * (radius + length);

        // Verifica che non siano NaN o infiniti
        if (Float.isInfinite(x1) || Float.isInfinite(y1) || Float.isInfinite(x2) || Float.isInfinite(y2)) return;

        Vector2 start = new Vector2().x(x1).y(y1);
        Vector2 end = new Vector2().x(x2).y(y2);
        DrawLineV(start, end, WHITE);
    }
}