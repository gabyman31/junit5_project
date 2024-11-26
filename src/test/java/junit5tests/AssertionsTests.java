package junit5tests;

import listeners.Listener;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionContaining.hasItem;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(Listener.class)
public class AssertionsTests {
    @Test
    void assertEqualTest() {
        assertEquals("firstString","secondString","The string is not matching:");
    }

    @Test
    void assertEqualsTest() {
        List<String> expectedValues = Arrays.asList("firstString", "secondString", "thirdtring");
        List<String> actualValues = Arrays.asList("firstString", "secondString", "thirdtring");
         assertEquals(expectedValues, actualValues);

    }
@Test
    void assertArraysEqualsTest() {
        int[] expectedValues = {1,2,3};
        int[] actualValues = {1,2,3};
        assertArrayEquals(expectedValues, actualValues);
    }

    @Test
    void assertTrueFalse() {
        assertFalse(false);
        assertTrue(false, "This boolean condition dis not match");
    }

    @Test
    void assertThrowsTest() {
        assertThrows(NullPointerException.class, null);
    }

    @Test
    void assertAllTest() {
        assertAll(
                () -> assertEquals("firstString", "secondString", "The String " +
                "values were not equal"),
                () -> assertThrows(NullPointerException.class, null),
                () -> assertTrue(false, "This boolean condition did not evaluate to true"));
    }

@Test
void assertForMapTest() {
    Map<String, Integer> theMap = new HashMap<>();
    theMap.put("firstKey", 1);
    theMap.put("secondKey", 2);
    theMap.put("thirdKey", 3);

    assertThat(theMap, Matchers.hasKey("secondKey"));

}

    @Test
    void assertForList() {
        List<String> theList = Arrays.asList("firstString", "secondString",
                "thirdString");

        assertThat(theList, Matchers.hasItem("thirdStrings"));
    }

    @Test
    void assertForAnyOf() {
        List<String> theList = Arrays.asList("firstString", "secondString",
                "thirdString");

        assertThat(theList, Matchers.anyOf(hasItem("thirdString"),
                Matchers.hasItem("noString")));
    }
     @Test
        void assertForContainsAnyOrder() {
            List<String> theList1 = Arrays.asList("firstString", "secondString",
                    "thirdString");
            assertThat(theList1, Matchers.containsInAnyOrder("firstString",
                    "thirdString", "secondString"));

    }
}
