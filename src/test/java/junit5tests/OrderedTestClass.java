package junit5tests;

import org.junit.jupiter.api.*;
@TestMethodOrder(MethodOrderer.DisplayName.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderedTestClass {
    @BeforeAll
    void beforeAll() {
        System.out.println("--This is the before All method");
    }
    @BeforeEach
    void beforeEach(){
                System.out.println("----This is the before Each method----");
    }
    @AfterAll
    void afterAll() {
        System.out.println("---This is the after All method---");
    }
    @AfterEach
    void afterEach() {
        System.out.println("---This is the after Each method---");
    }
    @Test
    void firstMethod() {
        System.out.println("This is the first test method");
    }
    @Test
    @DisplayName("US1224 - TC - 23- this is the secondOne")
    void secondMethod () {
        System.out.println("This is the 2nd test");
    }
    @Test
    @DisplayName("A display name")
    void thirdMethod() { System.out.println("This is the third method");  }
}
