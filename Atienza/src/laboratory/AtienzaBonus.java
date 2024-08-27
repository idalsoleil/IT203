/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratory;
import java.util.Scanner;

/**
 *
 * @author huawei
 */
public class AtienzaBonus {
    
    public static void getSubCode(String[] subcode) {
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0 ; i < 5 ; i++) {
            System.out.println("Enter subject code: ");
            subcode[i] = sc.nextLine();
        }
    }
    
    public static void getGrades(int[] grades) {
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0 ; i < 5 ; i++) {
            System.out.println("Enter grade: ");
            grades[i] = sc.nextInt();
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] subcode = new String[5];
        int[] grades = new int[5];
        int highestGrade = 0;
        int lowestGrade = 0;
        int highestIndex = 0;
        int lowestIndex = 0;
        int sum = 0;
        
        getSubCode(subcode);
        getGrades(grades);
        
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        
        for (int i = 0 ; i < 5 ; i++) {
            if (grades[i] > highestGrade) {
                highestGrade = grades[i];
                highestIndex = i;
            } else {
                lowestGrade = grades[i];
                lowestIndex = i;
            }
            sum += grades[i];
        }
        
        double average = sum / 5;
        
        System.out.println("===================================");
        System.out.println("STUDENT NAME: " + name);
        System.out.println("AVERAGE: " + average);
        System.out.println("HIGHEST GRADE: " + highestGrade + " SUBCODE: " + subcode[highestIndex]);
        System.out.println("LOWEST GRADE: " + lowestGrade + " SUBCODE: " + subcode[lowestIndex]);
        System.out.println("===================================");
    }
}
