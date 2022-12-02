import java.awt.*;
import java.util.List;

/**
 * ConcreteDecorator for GraphDecorator Class. It draws points on the graph
 *
 */
public class MarkedPlot extends GraphDecorator {

    private static final int PREF_W = 500;
    private static final int PREF_H = 250;
    private static final Color GRAPH_POINT_COLOR = new Color(150, 50, 50, 180);
    private static final int GRAPH_POINT_WIDTH = 12;
    private List<Point> graphPoints;

    /**
     * Constructor for initializing Plotter variable
     *
     * @param plotter
     */
    public MarkedPlot(Plotter plotter) {
        super(plotter);
    }

    /**
     * Method to set graphPoints and call paintComponent
     *
     * @param g
     * @param graphPoints
     */
    @Override
    public void draw(Graphics g, List<Point> graphPoints) {
        super.draw(g, graphPoints);
        this.graphPoints=graphPoints;
        paintComponent(g);
    }

    /**
     * Method to draw marked points on top of line graph
     *
     * @param g the <code>Graphics</code> object to protect
     */
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(GRAPH_POINT_COLOR);
        for (int i = 0; i < graphPoints.size(); i++) {
            int x = graphPoints.get(i).x - GRAPH_POINT_WIDTH / 2;
            int y = graphPoints.get(i).y - GRAPH_POINT_WIDTH / 2;
            int ovalW = GRAPH_POINT_WIDTH;
            int ovalH = GRAPH_POINT_WIDTH;
            g2.fillOval(x, y, ovalW, ovalH);
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
