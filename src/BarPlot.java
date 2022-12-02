import java.awt.*;
import java.util.List;

/**
 * ConcreteDecorator for GraphDecorator Class. It draws Bars on the graph
 *
 */
public class BarPlot extends GraphDecorator {

    private static final int PREF_W = 500;
    private static final int PREF_H = 250;
    private static final Color BAR_COLOR = new Color(1, 1, 1, 50);
    private static final int GRAPH_POINT_WIDTH = 12;
    private List<Point> graphPoints;

    /**
     * Constructor for initializing Plotter variable
     *
     * @param plotter
     */
    public BarPlot(Plotter plotter) {
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
        this.graphPoints = graphPoints;
        paintComponent(g);
    }

    /**
     * Method to draw bars on top of marked graph
     *
     * @param g the <code>Graphics</code> object to protect
     */
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(BAR_COLOR);
        for (int i = 0; i < graphPoints.size(); i++) {
            int x = graphPoints.get(i).x - GRAPH_POINT_WIDTH / 2;
            int y = graphPoints.get(i).y - GRAPH_POINT_WIDTH / 2;
            int barW = GRAPH_POINT_WIDTH;
            int barH = GRAPH_POINT_WIDTH;
            g2.drawRect(x, y, barW, PREF_H-y);
            g2.fillRect(x, y, barW, PREF_H-y);
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