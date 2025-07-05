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
        String customDelimiter = numbers.substring(2, delimiterEndIndex);
        delimiter = Pattern.quote(customDelimiter);
        numbers = numbers.substring(delimiterEndIndex + 1);
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
