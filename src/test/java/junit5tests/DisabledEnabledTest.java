package junit5tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DisabledEnabledTest {
    @Test
    @Disabled (value = "Disabled Demo od @Disabled")
    void firstTest() {
        System.out.println("This is the first method");
    }

    @Test
    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "Disabled because of OS")
    void secondTest() {
        System.out.println("This is the second method");
    }

    @Test
    @DisabledIfSystemProperty(named = "env", matches = "staging", disabledReason = "Disabled for Demo")
    void thirdTest() {
        System.out.println("This is the third method");
    }

    @Test
    @DisabledIf(value = "provider", disabledReason ="Disabled for Disabled If Demo")
    void forthTest() {
        System.out.println("This is the fourth method");
    }

    boolean provider() {
        return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.WEDNESDAY);
    }
}
