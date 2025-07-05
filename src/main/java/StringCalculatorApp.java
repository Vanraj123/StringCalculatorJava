import java.util.Scanner;

public class StringCalculatorApp {
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers string:");
        String input = scanner.nextLine();

        try {
            int result = calculator.add(input);
            System.out.println("Sum: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
