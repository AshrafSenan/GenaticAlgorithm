package ga.operations.replacement;

import ga.population.Individual;
import ga.population.Population;
import java.util.Random;;
/**
* Implements Replacement interface to provide behaviour to randomly replace an individual
*/
public class RandomReplacement<T> implements  Replacement<T> {
  /**
  * @param pp population
  * @param newIndividual individual to replace random individual of population
  */
  public void replace(Population<T> pp, Individual<T> newIndividual) {
    Random rnd = new Random();
    int index = rnd.nextInt(pp.size()-1);
    pp.replaceIndividual(index, newIndividual);  
  }
  
}