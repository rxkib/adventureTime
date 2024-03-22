/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import adventuretime.GamePanel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author rakib
 */
public class SuperObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    
    public void draw(Graphics2D g2, GamePanel gp){
        int screenX = worldX - gp.player.worldX + gp.player.screenX; // offsetting the difference
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
            
            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
               worldX - gp.tileSize< gp.player.worldX + gp.player.screenX &&
               worldY + gp.tileSize> gp.player.worldY - gp.player.screenY && 
               worldY - gp.tileSize< gp.player.worldY + gp.player.screenY){ 
               
                g2.drawImage(image, screenX,screenY,gp.tileSize, gp.tileSize, null);
            }
    }
    
}
