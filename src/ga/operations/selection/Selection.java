package ga.operations.selection;

import ga.population.Couple;
import ga.population.Population;
/**
* interface Selection to apply strategy pattern with behaviours EliteSelection, RandomSelection and TournamentSelection.
*/
public interface Selection<T> {
  /**
  * abstract method to be overridden by the implementing classes.
  * @param pp instance of Population class
  * @return instance of Couple class
  */
  public Couple<T> select(Population<T> pp);
  
}