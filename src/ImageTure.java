import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by YuRacle on 2017/7/27.
 * 图片路径为工程根目录
 * 图片彩色转灰度
 */

public class ImageTure {

    public static void main(String[] args) {
        new ImageTure().turnToHui("1.jpg","out.jpg");
    }

    public void turnToHui(String path, String outPath) {
        File file = new File(path);
        BufferedImage image = null;

        try {
            image = ImageIO.read(file);
            int width = image.getWidth();
            int height = image.getHeight();
            for (int i=0; i<width; i++) {
                for (int j = 0; j < height; j++) {
                    int rgb = image.getRGB(i, j);
                    int r = (rgb&0xff0000)>>16;
                    rgb = (r<<16)+(r<<8)+r;
                    image.setRGB(i, j, rgb);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file2 = new File(outPath);
        try {
            ImageIO.write(image, "jpg", file2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
