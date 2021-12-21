package ga.operationfactories;

import ga.GABehaviour;
import ga.operations.crossover.CrossOver;
import ga.operations.selection.Selection;
import ga.operations.replacement.Replacement;
import ga.operations.mutation.Mutation;

/**
* abstract factory the creates the GABehaviour class
*/
public class BehaviourGenerator<T> {
  OperationsFactory<T> factory;

  /**
  * a consturctor to instantiate object
  * @param aFactory instance of OperationsFactory
  */
  public BehaviourGenerator(OperationsFactory<T> aFactory) {
        this.factory = aFactory;
  }
  /**
  * set factory object
  * @param aFactory instance of OperationsFactory
  */
  public void setFactory(OperationsFactory<T> aFactory) {
        this.factory = aFactory;
  }
 
 /**
 * sets selection, mutation, crossover and replacement behaviours for the current genetic algorithm
 * @return instance of GABehaviour
 */
 public GABehaviour<T> getBehaviour() {
   GABehaviour<T> gab = new GABehaviour<T>(getSelection(), getMutation(), getCrossOver(), getReplacement());
   return gab;
 }
 
 /**
 * Returns the instance of crossover class that is being used in the runtime
 * @return instance of CrossOver
 */
 public CrossOver<T> getCrossOver() {
    return factory.getCrossOver();
  }

  /**
 * Returns the instance of Mutation class that is being used in the runtime
 * @return instance of Mutation
 */
  public Mutation<T> getMutation() {
    return factory.getMutation();
  }

  /**
 * Returns the instance of Selection class that is being used in the runtime
 * @return instance of Selection
 */
  public Selection<T> getSelection() {
    return factory.getSelection();
  } 

  /**
 * Returns the instance of Replacement class that is being used in the runtime
 * @return instance of Replacement
 */
  public Replacement<T> getReplacement() {
    return factory.getReplacement();
  }
  
}