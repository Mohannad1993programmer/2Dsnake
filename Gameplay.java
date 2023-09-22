/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2dsnake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author ubunto
 */
public class Gameplay extends JPanel implements KeyListener, ActionListener {
    
    private int[] snakexlenght=new int[750];
    private int[] snakeylenght=new int[750];
    
    private boolean left=false;
    private boolean right=false;
    private boolean up=false;
    private boolean down=false;
    
    private ImageIcon rightmouth;
    private ImageIcon upmouth;
    private ImageIcon downmouth;
    private ImageIcon leftmouth;
    
    private int lenghtofsnake=3;
    
    private int[]enemyxpos={25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
    private int []enemyypos={75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625};
    private int score=0,moves=0;
    
    private Timer timer;
    private int delay=100;
    private Random random=new Random();
    
    private int xpos=random.nextInt(34);
    private int ypos=random.nextInt(23);
    
    
    private ImageIcon snakeImage;
    private ImageIcon titleImage;
    private ImageIcon enemyImage;
    
    
    
    public Gameplay() 
    {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer=new Timer(delay,this);
        timer.start();
        
        
    }
    
    public void paint(Graphics g)
    {
        
        if(moves==0)
        {
            
            snakexlenght[2]=50;
            snakexlenght[1]=75;
            snakexlenght[0]=100;
            
            snakeylenght[2]=100;
            snakeylenght[1]=100;
            snakeylenght[0]=100;
        }
        //draw title image color
        g.setColor(Color.white);
        g.drawRect(24,10,851,55);
        
        //draw title image
        titleImage=new ImageIcon(getClass().getResource("/images/snaketitle.jpg"));
        titleImage.paintIcon(this, g, 25, 11);
        
        //draw border for Gameplay
          g.setColor(Color.WHITE);
        g.drawRect(24,74,851,577);
        
        //draw background for Gameplay
        g.setColor(Color.black);
        g.fillRect(24, 75, 850, 575);
        
        //draw score
        g.setColor(Color.white);
        g.setFont(new Font("ariel",Font.PLAIN,14));
        g.drawString("Score: "+score, 780, 30);
        
        g.setColor(Color.white);
        g.setFont(new Font("ariel",Font.PLAIN,14));
        g.drawString("Lenght: "+lenghtofsnake, 780, 50);
        
        
        
        rightmouth=new ImageIcon(getClass().getResource("/images/rightmouth.png"));
        rightmouth.paintIcon(this, g, snakexlenght[0], snakeylenght[0]);
      
      
        
        
        
        for(int a=0;a<lenghtofsnake;a++)
        {
            if(a==0 && right)
            {
               rightmouth=new ImageIcon(getClass().getResource("/images/rightmouth.png"));
               rightmouth.paintIcon(this, g, snakexlenght[a], snakeylenght[a]);
            }
            if(a==0 && left)
            {
               leftmouth=new ImageIcon(getClass().getResource("/images/leftmouth.png"));
               leftmouth.paintIcon(this, g, snakexlenght[a], snakeylenght[a]);
            }
            if(a==0 && down)
            {
             downmouth=new ImageIcon(getClass().getResource("/images/downmouth.png"));
             downmouth.paintIcon(this, g, snakexlenght[a], snakeylenght[a]);
            }
            if(a==0 && up)
            {
             upmouth=new ImageIcon(getClass().getResource("/images/upmouth.png"));
             upmouth.paintIcon(this, g, snakexlenght[a], snakeylenght[a]);
            }
            
            if(a!=0)
            {
                 snakeImage=new ImageIcon(getClass().getResource("/images/snakeimage.png"));
             snakeImage.paintIcon(this, g, snakexlenght[a], snakeylenght[a]);
            
            }
            
            
           
        }
        
        enemyImage=new ImageIcon(getClass().getResource("/images/enemy.png"));
        if((enemyxpos[xpos]==snakexlenght[0]) && (enemyypos[ypos]==snakeylenght[0]))
        {
            score++;
            lenghtofsnake++;
            xpos=random.nextInt(34);
            ypos=random.nextInt(23);
        }
        
        enemyImage.paintIcon(this, g, enemyxpos[xpos], enemyypos[ypos]);
        
        for(int b=1;b<lenghtofsnake;b++)
        {
            if((snakexlenght[b]==snakexlenght[0]) && (snakeylenght[b]==snakeylenght[0]))
            {
                right=left=up=down=false;
                g.setColor(Color.red);
                g.setFont(new Font("arial",Font.BOLD,50));
                g.drawString("Game Over", 300, 300);
                
                 g.setFont(new Font("arial",Font.BOLD,20));
                g.drawString("Space to Restart", 350, 340);
                        
            }
        }
                
        g.dispose();
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode()==KeyEvent.VK_SPACE)
        {
            score=moves=0;
            lenghtofsnake=3;
            repaint();
                    
        }
       
    if(e.getKeyCode()==KeyEvent.VK_RIGHT)
    {
       moves++;
     
        right=true;
        if(!left)
            right=true;
        else
        {
            right=false;
            left=true;
        }
         up=down=false;
    }
     if(e.getKeyCode()==KeyEvent.VK_LEFT)
    {
       moves++;
   
        left=true;
        if(!right)
            left=true;
        else
        {
            right=true;
            left=false;
        }
         up=down=false;
    }
      if(e.getKeyCode()==KeyEvent.VK_UP)
    {
        moves++;
        up=true;
        if(!down)
            up=true;
        else
        {
            down=true;
            up=false;
        }
         left=right=false;
    }
        if(e.getKeyCode()==KeyEvent.VK_DOWN)
    {
        moves++;
        down=true;
        if(!up)
            down=true;
        else
        {
            down=false;
            up=true;
        }
         left=right=false;
    }
    }

