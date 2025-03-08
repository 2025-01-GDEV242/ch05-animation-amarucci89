import java.awt.Color;
import java.util.Random;
import java.util.Iterator;
import java.util.HashSet;
import java.awt.Dimension;
import java.awt.*;

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
        myCanvas.setVisible(true);
    }

    /**
     * Simulates bouncing balls
     */
    public void bounce(int numberOfBalls)
    {
        int ground = 400;   // position of the ground line
        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);

        // create and show the balls
        Random random = new Random();
        HashSet<BouncingBall> balls = new HashSet<>();
        for(int i=0; i<numberOfBalls; i++)
        {
            Dimension size = myCanvas.getSize();
            int x = random.nextInt((int) size.getWidth());
            int y = random.nextInt((int) size.getHeight() / 2);
            BouncingBall ball = new BouncingBall(x, y, 16, Color.blue, ground, myCanvas);
            balls.add(ball);
            ball.draw();
        }

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            Iterator<BouncingBall> it = balls.iterator();
            finished = true;
            while(it.hasNext())
            {
                BouncingBall ball = it.next();
                ball.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() < 550) {
                finished = false;
            }
        }
    }
    Iterator<BouncingBall> it = balls.iterator();
    while(it.hasNext())
    {
        BouncingBall ball = it.next();
        ball.erase();
    }
}
    
    /**
     * Simulates balls bouncing in a box.
     */
    public void boxBounce(int numberOfBalls)
    {
       myCanvas.setVisible(true);
       
       // draw the box
       Rectangle box = new Rectangle(50,50,300,300);
       myCanvas.draw(box);

       // create and show the balls
        Random random = new Random();
        HashSet<BoxBall> balls = new HashSet<>();
        for(int i=0; i<numberOfBalls; i++) {
            Dimension size = myCanvas.getSize();
            int x = (int) box.getX() + random.nextInt((int) box.getWidth() - 16);            
            int y = (int) box.getY() + random.nextInt((int) box.getHeight() - 16);
            int xSpeed = random.nextInt(30);
            int ySpeed = random.nextInt(30);
            Color color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
            BoxBall ball = new BoxBall(x, y, xSpeed, ySpeed, 16, color, box, myCanvas);
            balls.add(ball);
            ball.draw();
        }
        // make them bounce        
        boolean finished = false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            Iterator<BoxBall> it = balls.iterator();
            
            finished = true;
            while(it.hasNext()) {
                BoxBall ball = it.next();
                ball.move();
                // stop only once all balls has stopped moving
                if(ball.isMoving()) {
                    finished = false;
                }
            }
        }
        Iterator<BoxBall> it = balls.iterator();
        while(it.hasNext()) {
            BoxBall ball = it.next();
            ball.erase();
        }
    }
}
