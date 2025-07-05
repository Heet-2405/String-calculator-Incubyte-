import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Calculator {
    public int Add(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        if (str.startsWith("//")) {
            int index = str.indexOf("\n");
            String custom = str.substring(2, index);
            delimiter = Pattern.quote(custom);
            str = str.substring(index + 1);
        }

        int sum = 0;
        String[] numbers = str.split(delimiter);

        List<Integer> negatives = new ArrayList<>();
        for (String num : numbers) {
            int n = Integer.parseInt(num.trim());
            if (n < 0) negatives.add(n);
            else sum += n;
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + negatives);
        }


        for (String num : numbers) {
            sum += Integer.parseInt(num.trim());
        }
        return sum;
    }

}
