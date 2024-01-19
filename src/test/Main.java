package test;

import Controller.StudentController;
import java.util.ArrayList;
import View.Menu;

import java.util.Scanner;

import Common.Validation;
import Model.Student;

public class Main {
    private static final String[] MAIN_MENU_ITEMS = {
            "Add student",
            "Find and Sort",
            "Update/delete",
            "Report",
            "Exit"
    };

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        studentController.createStudent(1, "Alice", "Spring 2022", "Java");
        studentController.createStudent(2, "Bob", "Fall 2021", ".Net");
        studentController.createStudent(3, "Charlie", "Summer 2023", "C/C++");

        Menu mainMenu = new Menu("Main menu", MAIN_MENU_ITEMS) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        studentController.createStudentFromInput(scanner, new Validation());
                        System.out.println("Student added successfully.");
                        break;
                    case 2:
                        System.out.print("Enter student name: ");
                        String studentName = scanner.nextLine();
                        ArrayList<Student> searchResult = studentController.searchStudents(studentName);
                        if (searchResult.isEmpty()) {
                            System.out.println("No results found.");
                        } else {
                            System.out.println("Search results:");
                            for (Student student : searchResult) {
                                System.out.println(student.getId() + " " + student.getStudentName() + " "
                                        + student.getSemester() + " " + student.getCourseName());
                            }
                        }
                        break;

                    case 3:
                        studentController.updateStudentFromInput(scanner, new Validation());
                        break;
                    case 4:
                        ArrayList<Student> studentList = studentController.getStudentList();
                        ArrayList<String> countedStudents = new ArrayList<String>();
                        for (Student student : studentList) {
                            int total = 0;
                            if (!countedStudents.contains(student.getStudentName() + student.getCourseName())) {
                                for (Student otherStudent : studentList) {
                                    if (otherStudent != student
                                            && otherStudent.getStudentName().equals(student.getStudentName())
                                            && otherStudent.getCourseName().equals(student.getCourseName())) {
                                        total++;
                                    }
                                }
                                countedStudents.add(student.getStudentName() + student.getCourseName());
                                total++;
                                System.out.println(
                                        student.getStudentName() + " " + student.getCourseName() + " " + total);
                            }
                        }
                        break;

                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            }
        };

        mainMenu.run();
    }
}
