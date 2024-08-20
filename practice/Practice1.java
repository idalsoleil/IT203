import java.util.Scanner;

class Practice1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Country: ");
        String country = scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Rate: ");
        double rate = scanner.nextDouble();

        System.out.print("Enter Population: ");
        double population = scanner.nextDouble();

        System.out.println("Good morning " + country + "!" + " It's so nice to be home again... In this wonderful island with " + population + " million people. And still growing at " + rate + " percent per year. I will be staying here for good - love " + name);

        scanner.close();
    }
}