package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Classroom {
    Student[] students;
    int size;

    public Classroom(int size){
        this.students = new Student[size];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom(){
        students = new Student[30];
    }

    public Integer getSizeOfClassroom() {
        return this.size;
    }

    public Student[] getStudents() {
        return this.students;
    }

    public Integer getAmountOfStudentSpace() {
        return this.students.length;
    }

    public double getAverageExamScore() {
        Double examScores = 0.0;
        for (Student student : this.students) {
            examScores = student.getAverageExamScore();
        }
        return examScores;
    }

    public void add(Student student) {
        List<Student> studentList = new ArrayList<>(Arrays.asList(this.students));
        studentList.add(student);
        studentList.remove(0);
        this.students = studentList.toArray(new Student[0]);
    }

    public void remove(String firstName, String lastName) {
        List<Student> studentList = new ArrayList<>(Arrays.asList(this.students));
        List<Student> studentsToRemove = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getFirstName().equals(firstName)  && student.getLastName().equals(lastName));
            studentsToRemove.add(student);
        }
        studentList.removeAll(studentsToRemove);
        this.students = studentList.toArray(new Student[0]);
    }

    public String[] getStudentsByScore() {
        List<Student> studentList = new ArrayList<>(Arrays.asList(this.students));
        List<String> examList = new ArrayList<>();
        for (Student student : studentList) {
            String examScores = student.getExamScores();
            examList.add(examScores);
        }
        return examList.toArray(new String[0]);
    }

    public String getGradebook() {
        List<Student> studentList = new ArrayList<>(Arrays.asList(this.students));
        StringBuilder answer = new StringBuilder();
        for (Student student : studentList) {
            if (student.getAverageExamScore() > 90){
                answer.append(student.getFirstName() + ": A");
            }
            else if (student.getAverageExamScore() > 80 && student.getAverageExamScore() < 91){
                answer.append(student.getFirstName() + ": B");
            }
            else if (student.getAverageExamScore() > 70 && student.getAverageExamScore() < 81){
                answer.append(student.getFirstName() + ": C");
            }
            else if (student.getAverageExamScore() > 60 && student.getAverageExamScore() < 71){
                answer.append(student.getFirstName() + ": D");
            }
            else if (student.getAverageExamScore() < 60){
                answer.append(student.getFirstName() + "F");
            }
        }
        return answer.toString();
    }
}