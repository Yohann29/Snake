package snake;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window extends JFrame implements KeyListener {

    // On crée le panel
    JPanel container = new JPanel();

    public static int width = 400;
    public static int height = 400;

    Character arbok;

    JLabel gameOver = new JLabel();

    public Window() {
        setTitle("Jeu Snake 0.1 2017 (Alpha)");
        setSize(width, height);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        container.setBackground(Color.WHITE);

        gameOver.setBounds((width / 2) - 40, 0, 100, 20);

        // On définit l'évènement sur la fenêtre (appui touche)
        addKeyListener(this);

        // On ajoute le panel à la fenêtre courante
        setContentPane(container);

        // On affiche la fenêtre
        setVisible(true);

        // On crée le serpent
        arbok = new Character(this.getGraphics(), 4);
    }

    public void startGame() {
        arbok.play();
        gameOver();
    }

    public void gameOver() {
        gameOver.setText("Perdu !");
        container.add(gameOver);
        container.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP && arbok.direction != 3) {
            arbok.direction = 1;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && arbok.direction != 4) {
            arbok.direction = 2;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN && arbok.direction != 1) {
            arbok.direction = 3;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT && arbok.direction != 2) {
            arbok.direction = 4;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
