package ga.operations.mutation;

import java.util.ArrayList;
import ga.population.Individual;
/**
* Create an interface Mutation to apply strategy pattern with behaviour RandomMutation.
* Although, currently, mutation package contains only one behaviour with our design solution the project is well-organized for future code changes/extensions.
*/
public interface Mutation<T> {
  /**
  * Mutation on Individual level
  * @param individual invidual instance
  * @param potentials list of accepting values inserted by the user
  */
  public void  mutate(Individual<T> individual, ArrayList<T> potentials);
  
  /**
  * Mutation on Gene Level
  * @param crntValue current values
  * @param potentials list of accepting values inserted by the user
  */
  public T mutate(T crntValue, ArrayList<T> potentials) ;
  
}