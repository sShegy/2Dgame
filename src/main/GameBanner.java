package main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GameBanner extends JPanel implements Runnable{

    //screen setting
    final  int originalTitle=16;//16x16 tile
    final  int scale =3;
    final  int tileSize=originalTitle*scale;//48*48 tile

    final int maxScreenRow=12;
    final int maxScreenCol=16;

    final int screenWidth=tileSize*maxScreenCol; //768 pixels
    final int screenHeight =tileSize*maxScreenRow;//576 pixels

    Thread gameThread;
    public GameBanner()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);

    }

    public void  startGameThread(){
        gameThread=new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {

        while (gameThread!=null){
            System.out.println("pedja");
        }
    }
}
