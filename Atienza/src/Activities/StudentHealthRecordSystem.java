package Activities;
import java.util.Scanner;

public class StudentHealthRecordSystem {
    public static void main (String[] args) {
        HealthRecord hr = new HealthRecord();
        Scanner sc = new Scanner(System.in);
        
        String decision = "Yes";
        
        while (decision.equalsIgnoreCase("Yes")) {
            System.out.println("\n=======================================");
            System.out.println("Welcome to Student Health Record System!");
            System.out.println("=======================================");
            System.out.println();
            
            System.out.print("Enter student's name:       ");
            String studentName = sc.nextLine();
            hr.setStudentName(studentName);
            
            System.out.print("Enter student's blood type (O, A, B, AB):       ");
            String bloodType = sc.nextLine();
            hr.setBloodType(bloodType);
            
            System.out.print("Enter student's Rh factor (+ or -):       ");
            String rhFactor = sc.nextLine();
            hr.setRhFactor(rhFactor);
            
            System.out.println();
            System.out.println("=======================================");
            System.out.println();
            
            hr.displayInfo();
            
            System.out.println();
            System.out.println("=======================================");
            System.out.println();
            
            while (true) {
                System.out.print("Do you want to enter another student's health record? (Yes / No): ");
                decision = sc.nextLine();
                
                if (decision.equalsIgnoreCase("Yes") || decision.equalsIgnoreCase("No")) break; 
                else System.out.println("Invalid input! Please enter 'Yes' or 'No'.\n");
            }

            if (decision.equalsIgnoreCase("No")) System.out.println("Thank you for using this program.");
        }
    }
}