package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;

public class ClassroomTest {

    @Test
    public void constructorTest1(){
        //Given
        int size = 3;
        Classroom classroom = new Classroom(size);

        //When
        Integer actual = classroom.getAmountOfStudentSpace();

        //Then
        Integer expected = 3;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorTest2(){
        //Given
        Student student1 = new Student("Davis", "Perchik", new Double[0]);
        Student student2 = new Student(null, null, new Double[0]);
        Student[] students = {student1, student2};
        Classroom classroom = new Classroom(students);

        //When
        Student[] actual = classroom.getStudents();

        //Then
        Student[] expected = students;
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void nullaryConstructorTest(){
        // Given
        Classroom classroom = new Classroom();

        // When
        Integer actual = classroom.getAmountOfStudentSpace();

        // Then
        Integer expected = 30;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageExamScoreTest(){
        //Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1, s2};
        Classroom classroom = new Classroom(students);

        // When
        double actual = classroom.getAverageExamScore();

        // Then
        double expected = 125.0;
        Assert.assertEquals(expected, actual, 1);
    }

    @Test
    public void addStudentTest(){
        // Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Davis", "Perchik", examScores);

        // When
        Student[] preEnrollment = classroom.getStudents();
        classroom.add(student);
        Student[] postEnrollment = classroom.getStudents();

        // Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);
        Assert.assertNotEquals(preEnrollmentAsString, postEnrollmentAsString);
    }

    @Test
    public void removeStudentTest(){
        // Given
        int maxNumberOfStudent = 1;
        Classroom classroom = new Classroom(maxNumberOfStudent);
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student student = new Student("Davis", "Perchik", examScores);
        Student student1 = new Student("Cara", "Epes", examScores);
        classroom.add(student);
        classroom.add(student1);

        // When
        Student[] preEnrollment = classroom.getStudents();
        classroom.remove("Davis", "Perchik");
        Student[] postEnrollment = classroom.getStudents();

        // Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);
        Assert.assertNotEquals(preEnrollmentAsString, postEnrollmentAsString);
    }

    @Test
    public void getStudentsByScoreTest(){
        // Given
        int maxNumberOfStudent = 1;
        Classroom classroom = new Classroom(maxNumberOfStudent);
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student student = new Student("Davis", "Perchik", examScores);
        Student student1 = new Student("Cara", "Epes", examScores);
        classroom.add(student);
        classroom.add(student1);

        // When
        String[] studentsByScoreArray = classroom.getStudentsByScore();
        String studentsByScore = Arrays.toString(studentsByScoreArray);

        // Then
        StringBuilder sb = new StringBuilder();
        sb.append("[Exam 1 -> 100.0" + "\n");
        sb.append("Exam 2 -> 150.0" + "\n");
        sb.append("Exam 3 -> 250.0" + "\n");
        sb.append("Exam 4 -> 0.0" + "\n");
        sb.append("]");
        String expected = sb.toString();
        Assert.assertEquals(expected, studentsByScore);
    }

    @Test
    public void getGradeBookTest(){
        // Given
        int maxNumberOfStudent = 1;
        Classroom classroom = new Classroom(maxNumberOfStudent);
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Double[] examScores1 = {90.0, 80.0, 100.0, 80.0};
        Student student = new Student("Davis", "Perchik", examScores);
        Student student1 = new Student("Cara", "Epes", examScores1);
        classroom.add(student);
        classroom.add(student1);

        // When
        String actual = classroom.getGradebook();

        // Then
        StringBuilder sb = new StringBuilder();
        sb.append("Cara: B");
        String expected = sb.toString();
        Assert.assertEquals(expected, actual);
    }
}
