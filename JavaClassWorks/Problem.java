public class Problem {

    public enum ProblemType {
        FINANCIAL,
        SPIRITUAL,
        EDUCATION,
        TECHNICAL,
        BUSINESS
    }

   
    public static String problem(String name, String description) {
        return "Problem: " + name + " - " + description;
    }

  
    public static String problem(String name, String description, ProblemType problemType) {
        return "Problem: " + name + " - " + description + " (" + problemType + ")";
    }

    public static boolean isSolved(String name, String description, ProblemType problemType) {
        return false;
    }

    public static void addProblem(String name, String description, ProblemType problemType) {
        
    }

    public static void solveProblem(String name, String description, ProblemType problemType) {
       
    } 

    public static void tellProblem(String name, String description, ProblemType problemType) {
        
    }
}
