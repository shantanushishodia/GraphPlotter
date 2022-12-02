import java.awt.*;
import java.util.List;

/**
 * Component interface for Decorator Pattern
 */
public interface Plotter {
   /**
    * Method signature for drawing graphs
    *
    * @param g
    * @param graphPoints
    */
   void draw(Graphics g, List<Point> graphPoints);
}
