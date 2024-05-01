import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",";
        if (numbers.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(numbers);
            if (matcher.matches()) {
                delimiter = matcher.group(1);
                numbers = matcher.group(2);
            }
        }

        String[] nums = numbers.split("[\n" + delimiter + "]");
        int sum = 0;
        StringBuilder negatives = new StringBuilder();
        for (String num : nums) {
            int n = Integer.parseInt(num);
            if (n < 0) {
                if (negatives.length() > 0) {
                    negatives.append(", ");
                }
                negatives.append(n);
            }
            sum += n;
        }

        if (negatives.length() > 0) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negatives);
        }

        return sum;
    }

    public static void main(String[] args) {
        String input = args.length > 0 ? args[0] : "1,2,3";
        try {
            int result = add(input);
            System.out.println("The sum is: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}