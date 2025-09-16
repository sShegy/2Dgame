package main;

import entity.Entity;

public class CollisionChecker {

    GameBanner gp;


    public CollisionChecker(GameBanner gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {

        int entityLeftWorldX= entity.worldX +entity.solidArea.x;
        int entityRightWorldX= entity.worldX +entity.solidArea.x+entity.solidArea.width;
        int entityTopWorldY= entity.worldY +entity.solidArea.y;
        int entityBottomWorldy= entity.worldY +entity.solidArea.y+entity.solidArea.height;

        int entityLeftCol=entityLeftWorldX/gp.tileSize;
        int entityRightCol=entityRightWorldX/gp.tileSize;
        int entityTopRow=entityTopWorldY/gp.tileSize;
        int entityBottomRow=entityBottomWorldy/gp.tileSize;

        int tileNumber1,tileNumber2;
        switch (entity.direction){
            case "up":
                entityTopRow=(entityTopWorldY-entity.speed)/gp.tileSize;
                tileNumber1=gp.tileMenager.mapTileNum[entityLeftCol][entityTopRow];
                tileNumber2=gp.tileMenager.mapTileNum[entityRightCol][entityTopRow];
                if(gp.tileMenager.tile[tileNumber1].collision==true||gp.tileMenager.tile[tileNumber2].collision==true){
                    entity.collisionOn=true;
                }
                break;
                case "down":
                    entityBottomRow=(entityBottomWorldy+entity.speed)/gp.tileSize;
                    tileNumber1=gp.tileMenager.mapTileNum[entityLeftCol][entityBottomRow];
                    tileNumber2=gp.tileMenager.mapTileNum[entityRightCol][entityBottomRow];
                    if(gp.tileMenager.tile[tileNumber1].collision==true||gp.tileMenager.tile[tileNumber2].collision==true){
                        entity.collisionOn=true;
                    }
                    break;
                    case "left":
                        entityLeftCol=(entityLeftWorldX-entity.speed)/gp.tileSize;
                        tileNumber1=gp.tileMenager.mapTileNum[entityLeftCol][ entityTopRow];
                        tileNumber2=gp.tileMenager.mapTileNum[entityRightCol][entityBottomRow];
                        if(gp.tileMenager.tile[tileNumber1].collision==true||gp.tileMenager.tile[tileNumber2].collision==true){
                            entity.collisionOn=true;
                        }
                        break;
                        case "right":
                            entityRightCol=(entityRightWorldX+entity.speed)/gp.tileSize;
                            tileNumber1=gp.tileMenager.mapTileNum[entityLeftCol][entityBottomRow];
                            tileNumber2=gp.tileMenager.mapTileNum[entityRightCol][entityBottomRow ];
                            if(gp.tileMenager.tile[tileNumber1].collision==true||gp.tileMenager.tile[tileNumber2].collision==true){
                                entity.collisionOn=true;
                            }
                            break;
        }

    }
    public int checkCObject(Entity entity,boolean player) {
        int index=9999;
            for (int i=0;i<=gp.obj.length;i++){
                if (gp.obj[i]!= null) {
                    //Get entity's solid arean position
                    entity.solidArea.x=entity.worldX+entity.solidArea.x;
                    entity.solidArea.y=entity.worldY+entity.solidArea.y;
                    //Get entity's solid arean position
                    gp.obj[i].solidArea.x=gp.obj[i].worldX+gp.obj[i].solidArea.x;
                    gp.obj[i].solidArea.y=gp.obj[i].worldY+gp.obj[i].solidArea.y;



                }
            }


        return index;
    };
}
