import java.util.*;
import java.util.regex.*;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiter = "[,\n]";  // default delimiters

        // Check for custom delimiter
        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf('\n');
            String customDelimiterPart = numbers.substring(2, delimiterEndIndex);
            numbers = numbers.substring(delimiterEndIndex + 1);

            if (customDelimiterPart.startsWith("[") && customDelimiterPart.endsWith("]")) {
                // Multi-character delimiter
                String customDelimiter = customDelimiterPart.substring(1, customDelimiterPart.length() - 1);
                delimiter = Pattern.quote(customDelimiter);
            } else {
                // Single-character delimiter
                delimiter = Pattern.quote(customDelimiterPart);
            }
        }

        String[] tokens = numbers.split(delimiter);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String token : tokens) {
            int num = Integer.parseInt(token.trim());
            if (num < 0) {
                negatives.add(num);
            } else if (num <= 1000) {
                sum += num;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException(
                "negative numbers not allowed: " + negatives.toString().replaceAll("[\\[\\]]", "")
            );
        }

        return sum;
    }
}
