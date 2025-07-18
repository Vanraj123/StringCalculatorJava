import java.util.Scanner;

public class StringCalculatorApp {
    public static void main(String[] args) {
    StringCalculator calculator = new StringCalculator();

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter numbers string:");
    String input = scanner.nextLine();

    // replace literal \n (from typing) with actual newline
    input = input.replace("\\n", "\n");

    try {
        int result = calculator.add(input);
        System.out.println("Sum: " + result);
    } catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
    }

    scanner.close();
}

}
