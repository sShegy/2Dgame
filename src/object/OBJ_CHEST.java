package object;

import javax.imageio.ImageIO;

public class OBJ_CHEST extends SuperObject{
    public OBJ_CHEST() {
        name="CHEST";
        try {
            image= ImageIO.read(getClass().getResourceAsStream("/res/player/objects/chest.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
