import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class ScientificCalculator {
    private static final Logger logger = Logger.getLogger("CalculatorLog");

    public static void main(String[] args) {
        try {
            FileHandler fh = new FileHandler("calculator.log", true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Square Root (√x)\n2. Factorial (x!)\n3. Natural Log (ln(x))\n4. Power (x^b)\n5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            
            if (choice == 5) {
                logger.info("Application exited");
                break;
            }

            System.out.print("Enter number: ");
            double x = scanner.nextDouble();
            double result = 0;

            switch (choice) {
                case 1:
                    result = Math.sqrt(x);
                    logger.info("Square Root operation requested. Input: " + x + ", Result: " + result);
                    break;
                case 2:
                    result = factorial((int)x);
                    logger.info("Factorial operation requested. Input: " + x + ", Result: " + result);
                    break;
                case 3:
                    result = Math.log(x);
                    logger.info("Natural Log operation requested. Input: " + x + ", Result: " + result);
                    break;
                case 4:
                    System.out.print("Enter exponent: ");
                    double b = scanner.nextDouble();
                    result = Math.pow(x, b);
                    logger.info("Power operation requested. Base: " + x + ", Exponent: " + b + ", Result: " + result);
                    break;
                default:
                    System.out.println("Invalid choice");
                    continue;
            }
            System.out.println("Result: " + result);
        }
        scanner.close();
    }

    public static double factorial(int n) {
        if (n < 0) return -1;
        double res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }
}
