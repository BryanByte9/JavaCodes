package main;

import java.io.*;
import java.util.ArrayList;
public class University {
    // Attribute
    private ArrayList<Student> students;

    public University() {
        // Originate student list
        students = new ArrayList<>();
    }

    // List all students in following format
    public void listStudents() {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println(i + ": " + student.getStudentNumber() + ": " + student.getName());
        }
    }

    // Add student
    public void addStudent(String name, String studentNumber) {
        Student student = new Student(name, studentNumber);
        students.add(student);  // Add "student" to list "students"
    }

    // Get all students
    public ArrayList<Student> getStudents() {
        return students;
    }

    // Get student by index
    public Student getStudentByIndex(int index) {
        if (index >= 0 && index < students.size()) {
            return students.get(index);
        }
        return null;
    }

    // Get student by ID
    public Student getStudent(String studentNumber) {
        for (Student student : students) {
            if (student.getStudentNumber().equals(studentNumber)) {
                return student;
            }
        }
        return null;
    }

    // Save data to file(Serialization)
    public void saveToFile(String filename) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filename);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(students);  // Write List "students" to file 
            System.out.println("Students saved to file.");
        } catch (Exception e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }
    
    // Load data from file
    @SuppressWarnings("unchecked")
    public void loadFromFile(String filename) {
        try (FileInputStream fileInputStream = new FileInputStream(filename);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            students = (ArrayList<Student>) objectInputStream.readObject();  // Read List "students" from file
            System.out.println("Students loaded from file.");
        } catch (Exception e) {
            System.out.println("Error loading students: " + e.getMessage());
            students = new ArrayList<>();  // If fail to load, return an empty list, prevent error
        }
    }
}