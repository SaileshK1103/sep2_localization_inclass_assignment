import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Calculator {
    public double addMe(double a,double b) {
        return (a + b);

    }

    public double subMe(double a,double b) {
        return (a - b);

    }
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nSelect a language (or 0 to Quit):");
            System.out.println("1. English");
            System.out.println("2. Finnish");
            System.out.println("3. Vietnam");
            System.out.println("0. Exit");

            int choice = input.nextInt();
            Locale locale;

            if (choice == 0) {
                running = false;
                System.out.println("Exiting...");
                break;
            }

            switch (choice) {
                case 1:
                    locale = new Locale("en", "US");
                    break;
                case 2:
                    locale = new Locale("fi", "FI");
                    break;
                case 3:
                    locale = new Locale("vn", "VN");
                    break;
                default:
                    locale = new Locale("en", "US");
            }

            ResourceBundle rb = ResourceBundle.getBundle("MessageBundle", locale);

            System.out.println(rb.getString("wish"));
            System.out.println(rb.getString("prompt1"));
            double a = input.nextDouble();

            System.out.println(rb.getString("prompt2"));
            double b = input.nextDouble();

            double sum = calc.addMe(a, b);
            double sub = calc.subMe(a, b);

            System.out.println(rb.getString("prompt3") + " " + sum);
            System.out.println(rb.getString("prompt4") + " " + sub);
        }
        input.close();
    }
}
