import java.util.Random;
 
  // [Course Code, Grade, Teacher ID, Time Slot]
    public class Gene {
        FileExtraction fileExtraction;
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


        public Gene RandomGeneGenerator() { 
            
            Gene gene = new Gene(getRandCourseCode(), getRandGrade(), getRandTeacherId(), getRandTimeslot());
            return gene;
        }

        public int getCourseCode() { 
            return coursecode; 
        }

        public int getRandCourseCode() { 
            Lesson l[] = fileExtraction.getLessons();
            Random r = new Random();
            int rand = r.nextInt(l.length);
            
            int rand_course_code = l[rand].getCourseCode();
            return rand_course_code; 
        }

        public void setCourseCode(int coursecode) { 
            this.coursecode = coursecode; 
            }

        public char getGrade() { 
            return grade; 
            }

        public char getRandGrade() { 
            Random r = new Random();
            int rand = r.nextInt(3);
            char grade = 0;
            if (rand == 1) grade = 'a'; 
            if (rand == 2) grade = 'b'; 
            if (rand == 3) grade = 'c'; 

            return grade; 
            }

        public void setGrade(char grade) { 
            this.grade = grade; 
            }

        public int getTeacherId() { 
            return teacher_id; 
            }

        public void setTeacherId(int teacher_id) { 
            this.teacher_id = teacher_id; 
        }

        public int getRandTeacherId() { 
            Teacher t[] = fileExtraction.getTeachers();
            Random r = new Random();
            int rand = r.nextInt(t.length);
            
            int rand_teacher_id = t[rand].getTeacherId();
            return rand_teacher_id; 
        }

        public String getTimeslot() { 
            return timeslot; 
            }


        public void setTimeslot(String timeslot) { 

            String[] validDays = {"Monday", "Tuesday", "Wednesday", "Thurday", "Friday"};
            boolean isValid = false;


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

        public String getRandTimeslot() { 

            Random day = new Random();
            Random hour = new Random();

            String[] validDays = {"Monday", "Tuesday", "Wednesday", "Thurday", "Friday"};

            int rand_day = day.nextInt(validDays.length);

            int rand_hour = hour.nextInt(7);
            timeslot = validDays[rand_day] + "-" + rand_hour; 
            
            return timeslot; // Assign the valid timeslot
        }

        @Override
        public String toString() {
            return "Course Code: " + coursecode + ", Grade: " + grade + ", Teacher ID: " + teacher_id + ", Time Slot: " + timeslot;
        }
    }
