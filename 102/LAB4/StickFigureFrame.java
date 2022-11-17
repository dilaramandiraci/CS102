import java.awt.*;
import java.awt.event.*;
import java.util.TimerTask;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 * This is the stickmanFrame class which creates butons, checkboxes and sets the positions of all these as well as the stickman figure
 * @author Dilara Mandıracı
 */

public class StickFigureFrame extends JFrame {
    private JButton moveLeftButton;
    private JButton moveRightButton;
    private JButton stopButton;
    private JButton colorButton;
    private JCheckBox mouth;
    private JCheckBox arms;
    private JCheckBox head;
    private JCheckBox legs;
    private JCheckBox eyes;
    private JComponent stickman;
    private JPanel buttonsPannel;
    private JPanel enablePannel;
    private Timer myTimerLeft;
    private Timer myTimerRight;
    private JSlider sizeSlider;

    /**
     * This is the constructor of SticmanFigureClass which takes a stickma inside 
     * @param astickman
     */
    public StickFigureFrame(StickFigureComponent astickman)
    {
      setBackground (Color.white);
      setPreferredSize (new Dimension(500, 500));

      ////////// To create Buttons Panel ad add them to the frame
      buttonsPannel = new JPanel();

      moveLeftButton = new JButton("Move Left");
      moveLeftButton.addActionListener (new LeftListener());
      buttonsPannel.add(moveLeftButton);

      moveRightButton = new JButton("Move Right");
      moveRightButton.addActionListener (new RightListener());
      buttonsPannel.add(moveRightButton);

      stopButton = new JButton("Stop");
      stopButton.addActionListener (new StopListener());
      buttonsPannel.add(stopButton);

      colorButton = new JButton("Change My Color");
      colorButton.addActionListener(new ColorListener());
      buttonsPannel.add(colorButton);
      setLayout(new BorderLayout());
      add(buttonsPannel, BorderLayout.SOUTH);
      //////////////////////////////////////////////////////

      ////////creates invisibility checkboxes
      JLabel text = new JLabel(" MAKE ME INVISIBLE");
      enablePannel = new JPanel();
      enablePannel.setLayout(new GridLayout(6,1));
      enablePannel.add(text);
      mouth = new JCheckBox("MOUTH");
      enablePannel.add(mouth);
      mouth.addActionListener(new VisibleListener());
      arms = new JCheckBox("ARMS");
      enablePannel.add(arms);
      arms.addActionListener(new VisibleListener());
      head = new JCheckBox("HEAD");
      enablePannel.add(head);
      head.addActionListener(new VisibleListener());
      legs= new JCheckBox("LEGS");
      enablePannel.add(legs);
      legs.addActionListener(new VisibleListener());
      eyes = new JCheckBox("EYES");
      enablePannel.add(eyes);
      eyes.addActionListener(new VisibleListener());
      add(enablePannel, BorderLayout.WEST);
      ////////////////////////////////////////////////////

      //adds stickman to the center of the frame
      stickman = astickman;
      add(stickman, BorderLayout.CENTER);
      stickman.setVisible(true);
      //////////////////////////////////////////////////////

      myTimerLeft  = new Timer(15, new LeftListener());
      myTimerRight = new Timer(15, new RightListener());
      /////////////////////////////////////////////////////

      ///adds jSlider to the east of the frame
      sizeSlider = new JSlider(JSlider.VERTICAL, 1, 50, ((StickFigureComponent) stickman).getSizeof());
      add(sizeSlider,BorderLayout.EAST);
      sizeSlider.addChangeListener(new sliderListener());
      
    }
    
    //this is the listener for moveLeftButton
    private class LeftListener implements ActionListener
   {
      public void actionPerformed (ActionEvent event)
      {
        
        myTimerRight.stop();
        if(((StickFigureComponent) stickman).getXposition()<0)
        {
          ((StickFigureComponent) stickman).setX(490);
          stickman.repaint();
        }
        else
        {
          myTimerLeft.start();
          ((StickFigureComponent) stickman).setX(((StickFigureComponent) stickman).getXposition()-3);
          stickman.repaint();
        }
      }
   }
   //This is the listener for moveRightBotton
   private class RightListener implements ActionListener
   {
      public void actionPerformed (ActionEvent event)
      {
        myTimerLeft.stop();
        
        
        if(((StickFigureComponent) stickman).getXposition()>490)
        {
          ((StickFigureComponent) stickman).setX(0);
          stickman.repaint();
        }
        else
        {
          myTimerRight.start();
          ((StickFigureComponent) stickman).setX(((StickFigureComponent) stickman).getXposition() +3);
          stickman.repaint();
        }
        
      }
   } 
   //This is the listener for stopButton
   private class StopListener implements ActionListener
   {
      public void actionPerformed (ActionEvent event)
      {
        myTimerLeft.stop();
        myTimerRight.stop();
      }
    }
    //This is the listener for colorButton
    private class ColorListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {  
          
        
        JColorChooser colorChooser = new JColorChooser();
        Color coloris = JColorChooser.showDialog(null, "pick a color for your stickman", Color.black);
        ((StickFigureComponent) stickman).setColor(coloris);
        stickman.repaint();
         
      }
    }  

    //This is the listener for heigth slider
    private class sliderListener implements ChangeListener
    {

      @Override
      public void stateChanged(ChangeEvent e) {
        // TODO Auto-generated method stub
        int value = sizeSlider.getValue();
        ((StickFigureComponent) stickman).setSizeof(value);
        stickman.repaint();
      }

    }

    //This is the listener for visibility checkboxes
    private class VisibleListener implements ActionListener
    {

      @Override
      public void actionPerformed(ActionEvent e) {
        if(e.getSource()==mouth)
        {
          if(mouth.isSelected())
          {
            ((StickFigureComponent) stickman).setMouth(false);
            stickman.repaint();
          }
          else
          {
            ((StickFigureComponent) stickman).setMouth(true);
            stickman.repaint();
          }
          
        }
        if(e.getSource() == head)
        {
          if(head.isSelected())
          {
            ((StickFigureComponent) stickman).setHead(false);
            stickman.repaint();
          }
          else
          {
            ((StickFigureComponent) stickman).setHead(true);
            stickman.repaint();
          }
        }
        if(e.getSource() == legs)
        {
          if(legs.isSelected())
          {
            ((StickFigureComponent) stickman).setLegs(false);
            stickman.repaint();
          }
          else
          {
            ((StickFigureComponent) stickman).setLegs(true);
            stickman.repaint();
          }
        }
        if(e.getSource() == arms)
        {
          if(arms.isSelected())
          {
            ((StickFigureComponent) stickman).setArms(false);
            stickman.repaint();
          }
          else
          {
            ((StickFigureComponent) stickman).setArms(true);
            stickman.repaint();
          }
        }
        if(e.getSource() == eyes)
        {
          if(eyes.isSelected())
          {
            ((StickFigureComponent) stickman).setEyes(false);
            stickman.repaint();
          }
          else
          {
            ((StickFigureComponent) stickman).setEyes(true);
            stickman.repaint();
          }
        }
        
      }
      
    }
}
   
   


    

