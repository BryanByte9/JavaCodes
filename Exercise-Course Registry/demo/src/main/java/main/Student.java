package main;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    // Attributes
    private String name;
    private String studentNumber;
    private LinkedHashMap<String, Integer> courseGrades; // Use LinkedHashMap

    // Constructor
    public Student(String name, String studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.courseGrades = new LinkedHashMap<>(); // Originate LinkedHashmap
    }

    // Add course/grade
    public void addGrade(String course, int grade) {
        this.courseGrades.put(course, grade);
    }

    // Get grade list (Return format is actually LinkedHashMap)
    public Map<String, Integer> getGrades() {
        return courseGrades;
    }

    public String getName() {
        return name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }
}