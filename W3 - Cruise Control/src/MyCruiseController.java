import au.edu.ecu.is.fuzzy.FuzzyException;
import au.edu.ecu.is.fuzzy.FuzzyRuleSet;
import au.edu.ecu.is.fuzzy.FuzzySet;
import au.edu.ecu.is.fuzzy.FuzzyVariable;
import au.edu.ecu.is.fuzzy.SugenoRuleSet;

public class MyCruiseController implements CruiseController {

	private SugenoRuleSet rules;
	private FuzzyVariable speedError;
	private FuzzyVariable acceleration;
	private FuzzyVariable forceChange;
	
	public MyCruiseController() throws FuzzyException 
	{ 
		// create fuzzy variable for speed error 
		// INSERT YOUR CODE HERE 
		// create fuzzy variable for acceleration 
		// INSERT YOUR CODE HERE 
		// create fuzzy variable for force change 
		// INSERT YOUR CODE HERE 
		// NOTE THAT THIS VARIABLE WILL NOT NEED ANY FUZZY SETS 
		// now construct a matrix of fuzzy sugeno-type rules 
		rules = new SugenoRuleSet(); 
		FuzzySet[] speedSets = 
			{ 
				//INSERT YOUR FUZZY SETS FOR SPEED 
			}; 
		FuzzySet[] accSets = 
			{ 
				//INSERT YOUR FUZZY SETS FOR ACCELERATION 
			}; 
		double[][] forceChanges = 
			{ 

			};

		// INSERT 2D ARRAY OF FORCE CHANGE VALUES  }; 
		rules.addRuleMatrix( 
				speedError, speedSets, 
				acceleration, accSets, 
				forceChange, forceChanges); 
	}

	public FuzzyRuleSet getRuleSet() {
		return rules;
	}

	public FuzzyVariable getSpeedError() {
		return speedError;
	}

	public FuzzyVariable getAcceleration() {
		return acceleration;
	}

	public FuzzyVariable getForceChange() {
		return forceChange;
	}

	public double computeForceChange(double speedError, double acceleration) {
		try {
			this.speedError.setValue(speedError);
			this.acceleration.setValue(acceleration);
			rules.update();
			return forceChange.getValue();
		} catch (Exception e) {
			e.printStackTrace(System.out);
			return 0.0;
		}
	}
}
