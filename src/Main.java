import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

// @TODO multithreading, setting the size of img from user input and optimization of the algorithm
public class Main{

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        Spiral ulam = new Spiral(5000); // parameter is setting the dimension for square .png image
        File file = new File("spiralImg.png");
        try {
            ImageIO.write(ulam.getimg(), "png", file);
        } catch (IOException e) {
            System.err.println("Image couldn't be created");
        }
        time = System.currentTimeMillis() - time; // calculating time it took to generate image
        System.out.println(time + " ms");
    }
}