package simulator;

import ga.GA;
import ga.fitness.FitnessCalculator;
import ga.fitness.MatchFitnessCalculator;
import ga.operationfactories.BehaviourGenerator;
import ga.operationfactories.RRRFactory;
import ga.operationfactories.*;
import ga.population.Individual;
import observer.Observer;
import java.util.ArrayList;

/**
* it is an observer to be notified when the GA find the target
*/
public class ClientSimulator<T> implements Observer{
  GA<T> aGA; 
  Individual<T> target;
  boolean stop = false;
  int iterations, times;
  ArrayList<OperationsFactory<T>> factoriesList;
  BehaviourGenerator<T> behavGenerator;
  int crntBehaviourIndex;
 
  public void initBehaviourGenerator() {
    factoriesList = new ArrayList<>();
    factoriesList.add(new RRRFactory<>());
    factoriesList.add(new ERAFactory<>());
    factoriesList.add(new ERWFactory<>());
    factoriesList.add(new TCWFactory<>());
    crntBehaviourIndex = 0;
    behavGenerator = new BehaviourGenerator<T>(factoriesList.get(crntBehaviourIndex));
  }
   /**
  * Initial the GA with population, target and potential values
  * @param populationSize size of the population
  * @param indLength length of Individual
  * @param mutationRate the rate of mutationRate
  * @param ptnalVals list of accepting potential values for gene given by the user
  */
  public ClientSimulator(int populationSize, int indLength, double mutationRate, ArrayList<T> ptnalVals) {
    aGA= new GA<>(populationSize, indLength, mutationRate);
    this.target = new Individual<T>(indLength, ptnalVals);
    // prepare the Fitness calculator
    FitnessCalculator ftnsCalc = MatchFitnessCalculator.getInstance();
    aGA.setObserver(this);
    aGA.initPopulation(target, ptnalVals, ftnsCalc);
    //Make the behaviour from the abstract factory
    initBehaviourGenerator();
    aGA.setBehaviour(behavGenerator.getBehaviour());

    System.out.println("population Size is:" + populationSize);
    System.out.println("Individual Length is:" + indLength);
    //System.out.println("Current:" + indLength);
    System.out.println("Target is:" + target +"\n\n***************Starting***********\n\n");

  }

  /**
  * simulates the genetic algorithm
  * @param times the number of times to run simulation
  */
  public void simulateNTimes(int times) {
    int i = 1;
    this.times = times;
    while(i<=times && !stop) {
      iterations = i++;
      aGA.reProduce();
      //Change the GA behaviour every 500 itteration
      if(i%500 == 0) {
        System.out.println("\nAfter "+ i + " Generations:\n");
        aGA.showProgress();
        aGA.showBehaviour();
        crntBehaviourIndex = (crntBehaviourIndex + 1) % factoriesList.size();
        behavGenerator.setFactory(factoriesList.get(crntBehaviourIndex));
        aGA.setBehaviour(behavGenerator.getBehaviour());
      }
      
    }  
      
    System.out.println("\nFinal Result:\n");
    System.out.println("\nAfter "+ i + " Generations:\n");
    aGA.showProgress();
    aGA.showBehaviour();
    
  }

  /**
  * observer method. Notify the user when the target is reached
  */
  public void update(){
    System.out.println("The target was reached after :" + iterations +" generations.");
    System.out.println("Target is:" + target);
    stop = true;
    
  }

}