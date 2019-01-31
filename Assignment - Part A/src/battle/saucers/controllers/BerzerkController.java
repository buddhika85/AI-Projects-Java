package battle.saucers.controllers;

import battle.saucers.*;
import java.awt.Color;
import java.util.Random;

/**
 *
 * @author phingsto
 */
public class BerzerkController implements SaucerController
{    
    private double opponentDirection;
    private double opponentDistance;
    
    private static final Random random = new Random();
    private static final String NAME = "berzerk";
    private static final Color BASE = Color.orange;
    private static final Color ARROW = Color.yellow;
    private static final double CLOSE = 3*Saucer.RADIUS;
    private static final double DEAD = 2.5*Saucer.RADIUS;
    private static final double FIRE_POWER = Saucer.MAX_POWER;

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
    }
    
    public double getFirePower()
    {
        if(opponentDistance <= CLOSE + DEAD)
        {
            return FIRE_POWER;
        }
        else
        {
            return 0.0;
        }
    }
    
    public double getTurn()
    {
        if(opponentDistance > CLOSE + DEAD)
        {
            return opponentDirection;
        }
        else
        if(opponentDistance < CLOSE - DEAD)
        {
            return 180.0 - opponentDirection;
        }
        else
        {
            return 0.0;
        }
    }
    
    public double getSpeed()
    {
        return Saucer.MAX_SPEED;
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