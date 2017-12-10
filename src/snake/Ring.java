package snake;

import java.awt.Color;

public class Ring {

    public int posX, posY;
    Color color;

    // Initialisation des parties du corps du serpent
    public Ring(int x, int y, Color color) {
        this.posX = x;
        this.posY = y;
        this.color = color;
    }
}
