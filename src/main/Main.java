package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JFrame window=new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D adveture");

        Image Logo = ImageIO.read(new File("C:\\Users\\Shegy\\Desktop\\2Dgame\\res\\player\\Logo.jpg"));
        window.setIconImage(Logo);

        GameBanner gameBanner=new GameBanner();
        window.add(gameBanner);
        window.pack();

        gameBanner.startGameThread();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}