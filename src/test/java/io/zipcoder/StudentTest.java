package io.zipcoder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {

    Student student;

    @Test
    public void constructorTest(){
        this.student = new Student(null, null, new Double[0]);

        //Given
        this.student.setFirstName("Davis");
        this.student.setLastName("Perchik");

        //When
        String expectedFirstName = "Davis";
        String expectedLastName = "Perchik";

        //Then
        String actualFirstName = this.student.getFirstName();
        String actualLastName = this.student.getLastName();

        Assert.assertEquals(expectedFirstName, actualFirstName);
        Assert.assertEquals(expectedLastName, actualLastName);
    }

    @Test
    public void getExamScoresTest(){
        //Given
        String firstName = "Davis";
        String lastName = "Perchik";
        Double[] examScores = {100.0, 95.0, 90.0};
        this.student = new Student(firstName, lastName, examScores);

        //When
        StringBuilder sb = new StringBuilder();
        sb.append("Exam 1 -> 100.0" + "\n");
        sb.append("Exam 2 -> 95.0" + "\n");
        sb.append("Exam 3 -> 90.0" + "\n");
        String expectedExamScores = sb.toString();

        //Then
        String actualExamScores = student.getExamScores();
        Assert.assertEquals(expectedExamScores, actualExamScores);
    }

    @Test
    public void addExamScoreTest(){
        // Given
        Double[] testScores = { };
        this.student = new Student("Davis", "Perchik", testScores);
        StringBuilder sb = new StringBuilder();
        sb.append("Exam 1 -> 100.0" + "\n");
        String expected = sb.toString();

        // When
        student.addExamScore(100.0);
        String actual = student.getExamScores();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setExamScoreTest(){
        //Given
        String firstName = "Davis";
        String lastName = "Perchik";
        Double[] examScores = {100.0};
        this.student = new Student(firstName, lastName, examScores);
        StringBuilder sb = new StringBuilder();
        sb.append("Exam 1 -> 150.0" + "\n");
        String expected = sb.toString();

        // When
        student.setExamScore(0, 150.0);
        String actual = student.getExamScores();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageExamScoreTest(){
        // : Given
        String firstName = "Davis";
        String lastName = "Perchik";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0};
        Student student = new Student(firstName, lastName, examScores);

        // When
        Double actual = student.getAverageExamScore();

        // Then
        Double expected = 125.0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest(){
        // : Given
        String firstName = "Davis";
        String lastName = "Perchik";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        this.student = new Student(firstName, lastName, examScores);
        String expected = ("Student Name: " + this.student.getFirstName() + " " + this.student.getLastName() + "\n" +
                "Average Score: " + this.student.getAverageExamScore() + "\n" +
                "Exam Scores: " + this.student.getExamScores() + "\n");

        // When
        String actual = this.student.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }
}