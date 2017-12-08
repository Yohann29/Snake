package snake;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class Character extends JPanel {

    public int size;
    Graphics g;
    public boolean play = true;
    public int numberOfEnemies = 5;
    Scanner sc;
    ArrayList<Ring> body = new ArrayList<Ring>();
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    public int direction = 4;

    public Character(Graphics g, int size) {
        this.g = g;
        this.size = size;
        sc = new Scanner(System.in);
    }

    public void play() {
        createCharacter();
        while (play == true) {

            g.setColor(Color.DARK_GRAY);
            g.fillRect(0, 0, Window.width, Window.height);

            createEnemy();
            drawEnemy();
            drawCharacter();

            sleep();

            move();
            checkCollision();

        }

    }

    public void sleep() {
        try {
            if (body.size() > 0 && body.size() < 5) {
                Thread.sleep(200);
            } else if (body.size() >= 5 && body.size() < 15) {
                Thread.sleep(150);
            } else if (body.size() >= 15 && body.size() < 50) {
                Thread.sleep(120);
            } else if (body.size() >= 50 && body.size() < 100) {
                Thread.sleep(100);
            } else {
                Thread.sleep(80);
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void createEnemy() {
        int randX, randY;
        Boolean creation = true;

        while (enemies.size() < numberOfEnemies) {
            int WindowWidth = ((Window.width - 20) / 10) - 2;
            int WindowHeight = ((Window.height - 20) / 10) - 2;

            randX = (int) (Math.random() * (WindowWidth)) + 3;
            randY = (int) (Math.random() * (WindowHeight)) + 3;

            randX = (randX * 10);
            randY = (randY * 10);

            for (int i = 0; i < body.size(); i++) {
                Ring ifExist = body.get(i);
                if (randX == ifExist.posX && randY == ifExist.posY) {
                    creation = false;
                }
            }

            if (creation == true) {
                enemies.add(new Enemy(randX, randY, Color.GREEN));
            }
        }

    }

    public void createCharacter() {
        for (int j = 0; j < this.size; j++) {
            int height;
            height = ((int) Window.height / 2) / 10;
            height *= 10;
            if (j == 0) {
                body.add(new Ring(Window.width / 2 + ((j) * 10), height, Color.RED));
            } else if (j > 0) {
                body.add(new Ring(Window.width / 2 + ((j) * 10), height, Color.WHITE));
            }
        }
    }

    public void drawEnemy() {
        for (int x = 0; x < enemies.size(); x++) {
            Enemy e = enemies.get(x);
            g.setColor(e.color);
            g.fillRect(e.posX, e.posY, 10, 10);
        }
    }

    public void showScore() {
        g.setFont(new Font("Calibri", Font.PLAIN, 15));
        g.drawString(("Score : " + Integer.toString(body.size())), 10, Window.height - 10);
    }

    public void drawCharacter() {
        for (int i = 0; i < body.size(); i++) {
            Ring r;
            r = body.get(i);
            g.setColor(r.color);
            g.fillRect(r.posX, r.posY, 10, 10);
            showScore();
        }
    }

    public void checkCollision() {
        for (int i = 0; i < enemies.size(); i++) {
            Enemy checkEnemy = enemies.get(i);
            Ring checkCharacter = body.get(0);
            Ring lastPosition = body.get(body.size() - 1);

            if (checkEnemy.posX == checkCharacter.posX && checkEnemy.posY == checkCharacter.posY) {
                enemies.remove(i);
                body.add(new Ring(200 + ((lastPosition.posX) + 10), 0, Color.WHITE));
            }
        }

        for (int i = 1; i < body.size(); i++) {
            Ring characterBody = body.get(i);
            Ring characterHead = body.get(0);

            if (characterHead.posX == characterBody.posX && characterHead.posY == characterBody.posY) {
                play = false;
            }
        }

        Ring characterHead = body.get(0);
        if (characterHead.posX < 10) {
            play = false;
        }
        if (characterHead.posX > (Window.width - 20)) {
            play = false;
        }
        if (characterHead.posY < 30) {
            play = false;
        }
        if (characterHead.posX > (Window.height - 20)) {
            play = false;
        }
    }

    public void move() {
        int px, py;
        for (int i = body.size() - 1; i > 0; i--) {
            Ring r;
            r = body.get(i - 1);
            px = r.posX;
            py = r.posY;
            r = body.get(i);
            r.posX = px;
            r.posY = py;
        }
        Ring r1 = body.get(0);
        if (direction == 1) {
            r1.posY -= 10;
        }

        if (direction == 2) {
            r1.posX += 10;
        }

        if (direction == 3) {
            r1.posY += 10;
        }

        if (direction == 4) {
            r1.posX -= 10;
        }
    }
}
