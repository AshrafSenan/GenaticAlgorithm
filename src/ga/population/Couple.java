package ga.population;
/**
* To represents gene of individual. Gene class is generic class.
*/
public class Couple<T> {
  /**
  * the first individual
  */
  Individual<T> i1;
  /**
  * the second individual
  */
  Individual<T> i2;

  public Couple() {}
  public Couple(Individual<T> i1, Individual<T> i2) {
    this.i1 = i1;
    this.i2 = i2;
  }
  /**
  * Returns the first individual of the couple
  * @return the first individual
  */
  public Individual<T> getFirst() {
    return i1;
  }
  /**
  * Returns the second individual of the couple
  * @return the second individual
  */
  public Individual<T> getSecond() {
    return i2;
  }

  /**
  * @return first individual if i1 is greater than i2, otherwise the second individual
  */
  public Individual<T> getBest() {
    if(i1.compareTo(i2) >= 0) 
      return i1;

    return i2;
  }
  /**
  * helper method to return pretty-formatted string of two individuals
  * @return pretty-formatted string
  */
  public String toString() {
    return i1.toString() +"|" + i2.toString();
  }
}