
import java.util.Scanner;

public class StudentMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int userChoice = -1;
        int numberOfStudents = 0;
        int numberOfSubjects = 0;
        int[][] scores = null;

        while (userChoice != 3) {
            System.out.println("\n === LAGBAJA SCHOOLS GRADE SYSTEM ===");
            System.out.println("1. Input Student Scores");
            System.out.println("2. Display Summary Reports");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            userChoice = input.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.print("How many students do you have? ");
                    numberOfStudents = input.nextInt();

                    System.out.print("How many subjects do they offer? ");
                    numberOfSubjects = input.nextInt();

                    scores = new int[numberOfStudents][numberOfSubjects];

                    System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>");
                    System.out.println("Saved successfully");

                    for (int student = 0; student < numberOfStudents; student++) {
                        for (int subject = 0; subject < numberOfSubjects; subject++) {
                            int score = -1;
                            while (score < 0 || score > 100) {
                                System.out.println("Entering score for student " + (student + 1));
                                System.out.print("Enter score for subject " + (subject + 1) + ": ");
                                score = input.nextInt();

                                if (score < 0 || score > 100) {
                                    System.out.println("Invalid score! Score must be between 0 and 100.");
                                }
                            }
                            scores[student][subject] = score;
                            System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>");
                            System.out.println("Saved successfully");
                        }
                    }
                    break;

                case 2:
                    if (scores == null) {
                        System.out.println("No scores entered yet! Please choose Option 1 first.");
                        break;
                    }

                    int passMark = 50;

                    System.out.println("\n========================================================");
                    System.out.print("STUDENT\t");
                    for (int sub = 0; sub < numberOfSubjects; sub++) {
                        System.out.print("SUB" + (sub + 1) + "\t");
                    }
                    System.out.println("TOT\tAVE\tPOS");
                    System.out.println("========================================================");

                    int[] totals = new int[numberOfStudents];
                    for (int count = 0; count < numberOfStudents; count++) {
                        totals[count] = StudentGrade.calculateTotal(scores[count]);
                    }

                    for (int student = 0; student < numberOfStudents; student++) {
                        int total = totals[student];
                        double average = StudentGrade.calculateAverage(scores[student]);

                        int position = 1;
                        for (int other = 0; other < numberOfStudents; other++) {
                            if (totals[other] > total) {
                                position++;
                            }
                        }

                        System.out.print("Student " + (student + 1) + "\t");
                        for (int sub = 0; sub < numberOfSubjects; sub++) {
                            System.out.print(scores[student][sub] + "\t");
                        }
                        System.out.printf("%d\t%.2f\t%d\n", total, average, position);
                    }

                    System.out.println("\nSUBJECT SUMMARY");
                    for (int sub = 0; sub < numberOfSubjects; sub++) {
                        System.out.println("Subject " + (sub + 1));
                        int highStudent = StudentGrade.getHighestScoringStudentForSubject(scores, sub);
                        int lowStudent = StudentGrade.getLowestScoringStudentForSubject(scores, sub);
                        int subjTotal = StudentGrade.calculateSubjectTotal(scores, sub);
                        double subjAvg = StudentGrade.calculateSubjectAverage(scores, sub);
                        int passes = StudentGrade.countPasses(scores, sub, passMark);
                        int fails = StudentGrade.countFails(scores, sub, passMark);

                        System.out.println("Highest scoring student is: Student " + (highStudent + 1) + " scoring " + scores[highStudent][sub]);
                        System.out.println("Lowest scoring student is: Student " + (lowStudent + 1) + " scoring " + scores[lowStudent][sub]);
                        System.out.println("Total Score is: " + subjTotal);
                        System.out.printf("Average score is: %.2f\n", subjAvg);
                        System.out.println("Number of passes: " + passes);
                        System.out.println("Number of Fails: " + fails);
                        System.out.println();
                    }

                    int classTotal = StudentGrade.calculateClassTotal(scores);
                    double classAverage = StudentGrade.calculateClassAverage(scores);

                    int bestStudent = 0;
                    int worstStudent = 0;
                    for (int s = 1; s < numberOfStudents; s++) {
                        if (totals[s] > totals[bestStudent]) bestStudent = s;
                        if (totals[s] < totals[worstStudent]) worstStudent = s;
                    }

                    System.out.println("CLASS SUMMARY");
                    System.out.println("====================================================");
                    System.out.println("Best Graduating Student is: Student " + (bestStudent + 1) + " scoring " + totals[bestStudent]);
                    System.out.println("====================================================");
                    System.out.println("Worst Graduating Student is: Student " + (worstStudent + 1) + " scoring " + totals[worstStudent]);
                    System.out.println("Class total score is: " + classTotal);
                    System.out.printf("Class Average score is: %.1f\n", classAverage);
                    System.out.println("====================================================");
                    break;

                case 3:
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("Invalid option. Please enter 1, 2, or 3.");
                    break;
            }
        }
    }
}
