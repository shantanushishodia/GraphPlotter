import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Class for storing and returning data
 */
public class Data {
    private List<Point> graphPoints;
    private JPanel panel;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;

    /**
     * Constructor for setting class variables
     *
     * @param graphPoints
     * @param panel
     * @param p1
     * @param p2
     * @param p3
     */
    public Data(List<Point> graphPoints, JPanel panel, JPanel p1, JPanel p2, JPanel p3){
        this.graphPoints=graphPoints;
        this.p1=p1;
        this.p2=p2;
        this.p3=p3;
        this.panel=panel;
    }

    /**
     * getter for coordiantes
     *
     * @return graphPoints
     */
    public List<Point> getGraphPoints() {
        return graphPoints;
    }

    /**
     * getter for parent panel
     *
     * @return panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * getter for first panel
     *
     * @return p1
     */
    public JPanel getP1() {
        return p1;
    }

    /**
     * getter for second panel
     *
     * @return p2
     */
    public JPanel getP2() {
        return p2;
    }

    /**
     * getter for third panel
     *
     * @return p3
     */
    public JPanel getP3() {
        return p3;
    }

}
