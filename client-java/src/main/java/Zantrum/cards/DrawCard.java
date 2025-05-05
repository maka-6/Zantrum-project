package Zantrum.cards;

import com.raylib.*;

import static com.raylib.Colors.*;
import static com.raylib.Colors.BLACK;
import static com.raylib.Raylib.DrawText;
import static com.raylib.Raylib.DrawTexture;

public class DrawCard {

    private Card card;                   // Il dato logico
    private Raylib.Vector2 position;           // Posizione sullo schermo
    private Raylib.Vector2 size;               // Dimensioni scalabili
    private Raylib.Texture texture;   // Eventuale texture già caricata
    private boolean selected;           // Per il drag & drop
    private Raylib.Font font;                  // Font usato
    private boolean moveable;                  // se si puo spostare con il mouse

    public DrawCard(Card card, Raylib.Vector2 position, Raylib.Vector2 size, Raylib.Font font) {
        this.card = card;
        this.position = position;
        this.size = size;
        this.font = font;
        this.selected = false;
        this.moveable = true;
        // carica texture se necessaria
        draw(card);
    }

    public void draw(Card card) {
        // disegna rettangolo, nome, descrizione ecc.
        DrawTexture(card.getTexture(), 100, 100 + (150 ), WHITE);
        DrawText("Name: " + card.getName(), 100, 120 + (150), 20, BLACK);
        DrawText("life: " + card.getLife(), 100, 150 + (150), 20, BLACK);
        DrawText("id: " + card.getNumber(), 100, 180 + (150), 20, BLACK);
        DrawText("Type: " + card.getType(), 100, 210 + (150), 20, RED);
        DrawText("description:", 100, 240 + (150), 20, BLACK);
        DrawText(card.getDescription(), 100, 270 + (150), 20, BLACK);
    }

    public void update() {
        // controlla se è cliccata, spostata ecc.
    }

    public boolean isHovered(Raylib.Vector2 mousePos) {
        // ritorna true se il mouse è sopra
        return false;
    }

    public void move(Raylib.Vector2 delta) {
        float newX = position.x() + delta.x();
        float newY = position.y() + delta.y();
        position.x(newX);
        position.y(newY);
    }
}
