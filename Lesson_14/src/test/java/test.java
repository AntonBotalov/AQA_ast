import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class test {
    @DataProvider
    public static Object[][] parserLocaleData() {
        return new Object[][]{
                {1,1},
                {2,2},
                {3,6}
        };
    }

    @Test
    void test1() {
        assertEquals((Factorial.factorial(5)), 120);
    }

    @Test(dataProvider = "parserLocaleData")
    void test2(int first, int second) {
        assertEquals(Factorial.factorial(first),second);
    }

}
