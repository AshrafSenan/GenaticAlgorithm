package ga.operations.selection;
import ga.population.Population;
import ga.population.Couple;
import java.util.Random;
/**
* An implementation of strategy pattern on selection with a behaviour TournamentSelection
*/
public class TournamentSelection<T> implements Selection<T> {
  /**
  * implementation of select method to support runtime bahaviour change
  * @param pp population
  * @return the best matching couple of the population
  */
  public Couple<T> select(Population<T> pp) {
   Random rnd = new Random();
   int midPoint = pp.size()/4 + rnd.nextInt(pp.size()/2);
   Couple<T> firstCouple = pp.getTheBestTwo(0, midPoint);
   Couple<T> secondCouple = pp.getTheBestTwo(midPoint+1, pp.size());
   Couple<T> tournament = new Couple<T>(firstCouple.getBest(), secondCouple.getBest());

    return tournament;
  }
}