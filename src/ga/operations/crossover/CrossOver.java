package ga.operations.crossover;
import ga.population.Individual;
import ga.population.Couple;
/**
* Create an interface CrossOver to apply strategy pattern with behaviours OnePointCrossOver and XorCrossOver.
*/
public interface CrossOver<T>{
  /**
  * abstract method to be overridden by the implementing classes.
  * @param cpl instance of Couple class
  * @return instance of invidual
  */
  public Individual<T> doCrossOver(Couple<T> cpl);
}