package entity;

import main.GameBanner;
import main.KeyHadnler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
        GameBanner gp;
        KeyHadnler keyH;

        public  final int screenX;
        public  final int screenY;

    public Player(GameBanner gp, KeyHadnler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        screenX = gp.screenWidth/2-(gp.tileSize/2);
        screenY = gp.screenHeight/2-(gp.tileSize/2);

        solidArea=new Rectangle();
        solidArea.x=8;
        solidArea.y=16;
        solidArea.width=32;
        solidArea.height=32;

        setDefaultValues();
        getPlayerImage();
    }
    public  void setDefaultValues(){
        worldX =gp.tileSize*23;
        worldY =gp.tileSize*21;

        speed  =4;
        direction="down";
    }
    public void getPlayerImage(){
        try {
            up1= ImageIO.read(getClass().getResourceAsStream("/res/player/player/boy_up_1.png"));
            up2= ImageIO.read(getClass().getResourceAsStream("/res/player/player/boy_up_2.png"));
            down1= ImageIO.read(getClass().getResourceAsStream("/res/player/player/boy_down_1.png"));
            down2= ImageIO.read(getClass().getResourceAsStream("/res/player/player/boy_down_2.png"));
            right1= ImageIO.read(getClass().getResourceAsStream("/res/player/player/boy_right_1.png"));
            right2= ImageIO.read(getClass().getResourceAsStream("/res/player/player/boy_right_2.png"));
            left1= ImageIO.read(getClass().getResourceAsStream("/res/player/player/boy_left_1.png"));
            left2= ImageIO.read(getClass().getResourceAsStream("/res/player/player/boy_left_2.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public  void  update(){
        if (keyH.downP==true|| keyH.upP==true || keyH.leftP==true || keyH.rightP==true){
            if (keyH.upP==true){
                direction="up";

            }else if (keyH.downP==true){
                direction="down";

            }else if (keyH.leftP==true){
                direction="left";

            }else if (keyH.rightP==true){
                direction="right";

            }
            //CHECK TILE COLLISION
            collisionOn=false;
            gp.collisionChecker.checkTile(this);

            //IF COLLISION IS FALSE,PLAYER CAN MOVE
            if (collisionOn==false){
                switch (direction){
                    case "up":
                        worldY -=speed;
                        break;
                        case "down":
                            worldY +=speed;
                            break;
                            case "left":
                                worldX -=speed;
                                break;
                                case "right":
                                    worldX +=speed;
                                    break;

                }
            }

            spriteCounter++;
            if (spriteCounter>10){
                if (spriteNum==1){
                    spriteNum=2;
                }else if (spriteNum==2){
                    spriteNum=1;
                }
                spriteCounter=0;
            }
        }

    }
    public  void draw(Graphics2D g2){

//        g2.setColor(Color.white);
//        g2.fillRect(worldX,worldY, gp.tileSize, gp.tileSize);
        BufferedImage image=null;
        switch (direction){
            case "up":
                if (spriteNum==1){
                    image=up1;
                }
                if (spriteNum==2){
                    image=up2;
                }
                break;
            case "down":
                if (spriteNum==1){
                    image=down1;
                }
                if (spriteNum==2){
                    image=down2;
                }
                break;
            case "left":
                if (spriteNum==1){
                    image=left1;
                }
                if (spriteNum==2){
                    image=left2;
                }
                break;
            case  "right":
                if (spriteNum==1){
                    image=right1;
                }
                if (spriteNum==2){
                    image=right2;
                }
                break;
        }

        g2.drawImage(image, screenX, screenY,gp.tileSize, gp.tileSize, null);
    }


}
