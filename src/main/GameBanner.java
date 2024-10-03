package main;

import entity.Player;
import tile.TileManager;

import java.awt.*;
import javax.swing.JPanel;

public class GameBanner extends JPanel implements Runnable{

    //screen setting
    final  int originalTitle=16;//16x16 tile
    final  int scale =3;
    public final  int tileSize=originalTitle*scale;//48*48 tile

    public final int maxScreenRow=12;
    public final int maxScreenCol=16;

    final int screenWidth=tileSize*maxScreenCol; //768 pixels
    final int screenHeight =tileSize*maxScreenRow;//576 pixels

    KeyHadnler keyH=new KeyHadnler();

    //set players default position
//    int playerX=100;
//    int playerY =100;
//    int playerSpeed=4;

    //FPS
    int FPS=60;
    //Map
    TileManager tileMenager=new TileManager(this);
    //Player
    Player player=new Player(this,keyH);
    //Time
    Thread gameThread;

    public GameBanner()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }



    public void  startGameThread(){
        gameThread=new Thread(this);
        gameThread.start();
    }

//    @Override
//    public void run() {
//
//        double drawInterval=1000000000/FPS; //0.01666 seconds
//        double nextDrawTime=System.nanoTime()+ drawInterval;
//
//        while (gameThread!=null){
//            //System.out.println("pedja");
//
//            update();
//
//            repaint();
//
//            try {
//                double remainingTime=nextDrawTime-System.nanoTime();
//                remainingTime=remainingTime/1000000;
//
//                if (remainingTime<0){
//                    remainingTime=0;
//                }
//
//                Thread.sleep((long) remainingTime);
//                nextDrawTime+=drawInterval;
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
    @Override
    public void run() {

        double drawInterval=1000000000/FPS; //0.01666 seconds
        double delta =0;
        long lastTime=System.nanoTime();
        long currentTime;
        long time=0;
        int drawTime=0;

        while (gameThread!=null){
            currentTime=System.nanoTime();
            delta+=(currentTime-lastTime)/drawInterval;
            time+=(currentTime-lastTime);
            lastTime=currentTime;
            if (delta>=1){
                update();
                repaint();
                delta--;
                drawTime++;
            }
            if (time>=1000000000){
                System.out.printf("FPS:"+drawTime+"\n");
                drawTime=0;
                time=0;
            }
        }
    }
    public void update(){
        player.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2=(Graphics2D)g;
        tileMenager.draw(g2);
        player.draw(g2);
        g2.dispose();
    }
}
