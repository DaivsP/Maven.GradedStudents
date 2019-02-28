package io.zipcoder;
import org.junit.Assert;
import org.junit.Test;

public class StudentTest {
    @Test
    public void constructorTest(){
        Student student = new Student(null, null, null);

        //Given
        student.setFirstName("Davis");
        student.setLastName("Perchik");

        //When
        String expectedFirstName = "Davis";
        String expectedLastName = "Perchik";
        //Then
        String actualFirstName = student.getFirstName();
        String actualLastName = student.getLastName();

        Assert.assertEquals(expectedFirstName, actualFirstName);
        Assert.assertEquals(expectedLastName, actualLastName);
    }

    @Test
    public void setExamScoresTest(){
        //Given
        String firstName = "Davis";
        String lastName = "Perchik";
        Double[] examScores = {100.0, 95.0, 90.0};
        Student student = new Student(firstName, lastName, examScores);

        //When
        StringBuilder sb = new StringBuilder();
        sb.append("Exam 1 -> 100" + "\n");
        sb.append("Exam 2 -> 95" + "\n");
        sb.append("Exam 3 -> 95" + "\n");
        String expectedExamScores = sb.toString();

        //Then
        String actualExamScores = student.getExamScores();
        Assert.assertEquals(expectedExamScores, actualExamScores);
    }
}