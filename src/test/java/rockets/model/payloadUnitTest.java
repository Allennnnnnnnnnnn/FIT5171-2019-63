package rockets.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by 56835 on 3/30/2019.
 */
public class payloadUnitTest {
    private payload target;

    @BeforeEach
    public void setUp() {
        target = new payload();
    }

    @Test
    public void shouldConstructUser() {
        assertNotNull(target);
    }

    @DisplayName("should throw exception when pass null to constructor function")
    @Test
    public void shouldThrowExceptionWhenConstructorNameToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> new payload(null,"null",120,180));
        assertEquals("category and name should not be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass empty to constructor function")
    @Test
    public void shouldThrowExceptionWhenConstructorCategoryToEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new payload("","",120,180));
        assertEquals("category and name should not be null or empty", exception.getMessage());
    }

    @DisplayName("should pass valid value to constructor function")
    @Test
    public void shouldThrowExceptionWhenConstructorCategoryToValid() {
        payload payload = new payload("arine","spacecraft",120,180);
        assertEquals("arine",payload.getName());
        assertEquals("spacecraft",payload.getCategory());
    }

    @DisplayName("should throw exception when pass a empty name to setName function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetNameToEmpty(String name) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setName(name));
        assertEquals("name should not be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass null to setName function")
    @Test
    public void shouldThrowExceptionWhenSetNameToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setName(null));
        assertEquals("name should not be null or empty", exception.getMessage());
    }

    @DisplayName("should pass valid value to setName function")
    @Test
    public void shouldThrowExceptionWhenSetNameToValid() {
        target.setName("payload1");
        assertEquals("payload1",target.getName());
    }

    @DisplayName("should throw exception when pass a empty name to setcategory function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetCategoryToEmpty(String category) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setCategory(category));
        assertEquals("category should not be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass null to setCategory function")
    @Test
    public void shouldThrowExceptionWhenSetCategoryToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setCategory(null));
        assertEquals("category should not be null or empty", exception.getMessage());
    }

    @DisplayName("should pass valid value to setCategory function")
    @Test
    public void shouldThrowExceptionWhenSetCategoryToValid() {
       target.setCategory("spacecraft");
        assertEquals("spacecraft",target.getCategory());
    }
}
