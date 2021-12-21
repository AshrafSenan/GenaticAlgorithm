package ga.operations.replacement;

import ga.population.Individual;
import ga.population.Population;
/**
* Add new individual to the population
*/
public class AddReplacement<T> implements  Replacement<T> {
  /**
  * adds new individual to the population
  * @param pp population
  * @param newIndividual individual to be added to the population
  */
  public void replace(Population<T> pp, Individual<T> newIndividual) {    
      pp.addIndividual( newIndividual);   
  }
  
} 