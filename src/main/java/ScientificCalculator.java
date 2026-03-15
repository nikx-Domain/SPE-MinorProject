import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.InputMismatchException;

public class ScientificCalculator {

    private static final Logger logger = Logger.getLogger("CalculatorLog");

    public static void main(String[] args) {

        try {
            FileHandler fh = new FileHandler("calculator.log", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        } catch (Exception e) {
            System.out.println("Logging setup failed.");
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n---- Scientific Calculator ----");
            System.out.println("1. Square Root (√x)");
            System.out.println("2. Factorial (x!)");
            System.out.println("3. Natural Log (ln x)");
            System.out.println("4. Power (x^b)");
            System.out.println("5. Exit");

            try {

                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();

                if (choice == 5) {
                    logger.info("Application exited");
                    System.out.println("Goodbye.");
                    break;
                }

                System.out.print("Enter number: ");
                double x = scanner.nextDouble();

                double result;

                switch (choice) {

                    case 1: // Square Root
                        if (x < 0) {
                            System.out.println("Error: Square root of negative number not allowed.");
                            logger.warning("Invalid sqrt input: " + x);
                            break;
                        }
                        result = Math.sqrt(x);
                        System.out.println("Result: " + result);
                        logger.info("sqrt(" + x + ") = " + result);
                        break;

                    case 2: // Factorial
                        if (x < 0 || x != Math.floor(x)) {
                            System.out.println("Error: Factorial only defined for non-negative integers.");
                            logger.warning("Invalid factorial input: " + x);
                            break;
                        }
                        result = factorial((int) x);
                        System.out.println("Result: " + result);
                        logger.info(x + "! = " + result);
                        break;

                    case 3: // Natural Log
                        if (x <= 0) {
                            System.out.println("Error: Log undefined for zero or negative numbers.");
                            logger.warning("Invalid log input: " + x);
                            break;
                        }
                        result = Math.log(x);
                        System.out.println("Result: " + result);
                        logger.info("ln(" + x + ") = " + result);
                        break;

                    case 4: // Power
                        System.out.print("Enter exponent: ");
                        double b = scanner.nextDouble();

                        if (x < 0 && b != Math.floor(b)) {
                            System.out.println("Error: Negative base with fractional exponent is invalid.");
                            logger.warning("Invalid power operation: " + x + "^" + b);
                            break;
                        }

                        result = Math.pow(x, b);
                        System.out.println("Result: " + result);
                        logger.info(x + "^" + b + " = " + result);
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numeric values.");
                logger.warning("Non-numeric input entered.");
                scanner.nextLine(); // clear buffer
            }
        }

        scanner.close();
    }

    public static long factorial(int n) {

        if (n > 20) {
            System.out.println("Warning: result may overflow.");
        }

        long result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}
