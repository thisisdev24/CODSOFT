import java.util.Scanner;

public class StudentGradeCalculator {

    private int n_subs;
    private int math, physx, chem, english, hindi;

    StudentGradeCalculator() {
        math = physx = chem = english = hindi = 0;
        n_subs = 5;
    }

    void marksInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter marks obtained (out of 100) in each subject.");
        System.out.print("Mathematics: ");
        math = sc.nextInt();
        System.out.print("\nPhysics: ");
        physx = sc.nextInt();
        System.out.print("\nChemistry: ");
        chem = sc.nextInt();
        System.out.print("\nEnglish: ");
        english = sc.nextInt();
        System.out.print("\nHindi: ");
        hindi = sc.nextInt();
    }

    int total() {
        return math + physx + chem + english + hindi;
    }

    float avgPercentage() {
        return (float) total() / n_subs;
    }

    String gradeAssignment(float percentage) {
        if(percentage >= 85.00) {
            return "A";
        } else if (percentage >= 75.00 && percentage < 85.00) {
            return "B";
        } else if (percentage >= 65.00 && percentage < 75.00) {
            return "C";
        } else if (percentage >= 55.00 && percentage < 65.00) {
            return "D";
        } else if (percentage >= 45.00 && percentage < 55.00) {
            return "E";
        } else {
            return "F";
        }
    }

    public static void main(String... args) {
        StudentGradeCalculator sgc = new StudentGradeCalculator();
        sgc.marksInput();
        System.out.println("\nTotal Marks obtained: " + sgc.total());
        float percentage = sgc.avgPercentage();
        System.out.println("\nAverage Percentage: " + percentage);
        System.out.println("\nYour grade: " + sgc.gradeAssignment(percentage));
    }
}
