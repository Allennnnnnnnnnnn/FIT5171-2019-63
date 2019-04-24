package rockets.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by 56835 on 3/23/2019.
 */
public class RocketUnitTest {
    private Rocket target;

    @BeforeEach
    public void setUp() {
        target = new Rocket("Ariane","US","Lockheed");
    }

    @Test
    public void shouldConstructUser() {
        assertNotNull(target);
    }

    @DisplayName("should throw exception when pass null to constructor function")
    @Test
    public void shouldThrowExceptionWhenConstructorToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> new Rocket(null,null,null));
        assertEquals("The validated object is null", exception.getMessage());
    }



}
