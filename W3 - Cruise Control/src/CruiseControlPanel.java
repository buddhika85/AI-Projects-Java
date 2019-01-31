import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 * A panel to display the car travelling under cruise control.
 *
 * @author (phi)
 * @version (2006/2)
 */
public class CruiseControlPanel extends JPanel implements CruiseListener
{
    public CruiseControlPanel(CruiseControlSetup setup)
    {
        setPreferredSize(new Dimension(400, 200));
        
        this.setup = setup;
        
        setup.addListener(this);
    }
    
    public void update()
    {
        repaint();
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        setup.draw(g, new Rectangle2D.Double(0.0, getHeight(), getWidth(), getHeight()));
    }
    
    public void display()
    {
        JFrame viewer = new JFrame("Cruise Control");
        viewer.getContentPane().add(new JScrollPane(this));
        viewer.pack();
        viewer.setVisible(true);
    }
    
    private CruiseControlSetup setup;
}
