
__General Overview__

This is an actual implementation of the genatic algorithm, with all its operations, dynamic, and generic to any type of data. It stars by creating a random target and make progress toward it.

I did this project with:
      Shahla Orujova 
      Ankit Jha 
      Dostonbek Matyakubov

This project implemented the following features:

  1.Generics - All classes are Generic and accept any type of data where client can specify what type of data wanted.
  
  2. The population size and individual length is dynamic can be specified by the client

  3. Abstract Factory - BehaviourGenerator is an Abstract Factory that creates related behaviours using OperatioFactory and its concrete classes.
  
  4. Strategy - All the behaviours( Mutation, Selection, CrossOver, and Replacement) they are saved as strategy pattern in the GABehaviour. Being strategy will help to change the GA behaviour during run time to make it more powerful.

  5. Observer - Simulator is an observor to watch ghe GA. Once the GA found the target it will update the Simulator to stop and show the finaly summary.
  6. Dependency injection - Gene class contains an dependency injection pattern to inject mutatiion calculation.
  7. Singleton - FitnessEvaluator is a singleton. There is no need to create multiple instance of this class. Because all algorithms will have the same calculator. If it is not a Singleton it will be a waste of memory and CPU resources.
  8. Dynamic Behaviour - Every 500 generations the GA behavior changes automatically and the simulator shows the current progress twoard the target.
  9. The algorithm output start by the following message: 
      

      
      
      population Size is:4000
      Individual Length is:30
      Target is:001111101101100011101000100111


10.   Each 500 Generations the system whows the progress as follows:


      Target is:001111101101100011101000100111

      Best match is:001111101111100001101010111111

      Best Fitness %: 83.33333333333334 %
      Current Behaviour:
              Mutation: ga.operations.mutation.RandomMutation
              Selection: ga.operations.selection.RandomSelection
              CrossOver: ga.operations.crossover.RandomCrossOver
              Replacement: ga.operations.replacement.AddReplacement

11. If the GA find the solution it stop the reproduction and show the following message:  

      The target was reached after :1795 generations.
      Target is:001111101101100011101000100111

      Final Result:

12. After finishing by either finding the target or exceeding the iterations the following message shows:


      After 1796 Generations:

      Target is:001111101101100011101000100111
      Best match is:001111101101100011101000100111
      Best Fitness %: 100.0 %
      Current Behaviour:
              Mutation: ga.operations.mutation.RandomMutation
              Selection: ga.operations.selection.TournamentSelection
              CrossOver: ga.operations.crossover.RandomCrossOver
              Replacement: ga.operations.replacement.WorstReplacement
        

A genetic algorithm is comprised of population which consists of some dynamic number of individuals. Each individual is a set of dynamic number of (we took 10 in our example) chromosomes that are shown as an array of characters in our example. The numerical structure of our genetic algorithm example (but it is generic and could be changed) is as following:
  
      - population           01 unique population(Dynamic and generic)
      
      -> individuals         4000 individuals of the population(type and size can be set by the client)
          
      -> chromosomes         10 chromosomes of each individual (type and size can be set by the client)
    
      - couple               01 couple instance

      -> individuals         02 individuals taken from population

