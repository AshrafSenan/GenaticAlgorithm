package ga;

import ga.fitness.FitnessCalculator;
import ga.fitness.MatchFitnessCalculator;
import ga.population.*;
import java.util.Random;
import java.util.ArrayList;
import observer.Observer;
/**
* Genetic Algorithm class
*/
public class GA<T> {
  /**
  * The simulator is an obersver to be notified when the 
  */
  Observer simulator;

  Population<T> pp;
  GABehaviour<T> behaviour;
  Individual<T> target;
  int populationSize;
  ArrayList<T> potentialGenValues;
  int mutationPoint;
  int indLength;
  double mutationRate = 0.01;
  FitnessCalculator ftnsCalc;
  
  /**
  * Set observer
  * @param o observer
  */
  public void setObserver(Observer o) {
    this.simulator = o;
  }

  /**
  * Constructor for instantianting genetic algorithm GA objects
  * @param populationSize size of the population
  * @param indLength length of individual
  * @param mtationRate rate of mutation
  */
  public GA(int populationSize, int indLength, double mtationRate){
    this.populationSize = populationSize;
    this.indLength = indLength;
    this.mutationRate = mtationRate;
  }

  /**
  * Set behaviour in runtime
  * @param aBehaviour behaviour
  */
  public void setBehaviour(GABehaviour<T> aBehaviour){
    this.behaviour = aBehaviour;
  }
  
  /** init the population
  * @param target target individual
  * @param ptnalVals accepting potentials values for creating gene given by the user
  * @param ftnsCalc an instance of FitnessCalculator interface
  */
  public void initPopulation(Individual<T> target, ArrayList<T> ptnalVals, FitnessCalculator/*<T>*/ ftnsCalc) {
    this.potentialGenValues = ptnalVals;
    this.ftnsCalc = ftnsCalc;
    this.target = target;
    pp = new Population<T>(this.populationSize, this.indLength, target, this.potentialGenValues, ftnsCalc); 

  }
  
  /**
  * This function select a couple do then do a crossOver between them
  * At random times mutation might be applied and after thae new individual fitness 
  * calculated and the gene is replaced into the population
  */
  public void reProduce() {
    Couple<T> cpl = behaviour.select(pp);
    Random rnd = new Random();
    int mutationRand = rnd.nextInt((int)(1/mutationRate));       
    Individual<T> newIndividual = behaviour.crossOver(cpl);   
    if(mutationRand == mutationPoint)
      behaviour.mutate(newIndividual, potentialGenValues);

    newIndividual.calculateFitness(this.ftnsCalc, target);
    behaviour.replace(pp, newIndividual);    
    //System.out.println(pp.getTheBestTwo().getBest().getFitness());
    //System.out.println(cpl.toString());
    //System.out.println(newIndividual.toString());
    if(pp.getTheBestTwo().getBest().getFitness()== 1.0)
      simulator.update(); 
  }   

  /**
  * Display helper method to print information about status of the running algorithm in the console
  */
  public void showProgress() {
    System.out.println("Target is:" + this.target);    
    System.out.println("Best match is:" + this.pp.getBest());
    System.out.println("Best Fitness %: " + this.pp.getBest().getFitness() * 100 + " %");
  } 

  /**
  * Display helper method to print the current behaviour
  */
  public void showBehaviour() {
    System.out.println(this.behaviour.toString());
  }

}