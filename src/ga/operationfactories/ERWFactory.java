package ga.operationfactories;

import ga.operations.mutation.Mutation;
import ga.operations.mutation.RandomMutation;
import ga.operations.replacement.WorstReplacement;
import ga.operations.replacement.Replacement;
import ga.operations.selection.ElitSelection;
import ga.operations.selection.Selection;
import ga.operations.crossover.CrossOver;
import ga.operations.crossover.RandomCrossOver;
/**
* Factory Class to create and return behaviour with Elite selection, Random crossOver, WorstReplacement and Random Mutation
*/
public class ERWFactory<T> extends OperationsFactory<T> {
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
    return new ElitSelection<T>();
  }
  /**
  * Returns an instance of Replacement that is being executed in the runtime
  * @return instance of Generic WorstReplacement
  */
  public Replacement<T> getReplacement() {
    return new WorstReplacement<T>();
  }
  /**
  * Returns an instance of CrossOver that is being executed in the runtime
  * @return instance of Generic RandomCrossOver
  */
  public CrossOver<T> getCrossOver() {
    return new RandomCrossOver<T>();
  }

}