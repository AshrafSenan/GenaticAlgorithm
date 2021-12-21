package ga.operations.replacement;

import ga.population.Individual;
import ga.population.Population;
import ga.population.Individual;
/**
* Implements WorstReplacement interface to provide behaviour to replace worst individual with the given individual
*/
public class WorstReplacement<T> implements  Replacement<T> {
  /**
  * replace worst match with the given individual
  * @param pp population
  * @param newIndividual individual to replace worst individual of the population
  */
  public void replace(Population<T> pp, Individual<T> newIndividual) {
    int worst = pp.getWorstIndex();

    if(pp.getIndividual(worst).compareTo(newIndividual) < 0) {
      pp.replaceIndividual(worst, newIndividual);
    }

  }
  
}