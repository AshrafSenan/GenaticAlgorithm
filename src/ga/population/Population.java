package ga.population;

import java.util.ArrayList;
import ga.fitness.*;

/**
* Population class to represent a set of individuals with whom the process of genetic algorithm begins. It is an arraylist of inviduals.
* 
*/

public class Population<T> {
  /**
  * list of individuals to hold population of individuals
  */
  ArrayList<Individual<T>> individuals;
  Individual<T> Target;

/**
* a constructor for Population class
* @param populationSize size of the population
* @param genesLength the length of genesLength
* @param target target individuals
* @param potentialGenes list of accepting values for genes inputted from client
* @param ftnsCalc an instance of FitnessCalculator interface
*/
public Population(int populationSize, int genesLength, Individual<T> target, ArrayList<T> potentialGenes, FitnessCalculator ftnsCalc) {
 individuals = new ArrayList<>();
 for(int i=0; i<populationSize; i++) {
   Individual<T> newMember = new Individual<T>(genesLength, potentialGenes);
   newMember.calculateFitness(ftnsCalc, target);
   individuals.add(newMember);
  }
}

/**
* Returns the best two from the whole population
* @return couple of best match to the target
*/
public Couple<T> getTheBestTwo() {
  return getTheBestTwo(0, individuals.size());
}

/**
* Returns the best two from the specified indexes
* @param middle middle index
* @param end end index
* @return couple of best match to the target
*/
public Couple<T> getTheBestTwo(int middle, int end) {
  Individual<T> i1, i2;
  i1 = individuals.get(middle);
  i2 = individuals.get(middle + 1);
  if(i1.compareTo(i2) < 0) {
    i1 = individuals.get(middle + 1);
    i2 = individuals.get(middle);
  }
  for(int i=middle; i<end; i++) {
    if(i1.compareTo(individuals.get(i)) < 0) {
        i2 = i1;
        i1 = individuals.get(i);
    }
    else if(i2.compareTo(individuals.get(i)) < 0)
        i2 = individuals.get(i);
  }
  Couple<T> bestTwo = new Couple<T>(i1,i2);
 
  return bestTwo;
  }

/**
* Returns the worst match index
* @return index of the worst match Individual
*/
public int getWorstIndex() {
  int worstIndex = 0;
  Individual<T> worst = individuals.get(0);
  for(int i=1; i<individuals.size(); i++)
    if(worst.compareTo(individuals.get(i)) > 0) {
      worst = individuals.get(i);
      worstIndex = i;
    }
    return worstIndex;
  }

/**
* replace an individual at specified index with the given individuals
* @param index index of element to be replaceIndividual
* @param newMember individual element to replace
*/
public void replaceIndividual(int index, Individual<T> newMember) {
    individuals.set(index, newMember);
}

public Individual<T> getBest() {
  return getTheBestTwo().getBest();
}

/**
* Add new invidual instance to the population
* @param newMember an instance to be added
*/
public void addIndividual(Individual<T> newMember) {
  individuals.add(newMember);
}

public Individual<T> getIndividual(int index) {
  return individuals.get(index);
}

public ArrayList<Individual<T>> getAll() {
  return this.individuals;
}

/**
* @return the size of population
*/
public int size() {
  return individuals.size();
}

public String toString() {
  String str ="";
  for(Individual<T> i: individuals)
    str += i.toString();

  return str;
}

}
