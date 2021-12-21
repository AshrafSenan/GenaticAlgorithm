package ga;

import ga.operations.crossover.CrossOver;
import ga.operations.mutation.Mutation;
import ga.operations.replacement.Replacement;
import ga.operations.selection.Selection;
import ga.population.Couple;
import ga.population.Individual;
import ga.population.Population;
import java.util.ArrayList;

/**
* THis class is to encapsulate the whole GA behavivour including Mutation, selection, crossover and replacement.
* it is a startegy pattern that the behvaiour
*/
public class GABehaviour<T> {
  Selection<T> selection;
  Mutation<T> mutation;
  CrossOver<T> crossOver;
  Replacement<T> replacement;
  
  /*
  * constructor to instance an object
  * @param s instance of Selection interface
  * @param m instance of Mutation interface
  * @param c instance of CrossOver interface
  * @param r instance of Replacement interface
  */
  public GABehaviour(Selection<T> s, Mutation<T> m, CrossOver<T> c, Replacement<T> r) {
    this.selection = s;
    this.mutation = m;
    this.crossOver = c;
    this.replacement = r;    
  }
  
  /**
  * @param pp population
  * @return a couple of individuals
  */
  public Couple<T> select(Population<T> pp) {
      return selection.select(pp);
  }
  
  /**
  * @param cpl instance of Couple class
  * @return instance of individual instance
  */
  public Individual<T> crossOver(Couple<T> cpl) {
    return crossOver.doCrossOver(cpl);
  }

  /**
  * @param individual individual object
  * @param potentials accepting potential values for genes inserted by the user
  */
  public void mutate(Individual<T> individual, ArrayList<T> potentials) {
    mutation.mutate(individual, potentials);    
  }

  /**
  * @param pp population
  * @param newIndividual new individual to replace
  */
  public void replace(Population<T> pp, Individual<T> newIndividual) {
    replacement.replace(pp, newIndividual);
  }

  /**
  * helper method to return pretty-formatted info about current behaviour
  * @return pretty-formatted string
  */
  public String toString() {
    String s = "Current Behaviour:\n"+
               "\tMutation: " + mutation.getClass().getName() +
               "\n\tSelection: " + selection.getClass().getName() +
               "\n\tCrossOver: " + crossOver.getClass().getName() +
               "\n\tReplacement: " + replacement.getClass().getName();

    return s;
  }
}