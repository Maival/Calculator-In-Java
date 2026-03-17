
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Simple Calculator : ");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice;

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice! Please select between 1 and 5.");
                continue;
            }

            if (choice == 5) {
                System.out.println("Thank you for using the Calculator!");
                break;
            }

            double num1, num2;

            try {
                System.out.print("Enter first number: ");
                num1 = scanner.nextDouble();

                System.out.print("Enter second number: ");
                num2 = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid number entered.");
                scanner.next();
                continue;
            }

            performCalculation(choice, num1, num2);

            System.out.print("\nDo you want to perform another calculation? (yes/no): ");
            String answer = scanner.next().toLowerCase();

            if (answer.equals("no")) {
                System.out.println("Thank you for using the Calculator. Goodbye!");
                break;
            }
        }

        scanner.close();
    }

    public static void performCalculation(int choice, double a, double b) {

        switch (choice) {

            case 1:
                System.out.println("Result: " + (a + b));
                break;

            case 2:
                System.out.println("Result: " + (a - b));
                break;

            case 3:
                System.out.println("Result: " + (a * b));
                break;

            case 4:
                if (b == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                } else {
                    System.out.println("Result: " + (a / b));
                }
                break;
        }
    }
}