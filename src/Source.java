import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * It generates and stores new data for plotting the graphs
 * and also notifies PlotPanel whenever the data
 * is generated
 *
 */
public class Source extends Observable {

    private static final int MAX_SCORE = 20;
    private static final int BORDER_GAP = 30;
    private static final int PREF_W = 500;
    private static final int PREF_H = 250;
    private LinkedList<Observer> observers=new LinkedList<Observer>();
    private List<Point> graphPoints = new ArrayList<Point>();
    private JPanel panel;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;

    /**
     * Method to return data to PlotPanel for plotting Graphs
     *
     * @return data
     */
    public Data getData(){
        Data data = new Data(graphPoints, panel, p1, p2, p3);
        return data;
    }

    /**
     * Method to set data for the class variables every time
     * button 'Run' is clicked. It notifies the observers
     * at the same time.
     *
     * @param points
     * @param panel
     * @param p1
     * @param p2
     * @param p3
     */
    public void setData(List<Point> points, JPanel panel, JPanel p1, JPanel p2, JPanel p3){
        this.graphPoints=points;
        this.p1=p1;
        this.p2=p2;
        this.p3=p3;
        this.panel=panel;
        notifyObservers();
    }

    /**
     * Method to add observers
     *
     * @param o   an observer to be added.
     */
    public void addObserver(Observer o) {
        observers.add(o);
    }

    /**
     * Method to notify the observers whenever new data is generated
     *
     */
    public void notifyObservers(){
        for(Observer ob:observers)
            ob.update(this, null);
    }

    /**
     * Generates new numbers and converts them to coordinates
     * for plotting the graph
     *
     * @return points
     */
    public List<Point> GeneratePoints () {
        List<Integer> numbers = new ArrayList<>();
        int maxPoints = 20;
        RandomNumberGen r = null;
        for(int i=0;i<maxPoints;i++){
            numbers.add(r.getInstance().newNumber());
        }

        double xScale = ((double) PREF_W - 2 * BORDER_GAP) / (numbers.size()-1 );
        double yScale = ((double) PREF_H - 2 * BORDER_GAP) / (MAX_SCORE -1);

        List<Point> points = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            int x1 = (int) (i * xScale + BORDER_GAP);
            int y1 = (int) ((MAX_SCORE - numbers.get(i)) * yScale + BORDER_GAP);
            points.add(new Point(x1, y1));
        }
        return points;
    }
}
