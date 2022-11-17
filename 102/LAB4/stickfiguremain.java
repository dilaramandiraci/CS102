import java.awt.Color;
import javax.swing.JFrame;

/**
 * This is the main for visualize the stickman and frame
 * @author Dilara Mandıracı
 */
public class stickfiguremain {
    public static void main (String[] args)
    {
       StickFigureComponent component = new StickFigureComponent(100, 120, Color.black, 1);
       StickFigureFrame frameinner = new StickFigureFrame(component);
       frameinner.setTitle("MY SWEETIE STICK MAN :)");
       frameinner.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
       
       frameinner.pack();
       frameinner.setVisible(true);
    }
    
}
