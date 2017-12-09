package snake;

import java.awt.Color;

public class Enemy {

    public int posX, posY;
    Color color;

    public Enemy(int x, int y, Color color) {
        this.posX = x;
        this.posY = y;
        this.color = color;
    }
}
