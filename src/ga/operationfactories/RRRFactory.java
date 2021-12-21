package ga.operationfactories;
import ga.operations.mutation.Mutation;
import ga.operations.mutation.RandomMutation;
import ga.operations.replacement.AddReplacement;
import ga.operations.replacement.Replacement;
import ga.operations.selection.RandomSelection;
import ga.operations.selection.Selection;
import ga.operations.crossover.CrossOver;
import ga.operations.crossover.RandomCrossOver;
/**
* Factory Class to create and return behaviour with Random selection, Random crossOver, Random Replacement and Random Mutation
*/
public class RRRFactory<T> extends OperationsFactory<T> {
  /**
  * Returns Mutation behaviour
  * @return instance of Mutation
  */ 
  public Mutation<T> getMutation() {    
    return new RandomMutation<T>();
  }
  /**
  * Returns Selection behaviour
  * @return instance of Selection
  */ 
  public Selection<T> getSelection() {
    return new RandomSelection<T>();
  }
  /**
  * Returns Replacement behaviour
  * @return instance of Replacement
  */ 
  public Replacement<T> getReplacement() {
    return new AddReplacement<T>();
  }
  /**
  * Returns CrossOver behaviour
  * @return instance of CrossOver
  */ 
  public CrossOver<T> getCrossOver() {
    return new RandomCrossOver<T>();
  }

}