import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * ConcreteComponent Class for the Plotter to plot plain
 * line graph for the points generated
 *
 */
public class SimplePlot  extends JPanel implements Plotter {

    private static final int PREF_W = 500;
    private static final int PREF_H = 250;
    private static final Color GRAPH_COLOR = Color.blue;
    private static final Stroke GRAPH_STROKE = new BasicStroke(3f);
    private List<Point> graphPoints;

    /**
     * Constructor for initializing graphPoints
     *
     * @param graphPoints
     */
    public SimplePlot(List<Point> graphPoints) {
        this.graphPoints = graphPoints;
    }

    /**
     * Implementation for draw()
     *
     * @param g
     * @param graphPoints
     */
    @Override
    public void draw(Graphics g, List<Point> graphPoints) {
        this.graphPoints=graphPoints;
        paintComponent(g);
    }

    /**
     * Method to draw line graph
     *
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.clearRect(0, 0, 500, 250);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(GRAPH_COLOR);
        g2.setStroke(GRAPH_STROKE);
        for (int i = 0; i < graphPoints.size() - 1; i++) {
            int x1 = graphPoints.get(i).x;
            int y1 = graphPoints.get(i).y;
            int x2 = graphPoints.get(i + 1).x;
            int y2 = graphPoints.get(i + 1).y;
            g2.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * Method to get preferred dimension
     *
     * @return Dimension
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }
    }

