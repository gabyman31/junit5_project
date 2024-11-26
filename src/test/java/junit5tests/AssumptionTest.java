package junit5tests;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AssumptionTest {

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1,5,6})
    void intValues(int theParam) {
        Assumptions.assumeTrue(theParam > 4);
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve, roger", "captain, marvel", "john, legend"})
    void csvSource_StringString(String param1, String param2) {
        Assumptions.assumeFalse(param1.equals("steve"), "The assumption failed");
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"Steve,32,true", "captain, 21,false", "poky,5,true"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3){
       Assumptions.assumingThat(param2 > 20, () -> System.out.println("This is a code ran"));
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }
}
