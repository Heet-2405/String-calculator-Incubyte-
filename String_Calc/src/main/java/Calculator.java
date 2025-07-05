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
        String[] numbers = str.split(delimiter);
        int sum = 0;
        for (String num : numbers) {
            sum += Integer.parseInt(num.trim());
        }
        return sum;
    }

}
