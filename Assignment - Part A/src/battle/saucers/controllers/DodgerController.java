package battle.saucers.controllers;

import battle.saucers.*;
import java.awt.Color;
import java.util.Random;

/**
 *
 * @author phingsto
 */
public class DodgerController implements SaucerController
{
    private double opponentDirection;
    private double opponentDistance;
    private int timeToTurn = (int)TURNFACTOR;
    
    private static final Random random = new Random();
    private static final String NAME = "dodger";
    private static final Color BASE = Color.darkGray;
    private static final Color ARROW = Color.black;
    private static final double TURNFACTOR = 0.01;
    private static final double MINTURN = 10.0;
    private static final double EXTRA = 20.0;
    private static final double CLOSE = 5*Saucer.RADIUS;

    public void sensorUpdate
        (
            double opponentDistance,
            double opponentDirection,
            double opponentEnergy,
            double energy
         )
    {
        this.opponentDistance = opponentDistance;
        this.opponentDirection = opponentDirection;
        timeToTurn--;
    }
    
    public double getFirePower()
    {
        return 0.0;
    }
    
    public double getSpeed()
    {
        if(opponentDistance < CLOSE)
        {
            return Saucer.MAX_SPEED;
        }
        else
        {
            return Saucer.MIN_SPEED + (Saucer.MAX_SPEED-Saucer.MIN_SPEED)*random.nextDouble();
        }
    }

    public double getTurn()
    {
        if(timeToTurn <= 0)
        {
            timeToTurn = (int)(Math.abs(random.nextGaussian())*TURNFACTOR*opponentDistance);

            double deviation;
            double extra = random.nextDouble()*2*EXTRA - EXTRA;
            if(EXTRA < 0)
            {
                 deviation = - MINTURN - extra; 
            }
            else
            {
                deviation = MINTURN + extra;
            }

            if(opponentDistance < CLOSE)
            {
                return 180.0 + opponentDirection + deviation;
            }
            else
            {
                return deviation;
            }
        }
        else
        {
            return 0.0;
        }
    }
    
    public String getName()
    {
        return NAME;
    }
    
    public Color getBaseColor()
    {
        return BASE;
    }
    
    public Color getTurretColor()
    {
        return ARROW;
    }    
}
