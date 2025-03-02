import java.awt.Color;

/** Lab 5 - Box Ball Animation Demo
 * A short demonstration showing animation with the 
 * Canvas class, where a ball bounces off walls inside 
 * of a box.
 *
 * @author Alessandro Marucci
 * @version 2025.03.03
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);

        // create and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
    
    /**
     * Creates a rectangular box with one or more balls in it.
     */
    public void boxBounce()
    {
       int ground = 400;   // position of the ground line
       int wallLeft = 50; // position of the left wall
       int wallRight = 550; // position of the right wall
       int ceiling = 100;  // position of the ceiling
       
       myCanvas.setVisible(true);
       
       // draw the ground
       myCanvas.setForegroundColor(Color.BLACK);
       myCanvas.drawLine(50, ground, 550, ground);
       
       // draw the ceiling
       myCanvas.setForegroundColor(Color.BLACK);
       myCanvas.drawLine(50, ceiling, 550, ceiling);
       
       // draw the left wall
       myCanvas.setForegroundColor(Color.BLACK);
       myCanvas.drawLine(wallLeft, 100, wallLeft, 400);
       
       // draw the right wall
       myCanvas.setForegroundColor(Color.BLACK);
       myCanvas.drawLine(wallRight, 100, wallRight, 400);

       // create and show the balls
       BoxBall ball = new BoxBall(50, 50, 16, Color.BLUE, ground, myCanvas);
       ball.draw();
       //BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
       //ball2.draw();
    }
}
