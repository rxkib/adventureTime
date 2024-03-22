/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adventuretime.GamePanel;
import adventuretime.KeyHandler;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.BreakIterator;
import javax.imageio.ImageIO;

/**
 *
 * @author rakib
 */
public class Player extends Entity{ // use PiSKEL to create the character
    
    GamePanel gp;
    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;
    
    public Player(GamePanel gp, KeyHandler keyH){ // understand this better
        this.gp = gp;
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2 - (gp.tileSize/2); // understand this better
        screenY = gp.screenHeight/2 - (gp.tileSize/2);
        
        solidArea = new Rectangle(8,16,32,32);
        
        
        setDefaultValues();
        getPlayerImage();
    }
    
    public void setDefaultValues(){
        worldX = gp.tileSize * 23; // we are positioning the player here, starting position
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage(){
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
public void update() {
    if(keyH.upPressed == true || keyH.downPressed == true || 
            keyH.rightPressed == true || keyH.leftPressed == true){  
        if (keyH.upPressed) {
           direction = "up";
           
    }   else if (keyH.downPressed) {
           direction = "down";
           
    }   else if (keyH.leftPressed) {
           direction = "left";
           
    }   else if (keyH.rightPressed) {
          direction = "right";
          
    }
        //check tile collision
        collisionOn = false;
        gp.cChecker.checkTile(this);
        
        // if collision is false, player can move
        if(collisionOn == false){          
            switch (direction) {
            case "up": worldY -= speed; break;
            case "down": worldY += speed; break;
            case "left": worldX -= speed; break;
            case "right": worldX += speed; break;
            }
        }

    spriteCounter++;
    if (spriteCounter > 12) {
        if (spriteNum == 1) {
            spriteNum = 2;
        } else if (spriteNum == 2) {
            spriteNum = 1;
        }
        spriteCounter = 0;
    }
  }
}

    public void draw(Graphics2D g2){
        BufferedImage image = null;
        
        switch (direction) {
            case "up" -> {
                if (spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;
                }
                 break;
            }
            case "down" -> {
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down2;
                }
                break;
            }
            case "left" -> {
                if(spriteNum == 1){
                    image = left1; 
                }
                if(spriteNum == 2){
                    image = left2;
                }
                break;
            }
            case "right" -> {
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }
                break;
            }
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null); //draws an image on the screen //null is an image observer
        
    }
}
