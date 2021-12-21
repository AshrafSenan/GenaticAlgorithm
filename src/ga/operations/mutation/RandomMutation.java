package ga.operations.mutation;

import java.util.Random;
import ga.population.Individual;
import java.util.ArrayList;
/**
* An implementation of strategy pattern on mutation with a behaviour RandomMutation.
*/
public class RandomMutation<T> implements Mutation<T>{
/**
* mutates individual elements
* @param individual indivual instance
* @param potentials list of accepting values inserted by user
*/
public void mutate(Individual<T> individual, ArrayList<T> potentials) {
  Random rnd = new Random();
  int geneIndex = rnd.nextInt(individual.size());
  T newVal = mutate(individual.getGeneValue(geneIndex), potentials);
  individual.setGeneValue(geneIndex, newVal);
}

/**
* @param crntValue current values
* @param potentials list of accepting values inserted by user
* @return new instance of individual
*/
public T mutate(T crntValue, ArrayList<T> potentials) {
    Random rnd = new Random();
    int randIndex = rnd.nextInt(potentials.size());
    T newValue = potentials.get(randIndex);
    while(newValue == crntValue) {
      randIndex = rnd.nextInt(potentials.size());
      newValue = potentials.get(randIndex);
    }    
    return newValue;
 }

}
