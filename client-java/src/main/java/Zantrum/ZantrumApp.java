package Zantrum;

import Zantrum.controller.GameSession;

import java.util.ArrayList;

public class ZantrumApp {
    public static void main(String[] args) {

        System.out.println("Hello italy!");
        GameSession session = new GameSession();
        session.startGame(new ArrayList<>());
    }
}