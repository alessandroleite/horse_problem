import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * A chess horse 
 * 
 * @author Alessandro
 * @version 0.1
 */
public class Horse extends Actor
{
    private boolean[][] visited_positions = new boolean[8][8];
    
    private int[][] valid_moviments =   
    {
            {1, 2},{2, 1},{1, -2},{2, -1}, 
            {-1,2},{-2,1},{-1,-2},{-2,-1}
    };
    
    public Horse()
    {
        setLocation(0, 1);
        this.visited_positions[0][1] = true;
    }

    /**
     * Realiza os movimentos validos do cavalo no xadrez.
     */
    public void act() 
    {
        Integer[][] moviments = this.valid_moviments();
        
        if (moviments.length == 0)
          Greenfoot.stop();
        
        for (int i = 0; i < moviments.length; i++) 
        {
            int x = this.getX();
            int y = this.getY();            
            visited_positions[x][y] = true;
            if (this.getWorld().getObjectsAt(moviments[i][0], moviments[i][1], null).isEmpty())
            {
                setLocation(moviments[i][0], moviments[i][1]);                        
                this.getWorld().addObject(new Bomb(), x, y);            
                Greenfoot.delay(1);
                act();
            }            
        }
    }    
    
    /**
     * Obtém todos os movimentos válidos. 
     */
    public Integer[][] valid_moviments()
    {
        List<Integer[]> mov = new ArrayList<Integer[]>();
        
        for(int i = 0; i < 8; i++)
        {
            int x = this.getX() + valid_moviments[i][0];
            int y = this.getY() + valid_moviments[i][1];
            
            if (x > 0 && y > 0 && x < 8 && y < 8 && !visited_positions[x][y])
            {
               mov.add(new Integer[]{x, y});
            }
        }
        
        return mov.toArray(new Integer[mov.size()][2]);
    }
}
