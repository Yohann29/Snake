/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author Amaury
 */
public class Character extends JPanel{
    public int size;
    Graphics g;
    public boolean play = true;
    public int numberOfEnemies;
    Scanner sc;
    ArrayList<Ring> body = new ArrayList<Ring>();
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    public int direction = 4;
    public Character(Graphics g, int size){
        this.g = g;
        this.size = size;
        sc = new Scanner(System.in);
    }
    
    public void play(){
        createCharacter();
        while(play == true){
            g.setColor(Color.LIGHT_GRAY);
            g.fillOval(0,0,Window.width,Window.height);
            
            createEnemy();
            drawEnemy();
            drawCharacter();
            
        }
        
    }
    
    public void createEnemy(){
        int randX, randY;
        Boolean creation = true;
        
        while(enemies.size() < numberOfEnemies){
            int WindowWidth = ((Window.width-20)/10)-2;
            int WindowHeight = ((Window.height-20)/10)-2;
            
            randX = (int)(Math.random()*(WindowWidth))+3;
            randY = (int)(Math.random()*(WindowHeight))+3;
            
            randX = (randX*10);
            randY = (randY*10);
            
            for(int i = 0 ; i < body.size() ; i++){
                Ring ifExist = body.get(i);
                if(randX == ifExist.posX && randY == ifExist.posY){
                    creation = false;
                }
            }
            
            if(creation == true){
                enemies.add(new Enemy(randX, randY, Color.GREEN));
            }
        }
        
    }
    
    public void createCharacter(){
        for(int j = 0 ; j < this.size ; j++){
            int height; 
            height = ((int) Window.height/2)/10;
            height *= 10;
            if(j == 0){
                body.add(new Ring(Window.width/2+((j)*10),height,Color.RED));
            } else if(j > 0){
                body.add(new Ring(Window.width/2+((j)*10),height,Color.BLACK));
            }
        }
    }
    
    public void drawEnemy(){
        for(int x = 0 ; x < enemies.size() ; x++){
            Enemy e = enemies.get(x);
            g.setColor(e.color);
            g.fillOval(e.posX,e.posY,10,10);
        }
    }
    
    public void drawCharacter(){
        for(int i=0 ; i < body.size() ; i++){
            Ring r;
            r = body.get(i);
            g.setColor(r.color);
            g.fillOval(r.posX,r.posY,10,10);
        }
        
    }
    
    public void move(){
        int px, py;
        for(int i = body.size()-1 ; i > 0 ; i--){
            Ring r;
            r = body.get(i-1);
            px = r.posX;
            py = r.posY;
            r = body.get(i);
            r.posX = px;
            r.posY = py;
        }
        Ring r1 = body.get(0);
        if(direction == 1){
            r1.posY -= 10;
        }
        
        if(direction == 2){
            r1.posX += 10;
        }
        
        if(direction == 3){
            r1.posY += 10;
        }
        
        if(direction == 4){
            r1.posX -= 10;
        }
    }
}
