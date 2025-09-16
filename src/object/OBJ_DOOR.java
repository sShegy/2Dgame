package object;

import javax.imageio.ImageIO;

public class OBJ_DOOR extends SuperObject{
    public OBJ_DOOR() {
        name="DOOR";
        try {
            image= ImageIO.read(getClass().getResourceAsStream("/res/player/objects/door.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
        collision=true;
    }

}
