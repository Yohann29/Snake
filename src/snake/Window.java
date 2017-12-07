package snake;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window extends JFrame implements KeyListener {
    JPanel container = new JPanel();
    
    public static int width = 400;
    public static int height = 400;
    
    public Window(){
        setTitle("Jeu Snake 0.1 2017 (Alpha)");
        setSize(width, height);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        container.setBackground(Color.WHITE);
        
        // On définit l'évènement sur la fenêtre (appui touche)
        addKeyListener(this);
        
        // On ajoute le panel à la fenêtre courante
        setContentPane(container);
        
        // On affiche la fenêtre
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
