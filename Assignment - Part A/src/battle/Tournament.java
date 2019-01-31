package battle;

import battle.saucers.Saucer;
import battle.saucers.controllers.*;
import battle.starfield.Starfield;

import java.util.ArrayList;

/**
 * Run a tournament without the GUI
 *
 * @author phi
 */
public class Tournament
{
    private static final double SECONDS = 0.05; // controls apparent speed
    
    private Starfield field;
    private ArrayList<Saucer> saucers;
    
    private static final int RUNS = 1000;
    
    public static void main(String[] args) throws Exception
    {
        new Tournament().versusSimple(RUNS);
//        new Tournament().run(RUNS);
    }
    
    private void run(int runs) throws Exception
    {
        saucers = new ArrayList<Saucer>();
        
        field = new Starfield(Constants.STARFIELD_WIDTH, Constants.STARFIELD_HEIGHT);
        
        // list the combatants here
        saucers.add(new Saucer(field, new SimpleController()));      
        saucers.add(new Saucer(field, new FuzzyController())); 
        //saucers.add(new Saucer(field, new CustomController())); 
        
        double[] scores = new double[saucers.size()];
        
        for(int i = 0; i < saucers.size(); i++)
        {
            for(int j = i+1; j < saucers.size(); j++)
            {
                for(int k = 0; k < runs; k++)
                {
                    field = new Starfield(Constants.STARFIELD_WIDTH, Constants.STARFIELD_HEIGHT);

                    Saucer saucer1 = saucers.get(i);
                    Saucer saucer2 = saucers.get(j);

                    saucer1.setOpponent(saucer2);
                    saucer2.setOpponent(saucer1);
                    field.addSaucer(saucer1);
                    field.addSaucer(saucer2);

                    System.out.println(saucer1.getControllerName() + " vs " + saucer2.getControllerName());
                    run();
                    for(Saucer saucer: field.getSaucers())
                    {
                        System.out.println(saucer.getControllerName()+"\t\t"+saucer.getEnergyString());
                    }
                    scores[i] += saucer1.getEnergy();
                    scores[j] += saucer2.getEnergy();
                }
            }
        }

        System.out.println();
        System.out.println("Averages:");
        for(int i = 0; i < saucers.size(); i++)
        {
            System.out.println(saucers.get(i).getControllerName() + "\t" + (scores[i]/(runs*(saucers.size()-1))));
        }
        System.out.println();
    }
    
    private void versusSimple(int runs) throws Exception
    {
        saucers = new ArrayList<Saucer>();
        
        field = new Starfield(Constants.STARFIELD_WIDTH, Constants.STARFIELD_HEIGHT);
        
        // list the combatants here
        
        // opponents
        saucers.add(new Saucer(field, new SimpleController()));  
        saucers.add(new Saucer(field, new BerzerkController()));  
        saucers.add(new Saucer(field, new DodgerController()));  
        
        // on time
        saucers.add(new Saucer(field, new FuzzyController())); 
//        saucers.add(new Saucer(field, new LAA_AttackController()));
//        saucers.add(new Saucer(field, new AggressiveController()));
//        saucers.add(new Saucer(field, new AmazingController()));
//        saucers.add(new Saucer(field, new AssignmentController()));
//        saucers.add(new Saucer(field, new AwesomeSauceSaucer()));
//        saucers.add(new Saucer(field, new CheckSixController()));
//        saucers.add(new Saucer(field, new FuzzyWobblerEnhanced()));
//        saucers.add(new Saucer(field, new JKDController()));
//        saucers.add(new Saucer(field, new JazzHandsController()));
//        saucers.add(new Saucer(field, new JordanWarrenController()));
//        saucers.add(new Saucer(field, new KLimController()));
//        saucers.add(new Saucer(field, new MaxsController()));
//        saucers.add(new Saucer(field, new NewController()));
//        saucers.add(new Saucer(field, new PacifistController()));
//        saucers.add(new Saucer(field, new PhaseController()));
//        saucers.add(new Saucer(field, new Piumal_Controller()));
//        saucers.add(new Saucer(field, new RobbinController()));
//        saucers.add(new Saucer(field, new ShirleyController()));
//        saucers.add(new Saucer(field, new SixthRefinedFuzzyController()));
//        saucers.add(new Saucer(field, new SlowPiController()));
//        saucers.add(new Saucer(field, new SmartyController()));
//        saucers.add(new Saucer(field, new TieFighter()));
//        saucers.add(new Saucer(field, new ChickenController()));
//        saucers.add(new Saucer(field, new FataniaController()));
        
        // late
//        saucers.add(new Saucer(field, new WaringController()));
//        saucers.add(new Saucer(field, new BossController()));
//        saucers.add(new Saucer(field, new AdvancedController()));
//        saucers.add(new Saucer(field, new Ezcontroller()));
//        saucers.add(new Saucer(field, new MangariyaController()));
//        saucers.add(new Saucer(field, new MathiyaController()));
//        saucers.add(new Saucer(field, new ThomasController()));
//          saucers.add(new Saucer(field, new GuerrillaWarfareController()));
//        saucers.add(new Saucer(field, new RodsFuzzyController()));
//        saucers.add(new Saucer(field, new StudentController()));
//        saucers.add(new Saucer(field, new YoloController()));
//        saucers.add(new Saucer(field, new CustomController())); 
        
        for(int t = 0; t < 3; t++)
        {
            Saucer saucer1 = saucers.get(t); //simple, berzerk, dodger

            System.out.println("\nScores versus " + saucer1.getControllerName());
            System.out.println("----------------------------------------------");
            
            for(int i = 3; i < saucers.size(); i++)
            {
                double score = 0;
                try
                {
                    for(int k = 0; k < runs; k++)
                    {
                        field = new Starfield(Constants.STARFIELD_WIDTH, Constants.STARFIELD_HEIGHT);

                        Saucer saucer2 = saucers.get(i);

                        saucer1.setOpponent(saucer2);
                        saucer2.setOpponent(saucer1);
                        field.addSaucer(saucer1);
                        field.addSaucer(saucer2);

                        run();

                        score += saucer2.getEnergy();
                    }

                    System.out.println(saucers.get(i).getControllerName() + "\t" + score/runs);
                }
                catch (Exception e)
                {
                    System.out.println(saucers.get(i).getControllerName() + "\tdisqualified");
                }        
            }
        }
    }
    
    public void run() throws Exception
    {
        while(field.getSaucerManager().numberAlive() > 1)
        {
            field.update(SECONDS);
        }
    }
    
}
