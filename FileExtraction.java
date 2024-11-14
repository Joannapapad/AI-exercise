import java.io.*;

public class FileExtraction {
    private Lesson[] lessons;  // Store lessons in a class-level variable
    private Teacher[] teachers; // Store teachers in a class-level variable

    // Method to read the number of lines in the file
    public int ReadLines(String filePath) throws IOException {
        String line = "";
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        int count = 0;
        while ((line = br.readLine()) != null) {
            count++;
        }
        br.close();
        return count;
    }

    // Method to read lessons from the file and store them in the lessons array
    public void ReadLessons(String filePath) throws IOException {
        String line = "";
        File file = new File(filePath);
        int count = ReadLines(filePath);  // Get the number of lessons
        lessons = new Lesson[count];  // Initialize the lessons array
        BufferedReader br2 = new BufferedReader(new FileReader(file));
        
        int i = 0;
        while ((line = br2.readLine()) != null) {
            String[] temp = line.split("\\s+");
            Lesson t = new Lesson(Integer.parseInt(temp[0]), temp[1], temp[2].charAt(0), Integer.parseInt(temp[3]));
            lessons[i] = t;
            i++;
        }
    }

    // Method to read teachers from the file and store them in the teachers array
    public void ReadTeachers(String filePath) throws IOException {
        String line = "";
        File file = new File(filePath);
        int count = ReadLines(filePath);  // Get the number of teachers
        teachers = new Teacher[count];  // Initialize the teachers array
        BufferedReader br2 = new BufferedReader(new FileReader(file));
        
        int i = 0;
        while ((line = br2.readLine()) != null) {
            String[] temp = line.split("\\s+");
            Teacher t = new Teacher(Integer.parseInt(temp[0]), temp[1], temp[2], Integer.parseInt(temp[3]), Integer.parseInt(temp[4]));
            teachers[i] = t;
            i++;
        }
    }

    // Getter for the lessons array
    public Lesson[] getLessons() {
        return lessons;
    }

    // Getter for the teachers array
    public Teacher[] getTeachers() {
        return teachers;
    }
}
