/*
 * Autore: Makaoui Youness
 * Data: 29/9/2025
 * Luogo: xx
 * Descrizione:
 */

package Zantrum;

import Zantrum.controller.GameSession;

public class ZantrumApp {
    public static void main(String[] args) {
        System.out.println("Hello italy!");
        GameSession session = new GameSession();
        session.startGame();
    }
}