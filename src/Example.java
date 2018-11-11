import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Timer;
import java.lang.Exception;

public class Example
{
    Panel p=new Panel();
    Button b=new Button("clear" );
    int areaWidth=400;
    int areaHight=500;
    BufferedImage image=new BufferedImage(areaWidth,areaHight,BufferedImage.TYPE_INT_RGB);
    Graphics g=image.getGraphics();
    private Frame f=new Frame("画画版");
    private int prex=-1;
    private int prey=-1;
    private Mycanvas drawArea=new Mycanvas();
    class Mycanvas extends Canvas
    {
        public void paint(Graphics g)
        {
            g.drawImage(image,0,0,null);
        }
    }
    public void initial()
    {
        g.fillRect(0,0,areaWidth,areaHight);
        drawArea.setPreferredSize(new Dimension(300,400));
        drawArea.addMouseMotionListener(new MouseMotionAdapter()
        {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                if(prex>0 && prey>0)
                {
                    g.setColor(new Color(255,0,0));
                    g.drawLine(prex,prey,e.getX(),e.getY());
                }
                prex=e.getX();
                prey=e.getY();
                drawArea.repaint();
            }
        });
        drawArea.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseReleased(MouseEvent e)
            {
                prex=-1;
                prey=-1;
            }
        });
        b.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                g.setColor(new Color(255, 253, 253));
                g.fillRect(0,0,areaWidth,areaHight);
                drawArea.repaint();
            }
        });
        f.add(b,BorderLayout.NORTH);
        f.add(drawArea);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args)
    {
        new Example().initial();
        System.out.println("no");
    }
}