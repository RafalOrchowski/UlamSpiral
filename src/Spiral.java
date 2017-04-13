import java.awt.image.BufferedImage;


public class Spiral {

    private int[][] array;
    private int dims;
    private BufferedImage img;


    public Spiral(int dims) {
        array = new int[dims][dims];
        this.dims = dims;
        img = new BufferedImage(dims, dims, BufferedImage.TYPE_INT_RGB);
    }


    private void setImg(int x, int y, int n) {
        array[x][y] = n;
        if (!isPrime(n))
            img.setRGB(x, y, -1);
        else
            img.setRGB(x, y, 0);
    }

    private boolean isPrime(long n) {
        if (n > 2 && (n & 1) == 0) {
            return false;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public BufferedImage getimg() { // returns image drawn by this tricky algorithm
        int n = dims * dims;
        int x = 0;
        int y = 0;
        if (dims % 2 != 0) {
            x = dims--;
            y = dims--;
        }

        while (n != 1) { // calls setImg (that draws single pixels, black when prime) for every pixel. From edges to the center.
            while (x > 0 && array[x - 1][y] < n) {
                setImg(x--, y, n--);
            }
            while (y > 0 && array[x][y - 1] < n) {
                setImg(x, y--, n--);
            }
            while ((x + 1) < array.length && array[x + 1][y] < n) {
                setImg(x++, y, n--);
            }
            while ((y + 1) < array[0].length && array[x][y + 1] < n) {
                setImg(x, y++, n--);
            }


        }

        return img;
    }

}
