package rockets.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by 56835 on 3/31/2019.
 */
public class RocketFamilyUnitTest {
    private RocketFamily target;

    @BeforeEach
    public void setUp() {
        target = new RocketFamily("arine","SSE");
    }

    @Test
    public void shouldConstructUser() {
        assertNotNull(target);
    }

    @DisplayName("should throw exception when pass null to constructor function")
    @Test
    public void shouldThrowExceptionWhenConstructorNameToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> new RocketFamily(null,"null"));
        assertEquals("family and variation should not be null and empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass empty to constructor function")
    @Test
    public void shouldThrowExceptionWhenConstructorCategoryToEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new RocketFamily("",""));
        assertEquals("family and variation should not be null and empty", exception.getMessage());
    }

    @DisplayName("should pass valid value to constructor function")
    @Test
    public void shouldThrowExceptionWhenConstructorCategoryToValid() {
        RocketFamily rocketFamily = new RocketFamily("arine","spacecraft");
        assertEquals("arine",rocketFamily.getFamilyName());
        assertEquals("spacecraft",rocketFamily.getVariation());
    }

    @DisplayName("should throw exception when pass a empty name to setFamilyName function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetFamilyNameToEmpty(String str) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setFamilyName(str));
        assertEquals("family and variation should not be null and empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass null to setCategory function")
    @Test
    public void shouldThrowExceptionWhenSetFamilyNameToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setFamilyName(null));
        assertEquals("family and variation should not be null and empty", exception.getMessage());
    }

    @DisplayName("should pass valid value to setCategory function")
    @Test
    public void shouldThrowExceptionWhenSetCategoryToValid() {
        target.setFamilyName("Arine");
        assertEquals("Arine",target.getFamilyName());
    }

    @DisplayName("should throw exception when pass a empty name to setVariation function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetVariationToEmpty(String str) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setVariation(str));
        assertEquals("family and variation should not be null and empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass null to setCategory function")
    @Test
    public void shouldThrowExceptionWhenSetVariationToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setVariation(null));
        assertEquals("family and variation should not be null and empty", exception.getMessage());
    }

    @DisplayName("should pass valid value to setCategory function")
    @Test
    public void shouldThrowExceptionWhenSetVariationToValid() {
        target.setVariation("SE");
        assertEquals("SE",target.getVariation());
    }

}
