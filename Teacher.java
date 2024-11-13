import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private int teacherId;
    private String teacherName;
    private List<Integer> courseCodes;
    private int maxHoursPerDay;
    private int maxHoursPerWeek;

    public Teacher(int teacherId, String teacherName, String courseCodes, int maxHoursPerDay, int maxHoursPerWeek) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.courseCodes = parseCourseCodes(courseCodes);
        this.maxHoursPerDay = maxHoursPerDay;
        this.maxHoursPerWeek = maxHoursPerWeek;
    }

    private List<Integer> parseCourseCodes(String codes) {
        List<Integer> codeList = new ArrayList<>();
        for (String code : codes.split(",")) {
            codeList.add(Integer.parseInt(code.trim()));
        }
        return codeList;
    }

    // Getters
    public int getTeacherId() {
        return teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public List<Integer> getCourseCodes() {
        return courseCodes;
    }

    public int getMaxHoursPerDay() {
        return maxHoursPerDay;
    }

    public int getMaxHoursPerWeek() {
        return maxHoursPerWeek;
    }

    // Setters
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setCourseCodes(List<Integer> courseCodes) {
        this.courseCodes = courseCodes;
    }

    public void setMaxHoursPerDay(int maxHoursPerDay) {
        this.maxHoursPerDay = maxHoursPerDay;
    }

    public void setMaxHoursPerWeek(int maxHoursPerWeek) {
        this.maxHoursPerWeek = maxHoursPerWeek;
    }

    public void setCourseCodes(String courseCodes) {
        this.courseCodes = parseCourseCodes(courseCodes);
    }
}
