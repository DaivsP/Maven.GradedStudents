package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    String firstName;
    String lastName;
    ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(testScores));
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Integer getNumberOfExamsTaken(){
        return this.examScores.size();
    }

    public String getExamScores() {
        Integer examNumber = 1;
        StringBuilder resultScores = new StringBuilder();
        for (Double examResult: examScores){
            resultScores.append("Exam " + examNumber + " -> " + examResult + "\n");
            examNumber++;
        }
        return resultScores.toString();
    }

    public void addExamScore(Double examScore) {
        this.examScores.add(examScore);

    }

    public void setExamScore(int examNumber, Double examValue) {
        this.examScores.remove(examNumber);
        this.examScores.add(examNumber, examValue);
    }

    public Double getAverageExamScore() {
        Double sum = 0.0;
        for (Double examScore : this.examScores) {
            sum += examScore;
        }
        Double average = sum / this.examScores.size();
        return average;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Student Name: " + this.firstName + " " + this.lastName + "\n");
        sb.append("Average Score: " + this.getAverageExamScore() + "\n");
        sb.append("Exam Scores: " + this.getExamScores() + "\n");
        return sb.toString();
    }
}
