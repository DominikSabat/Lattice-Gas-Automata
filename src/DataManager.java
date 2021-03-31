import java.awt.image.BufferedImage;

public class DataManager {

    BufferedImage img;

    Cell[][] particleLast;
    Cell[][] particleCurrent;

    int width;
    int height;

    int iteracje;

    public DataManager() {
        particleLast = new Cell[width][height];
        particleCurrent = new Cell[width][height];
    }
}