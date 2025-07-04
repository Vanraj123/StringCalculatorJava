public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) { // for the empty or NULL string 
            return 0;
        }

        String[] tokens = numbers.split(","); // seperate the number with comma
        int sum = 0;

        for (String token : tokens) {               // sum of number 
            sum += Integer.parseInt(token.trim());
        }

        return sum;
    }
}
