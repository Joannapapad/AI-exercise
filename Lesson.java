    public class Lesson {
        private int coursecode;
        private String name;
        private char grade;
        private int hoursperweek;

        public Lesson(int coursecode, String name, char grade, int hoursperweek){
            this.coursecode = coursecode;
            this.name = name;
            this.grade = grade;
            this.hoursperweek = hoursperweek;

        }

        public int getCourseCode() {
            return coursecode;
        }

        public String getCourseName() {
            return name;
        }

        public char getGrade() {
            return grade;
        }

        public int getHoursPerWeek() {
            return hoursperweek;
        }


        // Setters
        public void setCourseCode(int coursecode) {
            this.coursecode = coursecode;
        }

        public void setCourseName(String name) {
            this.name = name;
        }

        public void setGrade(char grade) {
            this.grade = grade;
        }

        public void setHoursPerWeek(int hoursperweek) {
            this.hoursperweek = hoursperweek;
        }

    }