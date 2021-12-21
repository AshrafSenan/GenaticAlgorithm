package ga.fitness;

import java.util.ArrayList;
import ga.population.Gene;
/**
* Implementation of fitness calculator interface. This class is implemented using thread-safe singleton pattern.
*/
public class MatchFitnessCalculator implements FitnessCalculator{
  
  private static MatchFitnessCalculator _instance;

  private MatchFitnessCalculator() {}
  /**
  * double-checked locking principle implemented method for getting only one instance
  * @return instance of MatchFitnessCalculator
  */
  public static MatchFitnessCalculator getInstance() {
     if(_instance == null) {
        synchronized(MatchFitnessCalculator.class){
          if(_instance == null)
            _instance = new MatchFitnessCalculator();
        }
  }
  return _instance;
  }
 
 /**
 * calculates fitness of A and B
 * @param genesA genes of A
 * @param genesB genes of B
 */
 public <T> double calculateFitness(ArrayList<Gene<T>> genesA, ArrayList<Gene<T>> genesB) {
     double totalMatch = 0;
     for(int i=0; i<genesA.size(); i++) {
        if(genesA.get(i).equals(genesB.get(i)))
         totalMatch++;         
     }
     return (double)(totalMatch/(double)genesA.size());
 }
}
