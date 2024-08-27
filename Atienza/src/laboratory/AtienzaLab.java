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

public class AtienzaLab {
    public static void getString(String[] str) {
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < 2 ; i++) {
            System.out.println("Enter a string: ");
            str[i] = sc.nextLine();
        }
    }
    
    public static void getChar(char[] chr) {
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < 2 ; i++) {
            System.out.println("Enter a character: ");
            chr[i] = sc.next().charAt(0);
        }
    }
    
    public static void getInt(int[] num) {
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < 2 ; i++) {
            System.out.println("Enter a number: ");
            num[i] = sc.nextInt();
        }
    }
    
    public static void getDouble(double[] deci) {
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < 2 ; i++) {
            System.out.println("Enter a decimal number: ");
            deci[i] = sc.nextDouble();
        }
    }
    
    public static void main(String[] args) {
        String[] str = new String[2];
        char[] chr = new char[2];
        int[] num = new int[2];
        double[] deci = new double[2];
        
        getString(str);
        getChar(chr);
        getInt(num);
        getDouble(deci);
        
        double first = num[0] + deci[0];
        double second = num[1] + deci[1];
        
        System.out.println(str[0] + chr[0] + "   |   " + str[1] + chr[1] + "\n" + first + "   |   " + second);
    }
}
