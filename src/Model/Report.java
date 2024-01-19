package Model;

public class Report {
    private String studentName;
    private String courseName;
    private int countCourse;
    
    public Report(){
    }

    public Report(String studentName, String courseName, int countCourse) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.countCourse = countCourse;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCountCourse() {
        return countCourse;
    }

    public void setCountCourse(int countCourse) {
        this.countCourse = countCourse;
    }  
}