

public class StudentGrade {

    public static int calculateTotal(int[] scores) {
        int total = 0;
        for (int count = 0; count < scores.length; count++) {
            total += scores[count];
        }
        return total;
    }

    public static double calculateAverage(int[] scores) {
        if (scores.length == 0) return 0.0;
        int total = calculateTotal(scores);
        return (double) total / scores.length;
    }

    public static int calculateSubjectTotal(int[][] scores, int subjectIndex) {
        int total = 0;
        for (int count = 0; count < scores.length; count++) {
            total += scores[count][subjectIndex];
        }
        return total;
    }

    public static double calculateSubjectAverage(int[][] scores, int subjectIndex) {
        if (scores.length == 0) return 0.0;
        int total = calculateSubjectTotal(scores, subjectIndex);
        return (double) total / scores.length;
    }

    public static int countPasses(int[][] scores, int subjectIndex, int passMark) {
        int passCount = 0;
        for (int count = 0; count < scores.length; count++) {
            if (scores[count][subjectIndex] >= passMark) {
                passCount++;
            }
        }
        return passCount;
    }

    public static int countFails(int[][] scores, int subjectIndex, int passMark) {
        int failCount = 0;
        for (int count = 0; count < scores.length; count++) {
            if (scores[count][subjectIndex] < passMark) {
                failCount++;
            }
        }
        return failCount;
    }

    public static int getHighestScoringStudentForSubject(int[][] scores, int subjectIndex) {
        int highestStudentIndex = 0;
        for (int count = 1; count < scores.length; count++) {
            if (scores[count][subjectIndex] > scores[highestStudentIndex][subjectIndex]) {
                highestStudentIndex = count;
            }
        }
        return highestStudentIndex;
    }

    public static int getLowestScoringStudentForSubject(int[][] scores, int subjectIndex) {
        int lowestStudentIndex = 0;
        for (int count = 1; count < scores.length; count++) {
            if (scores[count][subjectIndex] < scores[lowestStudentIndex][subjectIndex]) {
                lowestStudentIndex = count;
            }
        }
        return lowestStudentIndex;
    }

    public static int calculateClassTotal(int[][] scores) {
        int total = 0;
        for (int student = 0; student < scores.length; student++) {
            for (int subject = 0; subject < scores[student].length; subject++) {
                total += scores[student][subject];
            }
        }
        return total;
    }

    public static double calculateClassAverage(int[][] scores) {
        if (scores.length == 0) return 0.0;
        int total = calculateClassTotal(scores);
        return (double) total / scores.length;
    }
}
