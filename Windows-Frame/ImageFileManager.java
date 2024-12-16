import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageFileManager {
    public static OFImage loadImage(String filePath) {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(filePath));
            return new OFImage(bufferedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
