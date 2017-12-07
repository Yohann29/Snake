/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;

/**
 *
 * @author Amaury
 */
public class Ring {
    public int posX, posY;
    Color color;
    
    public Ring(int x, int y, Color color){
        this.posX = x;
        this.posY = y;
        this.color = color;
    }
}
