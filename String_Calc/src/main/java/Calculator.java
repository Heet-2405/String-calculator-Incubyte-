public class Calculator {
    public int Add(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        String[] numbers = str.split(",|\n");
        int sum = 0;
        for (String num : numbers) {
            sum += Integer.parseInt(num.trim());
        }
        return sum;
    }

}
