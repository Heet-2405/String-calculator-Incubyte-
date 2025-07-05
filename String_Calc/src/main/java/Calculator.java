public class Calculator {
    public int Add(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(str);
    }

}
