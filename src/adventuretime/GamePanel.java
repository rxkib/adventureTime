/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adventuretime;

import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import object.SuperObject;
import tile.TileManager;

/**
 *
 * @author rakib
 */
public class GamePanel extends JPanel implements Runnable{   // subclass of the jpanel, has all the subclass of the jpanel // runnable to implement threads
    
    //Works as game screen, so we need screen settings
    final int originalTileSize = 16; // 16 * 16 tile
    final int scale = 3;
    
    public final int tileSize = originalTileSize * scale; // 48*48 
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize* maxScreenRow;
    
    // world settings
    
   public final int maxWorldCol = 50;
   public final int maxWorldRow = 50;
   public final int worldWidth = tileSize * maxWorldCol;
   public final int worldHeight = tileSize * maxWorldRow;
   
    
    // FPS
    int FPS = 60;
    
    TileManager tileM = new TileManager(this);
    
    KeyHandler keyH = new KeyHandler();
    Thread gameThread; //keeps ur game running
    
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetManager aSetter = new AssetManager(this);
    
    public Player player = new Player(this, keyH);
    
    public SuperObject obj[] = new SuperObject[10];
    
    
    public GamePanel(){
        
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // sets the size of this class(JPanel)
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); //all the drawing from this component will be done in an offscreen painting buffer
        // improves the game's rendering performance
        this.addKeyListener(keyH);
        this.setFocusable(true); // makes gamepanel focused to receive key input

    }
    
    public void setupGame(){
        aSetter.setObject();
    }
    
    public void startGameThread(){
        gameThread = new Thread(this); //instantiating
        gameThread.start();
    }
    
    @Override
    public void run() { //understand this better
        
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){
            
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / drawInterval;
            
            lastTime = currentTime;
            
            if(delta >=1 ){
                update();
                repaint();     
                delta --;
            }
            
            //gotta understand this more thoroughly and just get the hands in idea for the code
        }
    }
    
    public void update(){
        player.update();
    }



    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        tileM.draw(g2); // we first draw the tile and then the player so its important to maintain the sequence
        
        for(int i = 0; i < obj.length; i++){
          if(obj[i] != null){
              obj[i].draw(g2, this);
          }  
        }
        
        player.draw(g2);
        g2.dispose(); //dispose of the gaphics context and release any system resources that it is using
    }
    
}
