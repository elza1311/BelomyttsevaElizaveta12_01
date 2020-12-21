import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerDecodeTests {
    @Test
    void whenZeroLen_thenNFE() {
        Throwable thrown = assertThrows(NumberFormatException.class, () -> Integer.decode(""));
        assertEquals("Zero length string", thrown.getMessage());
    }

    @Test
    void whenMinus_thenNegativeNumber() {
        if (Integer.decode("-1000") >= 0)
            fail();
    }

    @Test
    void whenPlus_thenNotNegativeNumber() {
        if (Integer.decode("+1000") < 0) {
            fail();
        }
    }

    @Test
    void whenFewMinus_thenNFE() {
        Throwable thrown = assertThrows(NumberFormatException.class, () -> Integer.decode("++++100"));
        assertEquals("Sign character in wrong position", thrown.getMessage());
    }

    @Test
    void whenHex0x_thenCorrectNumber() {
        assertEquals(65188, Integer.decode("0x00FEA4"));
    }

    @Test
    void whenHexHash_thenCorrectNumber() {
        assertEquals(65188, Integer.decode("#00FEA4"));
    }

    @Test
    void whenOct_thenCorrectNumber() {
        assertEquals(42579, Integer.decode("0123123"));
    }

    @Test
    void whenNotNumber_thenNFE() {
        Throwable thrown = assertThrows(NumberFormatException.class, () -> Integer.decode("ITSNOTNUMBER"));
    }
}
