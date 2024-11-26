package junit5tests;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParametrizedTests {
    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1,5,6})
    void intValues(int theParam) {
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"firstString", "secondString"})
    void stringValues(String theParam) {
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve, roger", "captain, marvel", "john, legend"})
    void csvSource_StringString(String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"Steve,32,true", "captain, 21,false", "poky,5,true"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3){
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }

    @ParameterizedTest
    @CsvSource(value = {"captain america,'steve,rogers'", "winter soildier"+"'buccky,barnes'"})
    void csvSource_StringWithComa(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }
    @ParameterizedTest
    @CsvSource(value = {"steve?rogers", "bucky?barnes"}, delimiter = '?')
    void csvSource_StringWithDiffDelimiter(String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/params/shoppinglist3.csv", numLinesToSkip = 1, delimiterString = "__")
    void csvFileSource_StringDoubleIntStringString(String name, Double price, int quantity, String unit, String provider) {
        System.out.println("name = " + name + ", price = " + price + ", quantity = " + quantity + ", unit = " + unit + ", provider = " + provider);

    }

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/shopping.csv","src/test/resources/params/shoppingfirst2.csv"}, numLinesToSkip = 1)
    void csvFileSource_StringDoubleIntStringStringSpecifiedDelimiter(String name, Double price, int quantity, String unit, String provider) {
        System.out.println("name = " + name + ", price = " + price + ", quantity = " + quantity + ", unit = " + unit + ", provider = " + provider);

    }

    @ParameterizedTest
    @MethodSource(value = "sourceStringasStream")
    void methodSource_StringStream(String param1) {
        System.out.println("param1 = " + param1);

    }

    @ParameterizedTest
    @MethodSource(value = "sourceString")
    void methodSource_String(String param1) {
        System.out.println("param1 = " + param1);

    }
// calling a static method from a different class as a Source Value
    @ParameterizedTest
    @MethodSource(value = "junit5tests.ParamProvider#sourceList_ArgumentsStream")
        void methodSource_StringDoubleStreamArgs(String param1, Double param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceList_Arguments")
    void methodSource_StringDoubleList(String param1, Double param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    List<String> sourceString() {
        //processing done here
    return Arrays.asList("tomato", "carrot", "cabbage");
    }

    Stream<String> sourceStringasStream() {
        //processing done here
        return Stream.of("pear", "apple", "garlic");
    }

    List<Arguments> sourceList_Arguments(){
        //processing
        return Arrays.asList(arguments("tomato", 2.0), arguments("carrot", 4.5), arguments("cabbage",7.8));
    }


}
