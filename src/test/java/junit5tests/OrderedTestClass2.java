package junit5tests;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderedTestClass2 {
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
    @Order(2)
    void firstMethod() {
        System.out.println("This is the first test method");
    }
    @Test
    @DisplayName("US1224 - TC - 23- this is the secondOne")
    void secondMethod () {
        System.out.println("This is the 2nd test");
    }
    @Test
    @Order(1)
    void thirdTest() {System.out.println("This is the third test method");
    }
}
