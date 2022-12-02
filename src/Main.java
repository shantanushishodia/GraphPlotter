import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * It generates the random points when ever run is clicked,
 * then plots the generated points in three different graphs on a GUI.
 *
 * @author shantanushishodia
 */
public class Main extends JFrame {

    static JPanel p1,p2,p3,panel;
    static JFrame frame;
    static JButton button;

    /**
     *It creates a JFrame for the graphs to be plotted in.
     *Creates a Source and a PlotPanel object and add PlotPanel
     * as an observer for Source. Creates a button 'Run' with ActionListener
     * which invokes setData() in Source. It also initializes the required JPanels
     *using setPanel()
     *
     * @param args
     */

    public static void main(String[] args) {


        frame= new JFrame("Assignemnt 3");
        frame.setSize(500,750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel=new JPanel();
        panel.setLayout(new GridLayout(4,1));

        Source s = new Source();
        PlotPanel plotPanel = new PlotPanel();

        s.addObserver(plotPanel);

        button = new JButton("Run");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.setData(s.GeneratePoints(),panel, p1, p2, p3);
            }
        });

        p1=setPanel(panel);
        p2=setPanel(panel);
        p3=setPanel(panel);
        panel.add(button);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     *It initializes the given panel to desired size
     * and adds it to the parent panel
     *
     * @param panel
     *
     * @return p panel object
     */
    public static JPanel setPanel(JPanel panel){
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(500,250));
        panel.add(p);
        return p;
    }

}