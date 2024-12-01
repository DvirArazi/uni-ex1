import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v, 11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v, 2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v, v2);
        assertTrue(Ex1.equals(s10, s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = { "1", "1b2", "01b2", "123bA", "ABbG", "0bA" };
        for (int i = 0; i < good.length; i = i + 1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = { "b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2" };
        for (int i = 0; i < not_good.length; i = i + 1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }

    @Test
    void maxIndexTest() {
        assertEquals(2, Ex1.maxIndex(new String[] { "123bA", "100101b2", "1E3bG" }));
        assertEquals(1, Ex1.maxIndex(new String[] { "123bB", "5DD3bE", "101101b2" }));
    }

    @Test
    void isNumberTest() {
        assertEquals(true, Ex1.isNumber("13EbG"));
        assertEquals(false, Ex1.isNumber("13EbD"));
        assertEquals(false, Ex1.isNumber("13EbE"));
        assertEquals(false, Ex1.isNumber("1#EbE"));
    }

    @Test
    void int2NumberTest() {
        assertEquals(123, Ex1.number2Int("123bA"));
        assertEquals(123, Ex1.number2Int("123"));
        assertEquals(37, Ex1.number2Int("100101b2"));
        assertEquals(483, Ex1.number2Int("1E3bG"));
        assertEquals(14, Ex1.number2Int("10bE"));
    }

    @Test
    void number2IntTest() {
        assertEquals(Ex1.int2Number(5, 2), "101b2");
        assertEquals(Ex1.int2Number(22020, 14), "804CbE");
        assertEquals(Ex1.int2Number(14440300, 9), "30148327b9");
    }

    @Test
    void equalsTest() {
        assertEquals(true, Ex1.equals("101b2", "5"));
        assertEquals(true, Ex1.equals("112b3", "10bE"));
    }

    // Add additional test functions - test as much as you can.
}