    @Override
    public void keyReleased(KeyEvent e) {
   }

   
   public void actionPerformed(ActionEvent e) {
   timer.start();
    if(right)
        
    {
        for(int r=lenghtofsnake-1;r>=0;r--)
            snakeylenght[r+1]=snakeylenght[r];
        for(int r=lenghtofsnake;r>=0;r--)
        {
            if(r==0)
                snakexlenght[r]=snakexlenght[r]+25;
            else
                snakexlenght[r]=snakexlenght[r-1];
            if(snakexlenght[r]>850)
                snakexlenght[r]=25;      
        }
        repaint();
    }
    if(left)
    {
          for(int r=lenghtofsnake-1;r>=0;r--)
            snakeylenght[r+1]=snakeylenght[r];
        for(int r=lenghtofsnake;r>=0;r--)
        {
            if(r==0)
                snakexlenght[r]=snakexlenght[r]-25;
            else
                snakexlenght[r]=snakexlenght[r-1];
            if(snakexlenght[r]<25)
                snakexlenght[r]=850;      
        }
        repaint();
        
    }
    if(up)
    {
          for(int r=lenghtofsnake-1;r>=0;r--)
            snakexlenght[r+1]=snakexlenght[r];
        for(int r=lenghtofsnake;r>=0;r--)
        {
            if(r==0)
                snakeylenght[r]=snakeylenght[r]-25;
            else
                snakeylenght[r]=snakeylenght[r-1];
            if(snakeylenght[r]<75)
                snakeylenght[r]=625;      
        }
        repaint();
        
    }
    if(down)
    {
          for(int r=lenghtofsnake-1;r>=0;r--)
            snakexlenght[r+1]=snakexlenght[r];
        for(int r=lenghtofsnake;r>=0;r--)
        {
            if(r==0)
                snakeylenght[r]=snakeylenght[r]+25;
            else
                snakeylenght[r]=snakeylenght[r-1];
            if(snakeylenght[r]>625)
                snakeylenght[r]=75;      
        }
        repaint();
        
    }
   }

   
    
}
