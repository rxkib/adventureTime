/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adventuretime;

import javax.swing.JFrame;

/**
 *
 * @author rakib
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame window = new JFrame();
        GamePanel gamePanel = new GamePanel();
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Adventure Time");
        

        window.add(gamePanel);
        
        window.pack(); // casues the window to be sized to fit the preferred size of its subcomponent
        
        
        window.setLocationRelativeTo(null); // stays at the center
        window.setVisible(true); // so that we can see the window
        
        gamePanel.setupGame();
        gamePanel.startGameThread(); //this was missing
        
    }
    
}
