import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProblemTest {

    @Test
    public void testProblemWithTwoArguments() {
        String name = "John";
        String description = "A simple problem description.";
        String expectedOutput = "Problem: John - A simple problem description.";
        
        assertEquals(expectedOutput, Problem.problem(name, description));
    }

    @Test
    public void testProblemWithThreeArguments() {
        String name = "John";
        String description = "A simple problem description.";
        Problem.ProblemType type = Problem.ProblemType.TECHNICAL;
        String expectedOutput = "Problem: John - A simple problem description. (TECHNICAL)";

        assertEquals(expectedOutput, Problem.problem(name, description, type));
    }
}

// javac -cp "junit-platform-console-standalone-1.11.0.jar:." LowestCommonMultiples.java TestLoweestCommonMultiples.java

// java -jar junit-platform-console-standalone-1.11.0.jar --class-path . --select-class TestLoweestCommonMultiples
