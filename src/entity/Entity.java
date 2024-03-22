/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author rakib
 */
public class Entity { // this stores variables that will be used in player, monster and NPC classes
    
    public int worldX, worldY;
    public int speed;
    
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2; // it describes an Image with an accesible buffer if image data.(we use this to store our image files)
    public String direction;
    
    public int spriteCounter = 0;
    public int spriteNum = 1;
    
    public Rectangle solidArea;
    public boolean collisionOn = false;
}

