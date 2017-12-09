package snake;

import java.awt.Color;

public class Obstacle {

    public int posX, posY;
    Color color;

    public Obstacle(int x, int y, Color color) {
        this.posX = x;
        this.posY = y;
        this.color = color;
    }
}
