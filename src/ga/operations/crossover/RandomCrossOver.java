package ga.operations.crossover;

import ga.population.Individual;
import ga.population.Couple;
import ga.population.Gene;
import java.util.ArrayList;
import java.util.Random;

/**
* An implementation of strategy pattern on crossover with a behaviour XorCrossOver.
*/
public class RandomCrossOver<T> implements CrossOver<T> {
  /**
  * makes reproduction based on one point cross over
  * @param cpl Couple
  * @return reproduced individual
  */
  public Individual<T> doCrossOver(Couple<T> cpl) {
    Random rnd= new Random();
    Individual<T> i1 = cpl.getFirst(),  i2 = cpl.getSecond();
    ArrayList<ArrayList<Gene<T>>> genesList = new ArrayList<>();
    genesList.add(i1.getGenes());
    genesList.add(i2.getGenes());
    int size = i1.getGenes().size();
    ArrayList<Gene<T>> genes = new ArrayList<>();
    int i =0;   

    while(i<size) {
      int randomIndex = rnd.nextInt(2);

      T geneValue = genesList.get(randomIndex).get(i).getValue();
      genes.add(new Gene<T>(geneValue));
      i++;
    }
    
    Individual<T> newIndividual = new Individual<>();
    newIndividual.setGenes(genes);

    return newIndividual;
  }
}