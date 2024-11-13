import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Check if the program has enough arguments for input file paths
        if (args.length < 2) {
            System.out.println("Please Enter <lessons.csv> fle and then <teachers.csv> file to run the algorithm");
            return;
        }

        String lessons = args[0];
        String teachers = args[1];
        String outputCSVFile = "schedule.csv";  // Define a fixed name for the output file

        GeneticAlgorithm algorithm = new GeneticAlgorithm();
        //populationSize, mutationProbability, maximumSteps, minimumFitness
        Chromosome solution = algorithm.run(1000, 0.08, 1000, 28);
        solution.print();
    }
}
