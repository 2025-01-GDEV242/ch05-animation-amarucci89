import java.awt.*;
import java.awt.geom.*;

/**
 * Class BoxBallNotes - A graphical ball that rebounds from the four walls
 * of its containing box. The ball has the ability to move.
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Alessandro Marucci
 *
 * @version 2025.03.03
 */

public class BoxBallNotes
{
    //private static final int GRAVITY = 3;  // effect of gravity

    //private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    //private final int groundPosition;      // y position of ground
    private Canvas canvas;
    private int ySpeed;                  //Set by contructor
    private int xSpeed;                  //Set by contructor

    /**
     * Constructor for objects of class BoxBallNotes
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param ceilingPos  the position of the ceiling (where the wall will bounce)
     * @param wallLeftPos  the position of the left wall (where the wall will bounce)
     * @param wallRightPos  the position of the right wall (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBallNotes(int xPos, int yPos, int ballDiameter, Color ballColor,
                        int groundPos, int ceilingPos, int wallLetPos, 
                        int wallRightPos, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        canvas = drawingCanvas;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     * This is where the ball needs to check for bouncing.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        //ySpeed += GRAVITY;
        //yPosition += ySpeed;
        //xPosition +=2;
        
        //Here is where you update the position based on xSpeed and ySpeed.

        // check if it has hit the ground
        if (yPosition >= (groundPosition - diameter) && ySpeed > 0) {
            yPosition = (int)(groundPosition - diameter);
            ySpeed = -ySpeed + ballDegradation; 
        }

        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
