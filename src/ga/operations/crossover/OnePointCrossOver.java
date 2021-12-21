package ga.operations.crossover;

import ga.population.Couple;
import ga.population.Gene;
import ga.population.Individual;
import java.util.Random;
import java.util.ArrayList;

/**
* An implementation of strategy pattern on crossover with a behaviour OnePointCrossOver.
*/
public class OnePointCrossOver<T> implements CrossOver<T>{

  /**
  * makes reproduction based on one point cross over
  * @param cpl Couple
  * @return reproduced individual instance
  */
  public Individual<T> doCrossOver(Couple<T> cpl) {
  Random rnd= new Random();
  Individual<T> i1 = cpl.getFirst(),  i2 = cpl.getSecond();
  int size = i1.getGenes().size();
  int midPoint =  size/ 2;
  midPoint = (midPoint/2) + rnd.nextInt(midPoint);
  ArrayList<Gene<T>> genes = new ArrayList<>();
  int i =0;
  while(i<midPoint) {
    genes.add(new Gene<T>(i1.getGenes().get(i).getValue()));
    i++;
  }

  while(i<size) {
    genes.add(new Gene<T>(i2.getGenes().get(i).getValue()));
    i++;
  }
  
  Individual<T> newIndividual = new Individual<>();
  newIndividual.setGenes(genes);

  return newIndividual;
  }

}