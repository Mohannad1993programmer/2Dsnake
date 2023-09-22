/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2dsnake;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author ubunto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      JFrame obj=new JFrame();
      Gameplay gameplay=new Gameplay();
      obj.setBounds(10, 10, 905, 700);
      obj.setBackground(Color.DARK_GRAY);
      obj.setVisible(true);
      obj.setResizable(false);
      obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      obj.add(gameplay);
    }
    
}
