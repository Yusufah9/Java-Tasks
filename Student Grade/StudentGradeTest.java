import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentGradeTest {

    @Test
    public void testCalculateTotal() {
        int[] scores = {67, 21, 49};
        int expected = 137;
        int actual = StudentGrade.calculateTotal(scores);
        assertEquals(expected, actual);
    }

    @Test
    public void testCalculateAverage() {
        int[] scores = {67, 21, 49};
        double expected = 45.666666666666664;
        double actual = StudentGrade.calculateAverage(scores);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testSubjectTotalAndAverage() {
        int[][] scores = {
            {67, 21, 49},
            {98, 62, 56},
            {93, 34, 27},
            {78, 83, 66}
        };

        int expectedTotal = 336;
        int actualTotal = StudentGrade.calculateSubjectTotal(scores, 0);
        assertEquals(expectedTotal, actualTotal);

        double expectedAverage = 84.0;
        double actualAverage = StudentGrade.calculateSubjectAverage(scores, 0);
        assertEquals(expectedAverage, actualAverage, 0.01);
    }

    @Test
    public void testPassesAndFails() {
        int[][] scores = {
            {67, 21, 49},
            {98, 62, 56},
            {93, 34, 27},
            {78, 83, 66}
        };

        int passMark = 50;

        int expectedPasses = 4;
        int actualPasses = StudentGrade.countPasses(scores, 0, passMark);
        assertEquals(expectedPasses, actualPasses);

        int expectedFails = 2;
        int actualFails = StudentGrade.countFails(scores, 1, passMark);
        assertEquals(expectedFails, actualFails);
    }

    @Test
    public void testHighestAndLowestStudentForSubject() {
        int[][] scores = {
            {67, 21, 49},
            {98, 62, 56},
            {93, 34, 27},
            {78, 83, 66}
        };

        int expectedHighestIndex = 1;
        int actualHighestIndex = StudentGrade.getHighestScoringStudentForSubject(scores, 0);
        assertEquals(expectedHighestIndex, actualHighestIndex);

        int expectedLowestIndex = 0;
        int actualLowestIndex = StudentGrade.getLowestScoringStudentForSubject(scores, 0);
        assertEquals(expectedLowestIndex, actualLowestIndex);
    }

    @Test
    public void testClassTotalAndAverage() {
        int[][] scores = {
            {67, 21, 49},
            {98, 62, 56},
            {93, 34, 27},
            {78, 83, 66}
        };

        int expectedTotal = 734;
        int actualTotal = StudentGrade.calculateClassTotal(scores);
        assertEquals(expectedTotal, actualTotal);

        double expectedAverage = 183.5;
        double actualAverage = StudentGrade.calculateClassAverage(scores);
        assertEquals(expectedAverage, actualAverage, 0.01);
    }
}



// javac -cp "junit-platform-console-standalone-1.11.0.jar:." StudentGrade.java StudentGradeTest.java StudentMain.java


//  java -jar junit-platform-console-standalone-1.11.0.jar --class-path . --select-class StudentGradeTest

