package Controller;

import Model.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import Common.Validation;

public class StudentController {
    private ArrayList<Student> studentList = new ArrayList<>();

    public void createStudent(int id, String studentName, String semester, String courseName) {
        Student student = new Student(id, studentName, semester, courseName);
        studentList.add(student);
    }

    public void createStudentFromInput(Scanner scanner, Validation validation) {
        System.out.print("Enter student ID: ");
        int id = validation.checkInputIntLimit(1, Integer.MAX_VALUE);
        System.out.print("Enter student name: ");
        String studentName = validation.checkInputString();
        System.out.print("Enter semester: ");
        String semester = validation.checkInputString();
        System.out.print("Enter course name (Java/.Net/C/C++): ");
        String courseName = validation.checkInputCourse();
        createStudent(id, studentName, semester, courseName);
    }

    public void createStudentsFromInput(Scanner scanner, Validation validation) {
        while (true) {
            createStudentFromInput(scanner, validation);
            if (studentList.size() > 1) {
                System.out.print("Do you want to continue (Y/N)? ");
                boolean isContinue = validation.checkInputYN();
                if (!isContinue) {
                    break;
                }
            }
        }
    }

    public void updateStudent(int id, String studentName, String semester, String courseName, Validation validation) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                student.setStudentName(studentName);
                student.setSemester(semester);
                student.setCourseName(courseName);
                break;
            }
        }
    }

    public void updateStudentFromInput(Scanner scanner, Validation validation) {
        System.out.print("Enter student ID: ");
        int studentId = validation.checkInputIntLimit(1, Integer.MAX_VALUE);
        ArrayList<Student> students = getStudentList();
        boolean found = false;
        for (Student student : students) {
            if (student.getId() == studentId) {
                found = true;
                System.out.print("Do you want to update (U) or delete (D) student (U/D)? ");
                boolean isUpdate = validation.checkInputUD();
                if (isUpdate) {
                    System.out.print("Enter new student name: ");
                    String newStudentName = validation.checkInputString();
                    System.out.print("Enter new semester: ");
                    String newSemester = validation.checkInputString();
                    System.out.print("Enter new course name (Java/.Net/C/C++): ");
                    String newCourseName = validation.checkInputCourse();
                    updateStudent(studentId, newStudentName, newSemester, newCourseName, validation);
                    System.out.println("Student updated successfully.");
                } else {
                    deleteStudent(studentId);
                    System.out.println("Student deleted successfully.");
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    public void deleteStudent(int id) {
        studentList.removeIf(student -> student.getId() == id);
    }

    public ArrayList<Student> searchStudents(String studentName) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getStudentName().toLowerCase().contains(studentName.toLowerCase())) {
                result.add(student);
            }
        }
        Collections.sort(result, Comparator.comparing(Student::getStudentName));
        return result;
    }


    public ArrayList<Student> getStudentList() {
        return studentList;
    }
    
}
