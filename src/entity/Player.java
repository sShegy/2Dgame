package entity;

import main.GameBanner;
import main.KeyHadnler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Player extends Entity{
        GameBanner gp;
        KeyHadnler keyH;

    public Player(GameBanner gp, KeyHadnler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }
    public  void setDefaultValues(){
        x=100;
        y=100;
        speed=4;
        direction="down";
    }
    public void getPlayerImage(){
        try {
            up1= ImageIO.read(getClass().getResourceAsStream("/player_sprites/boy_up_1.png"));
            up2= ImageIO.read(getClass().getResourceAsStream("/player_sprites/boy_up_2.png"));
            down1= ImageIO.read(getClass().getResourceAsStream("/player_sprites/boy_down_1.png"));
            down2= ImageIO.read(getClass().getResourceAsStream("/player_sprites/boy_down_2.png"));
            right1= ImageIO.read(getClass().getResourceAsStream("/player_sprites/boy_right_1.png"));
            right2= ImageIO.read(getClass().getResourceAsStream("/player_sprites/boy_right_2.png"));
            left1= ImageIO.read(getClass().getResourceAsStream("/player_sprites/boy_left_1.png"));
            left2= ImageIO.read(getClass().getResourceAsStream("/player_sprites/boy_left_2.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public  void  update(){
        if (keyH.upP==true){
            direction="up";
            y-=speed;
        }else if (keyH.downP==true){
            direction="down";
            y+=speed;
        }else if (keyH.leftP==true){
            direction="left";
            x-=speed;
        }else if (keyH.rightP==true){
            direction="right";
            x+=speed;
        }
    }
    public  void draw(Graphics2D g2){
        g2.setColor(Color.white);

        g2.fillRect(x,y, gp.tileSize, gp.tileSize);
    }


}