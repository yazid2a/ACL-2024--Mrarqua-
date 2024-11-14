package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import Main.GamePanel;
import Main.KeyHandler;
import Objects.OBJ_Heart;
import Monstre.monster;
public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    public OBJ_Heart lifeBar;
    int counter2 = 0;    
    
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        screenX = gp.screenWidth/2 - (gp.titleSize/2);
        screenY = gp.screenHeight/2 - (gp.titleSize/2);
        this.lifeBar = new OBJ_Heart(6);
        solidArea =new Rectangle();
        solidArea.x=8;
        solidArea.y=16;
        solidArea.width=32;
        solidArea.height=32;
        
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.titleSize*23;
        worldY = gp.titleSize*21;
        speed = 4;
        directions ="down"; 
    }

    public void getPlayerImage() {
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
        if (keyH.upPressed) {
            directions = "up";
     
        } else if (keyH.downPressed) {
            directions = "down";
         
        } else if (keyH.leftPressed) {
            directions = "left";
    
        } else if (keyH.rightPressed) {
            directions = "right";
        } else {
            directions = null; // Si aucune touche n'est pressée, la direction est null
        }

        // Check collision with monsters
        for (monster m : gp.monsters) {
            if (this.solidArea.intersects(m.solidArea) && m.isAlive()) {
                lifeBar.loseLife();
                m.setDead();  // Kill the monster
            }
        }
    
        
        //Verifie la collision 
   
          
        if (directions != null) {
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // Si la collision est fausse, le joueur peut se déplacer
            if (!collisionOn) {
                switch (directions) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }
        }
        

        // Animation du joueur
        spriteCounter++;
        if (spriteCounter > 10) {
            spritNum = (spritNum == 1) ? 2 : 1;
            spriteCounter = 0;
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        // Choix de l'image en fonction de la direction et de l'animation
        if (directions != null) {
            switch (directions) {
                case "up":
                    image = (spritNum == 1) ? up1 : up2;
                    break;
                case "down":
                    image = (spritNum == 1) ? down1 : down2;
                    break;
                case "left":
                    image = (spritNum == 1) ? left1 : left2;
                    break;
                case "right":
                    image = (spritNum == 1) ? right1 : right2;
                    break;
            }
        } else {
            // Image par défaut si aucune direction n'est définie
            image = down1;
        }

        g2.drawImage(image, screenX, screenY, gp.titleSize, gp.titleSize, null);
    }
}