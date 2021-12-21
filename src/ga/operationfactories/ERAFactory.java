package ga.operationfactories;

import ga.operations.mutation.Mutation;
import ga.operations.mutation.RandomMutation;
import ga.operations.replacement.AddReplacement;
import ga.operations.replacement.Replacement;
import ga.operations.selection.ElitSelection;
import ga.operations.selection.Selection;
import ga.operations.crossover.CrossOver;
import ga.operations.crossover.RandomCrossOver;
/**
* Factory class to create and return behaviour with Elite selection, Random crossOver, addReplacement and Random Mutation
*/
public class ERAFactory<T> extends OperationsFactory<T> {
  /**
  * Returns an instance of Mutation that is being executed in the runtime
  * @return instance of Generic RandomMutation
  */
  public Mutation<T> getMutation() {    
    return new RandomMutation<T>();
  }

  /**
   * Returns an instance of Selection that is being executed in the runtime
  * @return instance of Generic ElitSelection
  */
  public Selection<T> getSelection() {
    return new ElitSelection<>();
  }

  /**
  * Returns an instance of Replacement that is being executed in the runtime
  * @return instance of Generic AddReplacement
  */
  public Replacement<T> getReplacement() {
    return new AddReplacement<T>();
  }

  /**
  ** Returns an instance of CrossOver that is being executed in the runtime
  * @return instance of Generic RandomCrossOver
  */
  public CrossOver<T> getCrossOver() {
    return new RandomCrossOver<T>();
  }

}