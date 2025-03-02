import java.awt.*;
import java.awt.geom.*;

/**
 * Class BoxBall - a graphical ball that bounces off the walls like Pong.
 * 
 * @author Alessandro Marucci
 *
 * @version 2025.03.02
 */

public class BoxBall
{
    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;      // y position of ground
    private final int ceilingPosition;     // y position of ceiling
    private final int wallLeftPosition;    // x position of left wall
    private final int wallRightPosition;   // x position of right wall
    private Canvas canvas;
    private int ySpeed = 1;                // initial downward speed

    /**
     * Constructor for objects of class BoxBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the ball will bounce)
     * @param ceilingPos  the position of the ceiling
     * @param wallLeftPos  the position of the left wall
     * @param wallRightPos  the position of the right wall
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                        int groundPos, int ceilingPos, int wallLeftPos,
                        int wallRightPos, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        ceilingPosition = ceilingPos;
        wallLeftPosition = wallLeftPos;
        wallRightPosition = wallRightPos;
        canvas = drawingCanvas;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
