
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.*;

/**
 * This is the sticfigureComponentClass for draw the stickman figure
 * @author Dilara Mandıracı
 */
public class StickFigureComponent extends JComponent {
    private int baseX;
    private int baseY;
    private Color color;
    private int size=1;
    private boolean arms;
    private boolean head;
    private boolean legs;
    private boolean eyes;
    private boolean mouth;

    public StickFigureComponent(int basex, int basey, Color aColor, int aSize)
    {
        this.baseX = basex;
        this.baseY = basey;
        this.color = aColor;
        this.size = aSize;
        setBackground(Color.white);
        head=true;
        arms=true;
        legs=true;
        eyes=true;
        mouth=true;
    }

    public void setX(int x)
    {
        this.baseX = x;
    }
    public void setY(int y)
    {
        this.baseY = y;
    }
    public int getXposition()
    {
        return this.baseX;
    }
    public void setSizeof(int x)
    {
        size=x;
    }
    public int getSizeof()
    {
        return size;
    }
    public void setColor(Color x)
    {
        this.color = x;
    }
    public void setEyes(boolean enable)
    {
        eyes=enable;
    }
    public void setArms(boolean enable)
    {
        arms=enable;
    }
    public void setHead(boolean enable)
    {
        head=enable;
    }
    public void setMouth(boolean enable)
    {
        mouth=enable;
    }
    public void setLegs(boolean enable)
    {
        legs=enable;
    }

/**
 * This is the paintcompnent method for drawing the stickman figure
 */
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);

        page.setColor(this.color);
        
        if(head)
        {
            page.drawOval(baseX-20, baseY-10, 40, 40);//head
            page.drawArc(baseX+3, baseY+18, 2, 3, 180, 180);//nose
        }
        if(eyes)
        {
            page.fillOval(baseX-8, baseY+10, 8, 8);//eyes
            page.fillOval(baseX+8, baseY+10, 8, 8);//eyes
        }
        if(arms)
        {
            page.drawLine(baseX, baseY+30, baseX, (baseY+100)+size);//body
            page.drawLine(baseX, baseY+30, baseX+40, baseY+90);//arm
            page.drawLine(baseX, baseY+30, baseX-40, baseY +90);//arm
        }
        if(mouth)
        {
            page.drawArc(baseX, baseY+22, 8, 3, 180, 180);//mouth
        }
       if(legs)
       {
            page.drawLine(baseX, baseY+100+size, baseX+30, baseY+175+size);//leg
            page.drawLine(baseX, baseY+100+size, baseX-30, baseY+175+size);//leg
       }
        
        
    }   
}
