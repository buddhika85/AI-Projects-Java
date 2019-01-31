import au.edu.ecu.is.fuzzy.*;

/**
 * Interface for a criuse controller
 *
 * @author (phi)
 * @version (2006/2)
 */
public interface CruiseController
{
    public FuzzyRuleSet getRuleSet();
    
    public FuzzyVariable getSpeedError();
    
    public FuzzyVariable getAcceleration();
    
    public FuzzyVariable getForceChange();
    
    public double computeForceChange(double speedError, double acceleration);
}