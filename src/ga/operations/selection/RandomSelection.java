package ga.operations.selection;
import ga.population.Population;
import ga.population.Couple;
import ga.population.Individual;
import java.util.Random;
/**
* An implementation of strategy pattern on selection with a behaviour RandomSelection
*/
public class RandomSelection<T> implements Selection<T> {
  /**
  * implementation of select method to support runtime bahaviour change
  * @param pp population
  * @return the best matching couple of the population
  */
  public Couple<T> select(Population<T> pp) {
   Random rnd = new Random();
   int firstIndex = rnd.nextInt(pp.size());
   int secondIndex = rnd.nextInt(pp.size());
   while(secondIndex == firstIndex)
    secondIndex = rnd.nextInt(pp.size());

  Individual<T> firstInd = pp.getIndividual(firstIndex);
  Individual<T> secondInd = pp.getIndividual(secondIndex);

  Couple<T> randCpl = new Couple<T>(firstInd, secondInd);

    return randCpl;
  }
}