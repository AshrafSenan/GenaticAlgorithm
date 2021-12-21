package ga.population;
import java.util.ArrayList;
import java.util.Random;
import ga.fitness.*;

/**
* A class to represent individual entity of population. Individual object consists of a set of chromosome.
*/
public class Individual<T> implements Comparable<Individual<T>> {
 double fitness;
 /**
 * Individual has a list of genes of generic type
 */
 ArrayList<Gene<T>> genes;
 /**
* Empty Constructor for constructor overloading purposes
*/
 public Individual() {;}
 
 /**
 * A constructor accepting length argument to instantiate Individual objects.
 * @param length the length of genes
 * @param potentials list of accepting values
 */
 public Individual(int length, ArrayList<T> potentials) {
   genes = new ArrayList<Gene<T>>();
   for(int i=0; i<length; i++){
    Random rnd = new Random();
    int randIndex = rnd.nextInt(potentials.size());
    T value = potentials.get(randIndex);
    genes.add(new Gene<T>(value));
   }
 }
 /**
 * Return fitness value of the current individual 
 * @return fitness value
 */
 public double getFitness() {
   return this.fitness;
 }

 /**
 * implementation of Comparable interface compareTo method
 * @param another object to which current object is compared
 * @return 0 if fitness of objects is equal, -1 if fitness of current object less than compared object's fitness, 1 otherwise
 */
 public int compareTo(Individual<T> another) {
   if(this.fitness == another.getFitness())
     return 0;

   else if(this.fitness < another.getFitness())
     return -1;

   return 1;
 }
 /**
 * Returns arraylist of genes of the individual
 * @return list of genes 
 */
 public ArrayList<Gene<T>> getGenes() {
   return this.genes;
 }

  /**
 * Sets the given genes as the genes of the individual
 * @param genes genes to be set
 */
 public void setGenes(ArrayList<Gene<T>> genes) {
   this.genes = genes;
 }
 /**
 * to calculate fitness of target individual
 * @param target target individual
 * @param ftnsCalc an instance of FitnessCalculator interface
 */
 public void calculateFitness(FitnessCalculator ftnsCalc, Individual<T> target) {
  this.fitness = ftnsCalc.calculateFitness(genes, target.genes);
 } 
 /**
 * Sets new value for the gene of the individual at the given index
 * @param index index of the gene
 * @param newVal new value for the gene to be set
 */
 public void setGeneValue(int index, T newVal) {
   this.genes.get(index).setValue(newVal);
 }
 
 /**
 * Returns size of the genes of the individual
 * @return size of genes
 */
 public int size() {
   return genes.size();
 }
 /**
 * Returns the gene value at the specified index of the individual
 * @return gene value
 */
 public T getGeneValue(int index) {
   return genes.get(index).getValue();
 }
 
 @Override
 public String toString() {
   String str = "";
   for(Gene<T> g: genes) 
    str += g.toString();
   return str;
 }
}
