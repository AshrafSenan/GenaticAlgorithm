package ga.operationfactories;

import ga.operations.crossover.CrossOver;
import ga.operations.mutation.Mutation;
import ga.operations.replacement.Replacement;
import ga.operations.selection.Selection;
/**
* Abstraction of all concrete factories. It abstract the creation of related behaviours including selection, mutation, crossover and replacement
*/
public abstract class OperationsFactory<T> {
  /**
  * Returns CrossOver behaviour
  * @return instance of CrossOver
  */ 
  abstract CrossOver<T> getCrossOver();
  /**
  * Returns Mutation behaviour
  * @return instance of Mutation
  */ 
  abstract Mutation<T> getMutation();
  /**
  * Returns Selection behaviour
  * @return instance of Selection
  */ 
  abstract Selection<T> getSelection();
  /**
  * Returns Replacement behaviour
  * @return instance of Replacement
  */ 
  abstract Replacement<T> getReplacement();
}