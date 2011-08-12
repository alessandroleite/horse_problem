import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.awt.*;

/**
 * Chess table
 * 
 * @author Alessandro
 * @version 0.1
 */
public class Chess extends World
{                 
    private static final int ENV_SIZE = 8;  // environment size in numer of cells
    private static final int CELL_SIZE = 60; // cell size in pixels
    private static final Color [] CELL_COLORS = {Color.BLACK, Color.WHITE};
                 
    /**
     * Constructor for objects of class Chess.
     * 
     */
    public Chess()
    {    
        
         super(ENV_SIZE, ENV_SIZE, CELL_SIZE, true);
         addObject(new Horse(), 4, 0);  
         drawBackground();
    }
    
    
    private void drawBackground()
    {
        GreenfootImage bg = getBackground();
        bg.setColor(CELL_COLORS[1]);
        bg.fill();
        bg.setColor(CELL_COLORS[0]);
        for(int i = 0; i < ENV_SIZE; i++) {            
            bg.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, ENV_SIZE * CELL_SIZE);
            bg.drawLine(0, i * CELL_SIZE, ENV_SIZE * CELL_SIZE, i * CELL_SIZE);                       
        }       
   }
}
