package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window=new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D adveture");

        GameBanner gameBanner=new GameBanner();
        window.add(gameBanner);
        window.pack();

        gameBanner.startGameThread();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}