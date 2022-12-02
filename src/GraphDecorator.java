import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Decorator for Component Plotter for Decorator Pattern
 *
 */
public abstract class GraphDecorator extends JPanel implements Plotter {
    protected Plotter plotter;
    public List<Point> graphPoints;

    /**
     * Initializes the Plotter
     *
     * @param plotter
     */
    public GraphDecorator(Plotter plotter){
        this.plotter =  plotter;
    }

    /**
     * Implements the draw() from Plotter
     *
     * @param g
     * @param graphPoints
     */
    public void draw(Graphics g, List<Point> graphPoints) {
        this.graphPoints=graphPoints;
        plotter.draw(g,graphPoints);
    }
}
