package object;

import javax.imageio.ImageIO;

public class OBJ_KEY extends SuperObject{
    public OBJ_KEY() {
        name="KEY";
        try {
            image= ImageIO.read(getClass().getResourceAsStream("/res/player/objects/key.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
