import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * It gets data from Source every time new numbers are generated.
 * It initiates the graph plotting process.
 *
 */
public class PlotPanel implements Observer{

    JPanel p1,p2,p3,panel;
    List<Point> scores = new ArrayList<Point>();
    PlotPanel plotPanel;

    /**
     * Default Constructor
     */
    public PlotPanel(){}

    /**
     * Constructor for initializing class variables
     *
     * @param panel
     * @param p1
     * @param p2
     * @param p3
     */
    public PlotPanel(JPanel panel, JPanel p1, JPanel p2, JPanel p3){
        this.p1=p1;
        this.p2=p2;
        this.p3=p3;
        this.panel=panel;
    }

    /**
     * It initiates the graph plotting process by using
     * SimplePlot, MarkedPlot and BarPlot classes.
     *
     * @param scores coordinates for plotting graph
     */
    public void createAndShowGUI(List<Point> scores) {
        Plotter simplePlot = new SimplePlot(scores);
        simplePlot.draw(plotPanel.p3.getGraphics(),scores);

        Plotter markedPlot = new MarkedPlot(new SimplePlot(scores));
        markedPlot.draw(plotPanel.p2.getGraphics(), scores);

        Plotter barPlot = new BarPlot(new MarkedPlot(new SimplePlot(scores)));
        barPlot.draw(plotPanel.p1.getGraphics(), scores);
    }

    /**
     * Observer function for getting the data every time notified
     *
     * @param o     the observable object.
     * @param arg   an argument passed to the <code>notifyObservers</code>
     *                 method.
     */
    @Override
    public void update(Observable o, Object arg) {
        Data data=((Source)o).getData();
        plotPanel= new PlotPanel(data.getPanel(), data.getP1(), data.getP2(), data.getP3());
        createAndShowGUI(data.getGraphPoints());
    }
}
