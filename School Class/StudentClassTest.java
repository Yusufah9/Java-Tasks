import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentClassTest {

    @Test
    public void testStudentLowAndHighGrade() {
        StudentClass lowStudent = new StudentClass("Bob", 0);
        StudentClass highStudent = new StudentClass("Charlie", 15);

        assertEquals(1, lowStudent.getGradeLevel());
        assertEquals(12, highStudent.getGradeLevel());
    }

    @Test
    public void testThatStudentIntroduceThemselves() {
        StudentClass student = new StudentClass("Alice", 10);
        String expected = "Hello, my name is Alice and I am in grade 10.";

        assertEquals(expected, student.introduce());
        assertEquals("Alice", student.getName());
        assertEquals(10, student.getGradeLevel());
    }

    @Test
    public void testPromote() {
        StudentClass student = new StudentClass("Alice", 10);
        student.promote();
        assertEquals(11, student.getGradeLevel());

        StudentClass topStudent = new StudentClass("Senior", 12);
        topStudent.promote();
        assertEquals(12, topStudent.getGradeLevel());
    }

    @Test
    public void testHasPassed() {
        StudentClass student = new StudentClass("Alice", 10);

        assertTrue(student.hasPassed(50.0));
        assertTrue(student.hasPassed(85.0));
        assertFalse(student.hasPassed(49.0));
    }

    @Test
    public void testUpdateName() {
        StudentClass student = new StudentClass("Alice", 10);
        student.updateName("Alice Smith");

        assertEquals("Alice Smith", student.getName());
    }

    @Test
    public void testIsGraduating() {
        StudentClass regularStudent = new StudentClass("Junior", 11);
        StudentClass graduatingStudent = new StudentClass("Senior", 12);

        assertFalse(regularStudent.isGraduating());
        assertTrue(graduatingStudent.isGraduating());
    }
}
