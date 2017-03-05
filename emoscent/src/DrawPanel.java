
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.BorderLayout; 
public class DrawPanel extends JPanel
{
	
//	int[][] x = EmoscentRunner.points;
//	int[][] y = EmoscentRunner.points;
	
	
    public DrawPanel()                       // set up graphics window
    {
        super();
        setBackground(Color.WHITE);
       
    }

    public void paintComponent(Graphics g)  // draw graphics in the panel
    {
        int width = getWidth();             // width of window in pixels
        int height = getHeight();           // height of window in pixels

        super.paintComponent(g);
        
        g.setFont(new Font("HELVETICA",Font.BOLD, 30));// call superclass to make panel display correctly
        g.drawString("emoscent demo", 5, 30);
        g.setFont(new Font("HELVETICA",Font.PLAIN, 12));
        g.drawString("Version: 1.0.0", 6, 44);
        g.drawString("By: John Guibas, Peter Li, and Tejpal Virdi", 6, 56);
        g.drawString("Febreze Hacks 2017", 6, 70);
       
        // Drawing code goes here
      
    }

    

}