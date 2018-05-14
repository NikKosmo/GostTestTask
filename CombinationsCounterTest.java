import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombinationsCounterTest {

    @Test
    void count() {
        assertEquals(1,CombinationsCounter.count(0,0));
        assertEquals(1,CombinationsCounter.count(10,10));
        assertEquals(4,CombinationsCounter.count(4,1));
        assertEquals(35,CombinationsCounter.count(7,3));
        assertEquals(1365,CombinationsCounter.count(15,4));
        assertEquals(2598960,CombinationsCounter.count(52,5));
    }
}