import java.util.ArrayList;

import simulator.ClientSimulator;


class Main {
  public static void main(String[] args) {
   
    ArrayList<Character> humanGenes = new ArrayList<>();
    humanGenes.add('A');
    humanGenes.add('G');
    humanGenes.add('T');

    ArrayList<Integer> binaryGenes = new ArrayList<>();
    binaryGenes.add(0);
    binaryGenes.add(1);

    int pplSize = 4000;
    int indLength = 30;
    double muteRate = 0.1;
    //ClientSimulator<Character> client = new ClientSimulator<>(pplSize, indLength, muteRate, humanGenes);
    ClientSimulator<Integer> client = new ClientSimulator<>(pplSize, indLength, muteRate, binaryGenes);
    client.simulateNTimes(20000);
  }
}










