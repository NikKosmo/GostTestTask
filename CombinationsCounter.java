import java.math.BigInteger;
import java.util.stream.IntStream;

public class CombinationsCounter {

    public static long count(int m, int r) {
        if (m == r ) {
            return 1;
        }
        //overflow can occur very quickly
        BigInteger top = IntStream.rangeClosed(r+1, m).mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get();
        BigInteger bottom = IntStream.rangeClosed(1, m - r).mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get();
        return top.divide(bottom).longValue();
    }
}
