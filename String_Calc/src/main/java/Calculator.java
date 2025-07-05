import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private int callCount = 0;

    public int Add(String str) {
        callCount++;
        if (str == null || str.isEmpty()) {
            return 0;
        }


        String delimiter = ",|\n";
        if (str.startsWith("//")) {
            int index = str.indexOf("\n");
            String custom = str.substring(2, index);
            str = str.substring(index + 1);
            if (custom.startsWith("[")) {
                Matcher m = Pattern.compile("\\[(.*?)]").matcher(custom);
                List<String> delims = new ArrayList<>();
                while (m.find()) {
                    delims.add(Pattern.quote(m.group(1)));
                }
                delimiter = String.join("|", delims);
            } else {
                delimiter = Pattern.quote(custom);
            }
        }


        int sum = 0;
        String[] numbers = str.split(delimiter);

        List<Integer> negatives = new ArrayList<>();
        for (String num : numbers) {
            if (!num.trim().isEmpty()) {
                int n = Integer.parseInt(num.trim());
                if (n < 0) {
                    negatives.add(n);
                } else if (n <= 1000) {
                    sum += n;
                }
            }
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + negatives);
        }

        return sum;
    }

    public int GetCalledCount() {
        return callCount;
    }
}
