import java.util.Arrays;
import java.util.Random;

//Unprocessed Lines of code 
public class Chromosome implements Comparable<Chromosome>
{

    //Each position shows the vertical position of a queen in the corresponding column
    private Gene[] genes;

    public Chromosome(FileExtraction fileExtraction) {
        this.genes = new Gene[900]; // Initialize the array to hold the same number of genes

        // Populate each gene in the genes array with a random gene
        for (int i = 0; i < this.genes.length; i++) {
            // Generate a random gene
            Gene randomGene = new Gene(0, 'A', 0, "Monday-1"); // Temporary Gene instance to call method
            this.genes[i] = randomGene.RandomGeneGenerator();
        }

        // Calculate the initial fitness of the chromosome
        this.calculateFitness();
    }

    //Constructs a copy of a chromosome
    Chromosome(Gene[] genes)
    {
        this.genes = new Gene[genes.length]; // Initialize the array to hold the same number of genes
        for(int i = 0; i < this.genes.length; i++)
        {
            this.genes[i] = genes[i];
        }
        this.calculateFitness();
    }

    //Calculates the fitness score of the chromosome as the number queen pairs that are NOT threatened
    //The maximum number of queen pairs that are NOT threatened is (n-1) + (n-2) + ... + (n-n) = 7 + 6 + 5 + 4 + 3 + 2 + 1 = 28
    void calculateFitness()
    {
        int nonThreats = 0;
        for(int i = 0; i < this.genes.length; i++)
        {
            for(int j = i+1; j < this.genes.length; j++)
            {
                if((this.genes[i] != this.genes[j]) &&
                        (Math.abs(i - j) != Math.abs(this.genes[i] - this.genes[j])))
                {
                    nonThreats++;
                }
            }
        }
        this.fitness = nonThreats;
    }

    //Mutate by randomly changing the position of a queen
    void mutate()
    {
        Random r = new Random();
        this.genes[r.nextInt(8)] = r.nextInt(8);
        this.calculateFitness();
    }

    public int[] getGenes() {
        return this.genes;
    }

    public void setGenes(int[] genes) {
        this.genes = genes;
    }

    public int getFitness() {
        return this.fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    void print()
    {
        System.out.print("Chromosome : |");
        for(int i = 0; i < this.genes.length; i++)
        {
            System.out.print(this.genes[i]);
            System.out.print("|");
        }
        System.out.print(", Fitness : ");
        System.out.println(this.fitness);

        System.out.println("------------------------------------");
        for(int i = 0; i < this.genes.length; i++)
        {
            for(int j=0; j < this.genes.length; j++)
            {
                if(this.genes[j] == i)
                {
                    System.out.print("|Q");
                }
                else
                {
                    System.out.print("| ");
                }
            }
            System.out.println("|");
        }
        System.out.println("------------------------------------");
    }

    //compareTo function -> sorting can be done according to fitness scores
    @Override
    public int compareTo(Chromosome x)
    {
        return this.fitness - x.fitness;
    }
    
}
