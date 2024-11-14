import java.io.*;

public class FileExtraction{

    public int ReadLines(String filePath) throws IOException{
        String line = "";
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        int count = 0;
        int i = 0;
        while ((line = br.readLine()) != null) {
            count++;
        }
        br.close();
        return count;
    }

    public void ReadLessons (String filePath ) throws IOException {
        String line = "";
        File file = new File(filePath);
        int i = 0;
        int count = ReadLines(filePath);
        BufferedReader br2 = new BufferedReader(new FileReader(file));
        Lesson []lesson = new Lesson[count];
        while ((line = br2.readLine()) != null){
            String []temp = line.split("\\s+");
            Lesson t = new Lesson(Integer.parseInt(temp[0]), temp[1], temp[2].charAt(0), Integer.parseInt(temp[3]));
            lesson[i] = t;
        }

    }

    public void ReadTeachers (String filePath) throws IOException {
        String line = "";
        File file = new File(filePath);
        int count = ReadLines(filePath);
        int i = 0;
        BufferedReader br2 = new BufferedReader(new FileReader(file));
        Teacher [] teacher= new Teacher[count];
        while ((line = br2.readLine()) != null){
            String []temp = line.split("\\s+");
                Teacher t = new Teacher(Integer.parseInt(temp[0]), temp[1], temp[2], Integer.parseInt(temp[3]), Integer.parseInt(temp[4]));
                teacher[i] = t;
                i++;
            }

        }

    }









