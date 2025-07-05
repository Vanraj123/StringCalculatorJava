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
                // one or more delimiters
                List<String> delimiters = new ArrayList<>();
                Matcher m = Pattern.compile("\\[(.*?)]").matcher(customDelimiterPart);
                while (m.find()) {
                    delimiters.add(Pattern.quote(m.group(1)));
                }
                delimiter = String.join("|", delimiters);
            } else {
                // Single-character delimiter without brackets
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
