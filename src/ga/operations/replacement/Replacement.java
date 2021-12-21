package ga.operations.replacement;

import ga.population.Population;
import ga.population.Individual;
/**
* Replacement interface to implement strategy pattern on replacing individuals in the population.
*/ 
public interface Replacement<T> {
  /**
  * abstract method to be overridden by the implementing classes.
  * @param pp instance of Population class
  * @param newIndividual new individual to replace
  */
  public void replace(Population<T> pp, Individual<T> newIndividual);
}