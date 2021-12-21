package ga.population;
import ga.operations.mutation.Mutation;
import java.util.ArrayList;
import java.util.Random;

/**
* Gene class represents gene/chromosome of an individual
*/
public class Gene<T> {
 /*
 * Generics is used for defining data type
 */
 T value;
/**
* Empty Constructor for constructor overloading purposes
*/
 public Gene() {;}

 /**
 * Constructor accepting value to set for gene
 * @param val value
 */
 public Gene(T val) {
   this.value = val;
 }
  /**
  * Sets value to the gene
  * @param val value
  */
 public void setValue(T val) {
   this.value = val;
 }
/**
* Returns the value of the gene
* @return value
*/
 public T getValue() {
   return value;
 }
 
 /**
 * equals methods is overriden to provide a method for comparing elements by getting their value.
 * @param otherGene compared object
 * @return true if objects have the same value, otherwise false
 */
 public boolean equals(Gene<T> otherGene) {
   return this.value == otherGene.getValue();
 }

 /**
 * Dependency Injection to make a mutation for some gene.
 * @param mutation object of type Mutation
 * @param potentials list of potentials
 */
 public void mutate(Mutation<T> mutation, ArrayList<T> potentials) {
    this.value = mutation.mutate(this.value, potentials);
 }
 /**
 * Helper method to return pretty-formatted string of the value
 * @return pretty-formatted string of the value
 */
 public String toString() {
   return value.toString();
 }

}