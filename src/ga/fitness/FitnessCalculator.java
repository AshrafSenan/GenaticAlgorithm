package ga.fitness;

import java.util.ArrayList;
import ga.population.Gene;

/**
* Interface to encapsulate Fitness Calculation.
*/ 
public interface FitnessCalculator {
  /**
  * @param genesA genes of A
  * @param genesB genes of B
  */
 public <T> double calculateFitness(ArrayList<Gene<T>> genesA, ArrayList<Gene<T>> genesB);
}
