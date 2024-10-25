import java.util.Scanner;

public class StudentGPA {
    public static void main(String args[]) {
        Scanner console = new Scanner(System.in);
        
        // Variables to hold total points and total credits
        double totalPoints = 0;
        double totalCredits = 0;

        // Loop to calculate GPA for 4 classes
        for (int i = 1; i <= 4; i++) {
            System.out.println("Please enter the number of credits for class " + i + " (A number):");
            double credits = console.nextDouble();
            console.nextLine();  // Consume the newline character
            
            System.out.println("Please enter your grades for class " + i + " (Capital letters such as A, B+, C-):");
            String grade = console.nextLine();
            
            // Calculate total points for the class
            double gradeValue = getGradeValue(grade);
            if (gradeValue != -1) { // If grade is valid
                totalPoints += gradeValue * credits;
                totalCredits += credits;
            } else {
                System.out.println("Invalid grade entered for class " + i + ". Please try again.");
                i--; // Decrement i to repeat the iteration for the same class
            }
        }

        // Calculate GPA
        double gpa = totalPoints / totalCredits;

        // Display the result
        System.out.printf("Your GPA is: %.2f\n", gpa);
        
        console.close(); // Close the scanner
    }

    // Method to convert letter grades to grade points
    public static double getGradeValue(String grade) {
        switch (grade) {
            case "A":
                return 4.00;
            case "A-":
                return 3.67;
            case "B+":
                return 3.33;
            case "B":
                return 3.00;
            case "B-":
                return 2.67;
            case "C+":
                return 2.33;
            case "C":
                return 2.00;
            case "D+":
                return 1.33;
            case "D":
                return 1.00;
            case "F":
            case "FX":
                return 0.00;
            default:
                return -1; // Invalid grade
        }
    }
}
