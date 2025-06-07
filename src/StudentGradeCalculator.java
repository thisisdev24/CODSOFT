import java.util.Scanner;

public class StudentGradeCalculator {

    private int math, physx, chem, english, hindi;

    void marksInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter marks obtained (out of 100) in each subject.");
        System.out.print("Mathematics: ");
        math = sc.nextInt();
        System.out.print("\n\nPhysics: ");
        physx = sc.nextInt();
        System.out.print("\n\nChemistry: ");
        chem = sc.nextInt();
        System.out.print("\n\nEnglish: ");
        english = sc.nextInt();
        System.out.print("\n\nHindi: ");
        hindi = sc.nextInt();
    }


}
