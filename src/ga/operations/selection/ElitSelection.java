package ga.operations.selection;
import ga.population.Population;
import ga.population.Couple;
/**
* An implementation of strategy pattern on selection with a behaviour EliteSelection
*/
public class ElitSelection<T> implements Selection<T> {
  /**
  * @param pp population
  * @return the best matching couple of the population
  */
  public Couple<T> select(Population<T> pp) {
    return pp.getTheBestTwo();
  }

}