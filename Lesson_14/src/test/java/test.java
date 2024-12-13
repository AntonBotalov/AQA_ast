import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class test {
    @Test
    @DisplayName("Проверка n = 5")
    void test1() {
        assertEquals((Factorial.factorial(5)), 120);
    }

    @ParameterizedTest
    @CsvSource({"1, 1", "2, 2", "3, 6"})
    void test2(int first, int second) {
        assertEquals(Factorial.factorial(first),second);
    }

}
