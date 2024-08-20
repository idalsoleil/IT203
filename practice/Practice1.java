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

    /*
    public static void getStrings(String[] cName) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Country: ");
        cName[0] = sc.nextLine();

        System.out.print("Enter Name: ");
        cName[1] = sc.nextLine();
    }

    public static void getDoubles(Double[] rate) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Rate: ");
        rate[0] = sc.nextDouble();

        
    }

    public static void getInt(int[] population) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Country's Population: ");
        population[0] = sc.nextInt();
    }

    public static void main(String[] args) {

        // Using array to pass arguments to method
        String [] cName = new String[2]; 
        Double [] rate = new Double[1];
        int [] population = new int[1];

        // Calling methods
        getStrings(cName);
        getDoubles(rate);
        getInt(population);

        // Output
        System.out.println("Good morning " + cName[0] + "! It's so nice to be home again...\nIn this wonderful island with " + population[0] + " million people. And still growing at " + rate[0] + " percent per year.\nI will be staying here for good -- love " + cName[1]);
    }
    */
}