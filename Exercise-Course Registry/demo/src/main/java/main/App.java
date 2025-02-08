package main;

import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        University university = new University();
        while (true) {
            printMenu();
            String input = scanner.nextLine().trim();  // Use nextLine()

            if (input.isEmpty()) {
                continue;  // skip empty input
            }

            try {
                int option = Integer.parseInt(input);
                switch (option) {
                    case 1 -> addStudent(scanner, university);
                    case 2 -> university.listStudents();
                    case 3 -> addCourseCompletion(scanner, university);
                    case 4 -> listCourseCompletions(scanner, university);
                    case 5 -> calculateAverage(scanner, university);
                    case 6 -> calculateMedian(scanner, university);
                    case 7 -> university.saveToFile("students.ser");
                    case 8 -> university.loadFromFile("students.ser");
                    case 0 -> {
                        System.out.println("Thank you for using the program.");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice, please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("1) Add student, 2) List students, 3) Add course completion for student, 4) List course completions of student, 5) Calculate the average of course completions, 6) Calculate median of course completions, 7) Save students to file, 8) Load students from file, 0) End the program");
    }

    private static void addStudent(Scanner scanner, University university) {
        System.out.println("What is the name of the student?");
        String name = scanner.nextLine().trim();
        System.out.println("What is the student number of the student?");
        String studentNumber = scanner.nextLine().trim();
        if (!name.isEmpty() && !studentNumber.isEmpty()) {
            university.addStudent(name, studentNumber);
        } else {
            System.out.println("Name and student number cannot be empty.");
        }
    }

    private static void addCourseCompletion(Scanner scanner, University university) {
        university.listStudents();
        System.out.println("Which student?");
        try {
            int index = Integer.parseInt(scanner.nextLine().trim());
            Student student = university.getStudentByIndex(index);
            if (student != null) {
                System.out.println("What is the name of the course?");
                String course = scanner.nextLine().trim();
                System.out.println("What is the grade of the course?");
                int grade = Integer.parseInt(scanner.nextLine().trim());
                if (grade >= 0 && grade <= 5) {
                    student.addGrade(course, grade);
                } else {
                    System.out.println("Grade must be between 0 and 5.");
                }
            } else {
                System.out.println("Student not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid index format.");
        }
    }

    private static void listCourseCompletions(Scanner scanner, University university) {
        university.listStudents();
        System.out.println("Which student?");
        try {
            int index = Integer.parseInt(scanner.nextLine().trim());
            Student student = university.getStudentByIndex(index);
            if (student != null) {
                student.getGrades().forEach((course, grade) ->
                    System.out.println(course + ": " + grade)
                );
            } else {
                System.out.println("Student not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid index format.");
        }
    }

    private static void calculateAverage(Scanner scanner, University university) {
        university.listStudents();
        System.out.println("Which student?");
        try {
            int index = Integer.parseInt(scanner.nextLine().trim());
            Student student = university.getStudentByIndex(index);
            if (student != null) {
                double average = Calculator.getAverageGrade(student);
                System.out.println("Average is " + average);
            } else {
                System.out.println("Student not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid index format.");
        }
    }

    private static void calculateMedian(Scanner scanner, University university) {
        university.listStudents();
        System.out.println("Which student?");
        try {
            int index = Integer.parseInt(scanner.nextLine().trim());
            Student student = university.getStudentByIndex(index);
            if (student != null) {
                double median = Calculator.getMedianGrade(student);
                System.out.println("Median is " + median);
            } else {
                System.out.println("Student not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid index format.");
        }
    }
}