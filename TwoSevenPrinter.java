import java.util.stream.IntStream;

public class TwoSevenPrinter {

    public static void print() {
        IntStream.rangeClosed(1, 100).mapToObj(TwoSevenPrinter::convertToString).forEach(System.out::println);
    }

    private static String convertToString(int i) {
        if (i % 2 == 0) {
            if (i % 7 == 0) {
                return "TwoSeven";
            }
            return "Two";
        } else if (i % 7 == 0) {
            return "Seven";
        }
        return String.valueOf(i);
    }
}
