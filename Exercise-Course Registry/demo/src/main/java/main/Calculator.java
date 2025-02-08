package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Calculator {
    public static double getAverageGrade(Student student){
        Map<String,Integer> grades = student.getGrades();
        if(grades.isEmpty()){
            return 0;
        }
        int total = 0;
        for (int grade : grades.values()){
            total += grade;
        }
        return total/(double)grades.size();
    }

    public static double getMedianGrade(Student student){
        Map<String, Integer> grades = student.getGrades();
        if(grades.isEmpty()){
            return 0;
        }
        ArrayList<Integer> gradeList = new ArrayList<>(grades.values());
        Collections.sort(gradeList);
        int size = gradeList.size();
        if (size %2 == 0){
            //Even number
            return (gradeList.get(size/2-1) + gradeList.get(size/2)) / 2.0;
        } else {
            //Odd number
            return gradeList.get(size/2);
        }
    }
    }

