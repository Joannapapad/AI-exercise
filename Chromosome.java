import java.util.Random;
import ArrayList;
import java.util.Arrays;

    // [Course Code, Grade, Teacher ID, Time Slot]
    public class Gene{
        private int coursecode;
        private char grade;
        private int teacher_id;
        private String timeslot;

        public Gene(int coursecode, char grade, int teacher_id, String timeslot){
            this.coursecode = coursecode;
            this.grade = grade;
            this.teacher_id = teacher_id;
            setTimeslot(timeslot);
        }

        public String getCourseCode() { 
            return courseCode; 
            }

        public void setCourseCode(String coursecode) { 
            this.coursecode = coursecode; 
            }

        public int getGrade() { 
            return grade; 
            }

        public void setGrade(int grade) { 
            this.grade = grade; 
            }

        public int getTeacherId() { 
            return teacher_id; 
            }

        public void setTeacherId(int teacher_id) { 
            this.teacher_id = teacher_id; 
            }

        public String getTimeslot() { 
            return timeslot; 
            }

        public void setTimeslot(String timeslot) { 

            String[] validDays = {"Monday", "Tuesday", "Wednesday", "Thurday", "Friday"};
            boolean isValide = false;


            for (String day : validDays){
                if (timeslot.startsWith(day) && timeslot.length() == (day.length() + 2)){
                    try {
                        int period = Integer.parseInt(timeslot.substring(day.length()));
                        if (period >= 1 && period <= 7){
                            isValid = true;
                            break;
                        }
                    } catch (NumberFormatException e) {
                        // Invalid number in timeslot
                    }
                    }
                }

            if (!isValid) {
                throw new IllegalArgumentException("Invalid timeslot: " + timeslot + ". It must be in the format Day-Period (e.g., Monday-1, Tuesday-3).");
            }
            
            this.timeslot = timeslot; // Assign the valid timeslot
        }


        @Override
        public String toString() {
            return "Course Code: " + coursecode + ", Grade: " + grade + ", Teacher ID: " + teacher_id + ", Time Slot: " + timeslot;
        }
    }


//Unprocessed Lines of code 
public class Chromosome implements Comparable<Chromosome>
{

    //Each position shows the vertical position of a queen in the corresponding column
    private Gene[] genes;

    public Chromosome(int numGenes) {
        genes = new Gene[numGenes];  // Initialize the array
    }
    //Integer that holds the fitness score of the chromosome
    private int fitness;

    //Constructs a randomly created chromosome
    Chromosome()
    {
        Random r = new Random();
        for(int i = 0; i < this.genes.length; i++)
        {
            this.genes[i] = r.nextInt(8);
        }
        this.calculateFitness();
    }

    //Constructs a copy of a chromosome
    Chromosome(int[] genes)
    {
        this.genes = new int[8];
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