- __ga package__ 
   - __fitness package__

  fitness package is responsible for determining fitness the fitness of an individual and contains FitnessEvaluator class. The fitness is measured in perenctage and denotes how close is the individual to the target.
  Thread safe singleton with double checked locking principle design is implemented since for the entire project we only need one fitness evaluator instance. Having one singleton saves the memory and cpu from the unreasonable over use.
  
   - __operation package__

  In operation package, we have crossover, mutation, replacement and selection operation packages where under each section there are classes related to indicated operation. The selection, crossover, replacement and mutation operations were written based on strategy pattern where we each of them have one interface named as Selection, CrossOver, Replacement, Mutation respectively. Besides, while inside selection package, we have ElitSelection and TournamentSelection classes, crossover package contains OnePointCrossOver and RandomCrossover classes as well. Inside mutation package, we have  Mutation interface and RandomMutation class. Also, replacement package has Replacement interface and AddReplacement, RandomReplacement, WorstReplacement classes.
    
    - __selection package__

      ElitSelection gets the fittest individual and the second fittest individual to target from population and returns these individuals as a Couple class instance. On the other hand, TournamentSelection takes small portion of the population which consists of 4 random individuals and then returns 2 most fitting individuals from this portion by comparing them based on their fitnesses. The structure of selection package is as following:

          - Selection interface
          - TournamentSelection class
          - ElitSelection class 
          
    - __crossover package__

        OnePointCrossOver operation takes a Couple class instance as an argument and randomly takes a midpoint from where we will perform crossover of these individuals. Then it performs crossover of these individuals by taking genes of first individual till midpoint and genes of second individual after midpoint. On the other hand, RandomCrossOver operation takes one couple and returns the result by taking genes randomly from the parents. The package structure is as following:

            - CrossOver interface
            - OnePointCrossOver class
            - RandomCrossOver class

    - __mutation package__

      In mutation package we have only one mutation class which is RandomMutation. However, we programmed it with strategy pattern for further additions to our system. So, we have Mutation interface and RandomMutation class which takes random number of individuals from population and mutate them by bit inverting. The structure of mutation package is as following:

            - Mutation interface
            - RandomMutation class
            
    - __replacement package__
      In replacement package, we have Replacement interface and AddReplacement, RandomReplacement, WorstReplacement classes for showing functionality of replacement of individuals after crossovers. AddReplacement just adds the new individual to the population. WorstReplacement replaces the least fitting individual in population with new individual. Also, RandomReplacement randomly replaces any one individual with the child (crossover result).
      In replacement package, the structure is as following:
            
            - Replacement interface
            - AddReplacement class
            - RandomReplacement class
            - WorstReplacement class
    
    - __operationsfactories__

  The operations factories package aims to facilitate the creation of dynamy behaviour for the GA.

  it contains the following classes:
      
      - OperatioFactory this is the abstraction of all concrete factories. It abstract the creation of related behaviours including selection, mutation, crossover and replacement

      - BehaviourGenerator is the abstract factory the creates the GABehaviour class

      - ERAFactory return a behaviour with Elite selection, Random crossOver, addReplacement and Random Mutation   

      - ERWFactory return a behaviour with Elite selection, Random crossOver, WorstReplacement and Random Mutation

      - RRRFactory return a behaviour with Random selection, Random crossOver, Random Replacement and Random Mutation

      - TCWFactory return a behaviour with TournamentSelection, Random crossOver, Random Replacement and Random Mutation


  __Abstract factory pattern__ applied in the previous OperatioFactoryies


  - __popuation package__

  population packages describes:
    - a population
        Population class describes population of the genetic algorithm.
    - a couple of individuals
        Couple class describes two individuals
    - individuals of the population
        Individual class describes an individual entity of the population.
    - a gene of individual
        Gene class describes gene(chromosome) of individual.

  - GA class

  GA class encapsulates everything related to genetic algorithm which are population, behavior and the reproduction method.

  - GABehavior class

  GA Behavior encapsulates all the operations related to genetic algorithm including replacement, crossover, selection and mutation. 

- __observer package__

The observer package provides an interface for observation. The structure of observer package is as following:

    - Observer interface
    
- __simulator__
The simulator package contains ClientSimulator which does all the simulation issue which implements Observer interface. The structure of simulator package is as following:

    - ClientSimulator class



__How to run the program__

Our program is generic, so the person who runs this program can change the population size, the length of individuals, mutation rate and the number of simulation times. In our example, we used 4000 as a population size, 10 as an individual length and 0.1 as mutation rate. Also, we have simulation 10000 times as an example. The user can change these cridentials. Below, you can see our initial example:

ClientSimulator<>(4000, 10, 0.1, geneValues);
client.simulateNTimes(10000);










