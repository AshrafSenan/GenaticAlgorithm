package ga.operationfactories;

import ga.operations.mutation.Mutation;
import ga.operations.mutation.RandomMutation;
import ga.operations.replacement.WorstReplacement;
import ga.operations.replacement.Replacement;
import ga.operations.selection.TournamentSelection;
import ga.operations.selection.Selection;
import ga.operations.crossover.CrossOver;
import ga.operations.crossover.RandomCrossOver;
/**
* Factory class to create and return behaviour with TournamentSelection, Random crossOver, Random Replacement and Random Mutation
*/
public class TCWFactory<T> extends OperationsFactory<T> {
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
    return new TournamentSelection<T>();
  }
  /**
  * Returns Replacement behaviour
  * @return instance of Replacement
  */ 
  public Replacement<T> getReplacement() {
    return new WorstReplacement<T>();
  }
  /**
  * Returns CrossOver behaviour
  * @return instance of CrossOver
  */ 
  public CrossOver<T> getCrossOver() {
    return new RandomCrossOver<T>();
  }

}