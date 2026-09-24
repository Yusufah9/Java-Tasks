public class StudentClass {
    private String name;
    private int gradeLevel;

    public StudentClass(String name, int gradeLevel) {
        this.name = name;
        
        if (gradeLevel < 1) {
            this.gradeLevel = 1;
        } else if (gradeLevel > 12) {
            this.gradeLevel = 12;
        } else {
            this.gradeLevel = gradeLevel;
        }
    }

    public String getName() {
        return name;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public String introduce() {
        return "Hello, my name is " + name + " and I am in grade " + gradeLevel + ".";
    }

    public void promote() {
        if (gradeLevel < 12) {
            gradeLevel++;
        }
    }

    public boolean hasPassed(double score) {
        return score >= 50.0;
    }

    public void updateName(String newName) {
        this.name = newName;
    }

    public boolean isGraduating() {
        return gradeLevel == 12;
    }
}
