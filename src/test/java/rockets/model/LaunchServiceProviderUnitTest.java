package rockets.model;

import com.google.common.collect.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by 56835 on 3/28/2019.
 */
public class LaunchServiceProviderUnitTest {

    private LaunchServiceProvider target;
    @BeforeEach
    public void setUp() {
        target = new LaunchServiceProvider();
    }

    @Test
    public void shouldConstructUser() {
        assertNotNull(target);
    }

    @DisplayName("should throw exception when pass a invalid to setYear function")
    @ParameterizedTest
    @ValueSource(ints = {1956,2020})
    public void shouldThrowExceptionWhenSetYearToInvalid(int year) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.validYearFounded(year));
        assertEquals("the year input should within a reasonable range", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a valid to setYear function")
    @ParameterizedTest
    @ValueSource(ints = {1966,2010})
    public void shouldThrowExceptionWhenSetYearToValid(int year) {
        assertTrue(target.validYearFounded(year));
    }

    @DisplayName("should throw exception when pass null to constructor function")
    @Test
    public void shouldThrowExceptionWhenConstructorNameToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> new LaunchServiceProvider(null,1990,"China"));
        assertEquals("name cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a empty name to constructor function")
    @ParameterizedTest
    @ValueSource(strings = {""," ","  "})
    public void shouldThrowExceptionWhenConstructorNameToEmpty(String name) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new LaunchServiceProvider(name,1990,"China"));
        assertEquals("name cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a valid name to constructor function")
    @ParameterizedTest
    @ValueSource(strings = {"arin"})
    public void shouldThrowExceptionWhenConstructorNameToValid(String name) {
        LaunchServiceProvider l = new LaunchServiceProvider(name,1990,"China");
        assertEquals("arin",l.getName());
    }

    @DisplayName("should throw exception when pass null to constructor function")
    @Test
    public void shouldThrowExceptionWhenConstructorCountryToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> new LaunchServiceProvider("arine",1996,null));
        assertEquals("country cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a empty name to constructor function")
    @ParameterizedTest
    @ValueSource(strings = {""," ","  "})
    public void shouldThrowExceptionWhenConstructorCountryToEmpty(String country) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new LaunchServiceProvider("arine",1996,country));
        assertEquals("country cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a valid name to constructor function")
    @ParameterizedTest
    @ValueSource(strings = {"US"})
    public void shouldThrowExceptionWhenConstructorCountryToValid(String country) {
        LaunchServiceProvider l = new LaunchServiceProvider("arine",1990,country);
        assertEquals("US",l.getCountry());
    }


    @DisplayName("should throw exception when pass null to setHeadquarters function")
    @Test
    public void shouldThrowExceptionWhenSetHeadquartersToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setHeadquarters(null));
        assertEquals("headquarters cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a empty name to constructor function")
    @ParameterizedTest
    @ValueSource(strings = {""," ","  "})
    public void shouldThrowExceptionWhenSetHeadquartersToEmpty(String headquarters) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setHeadquarters(headquarters));
        assertEquals("headquarters cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a valid name to constructor function")
    @ParameterizedTest
    @ValueSource(strings = {"DC"})
    public void shouldThrowExceptionWhenSetHeadquartersToValid(String headquarters) {
        target.setHeadquarters(headquarters);
        assertEquals("DC",target.getHeadquarters());
    }

    @DisplayName("should throw exception when pass null to numberOfRockets function")
    @Test
    public void shouldThrowExceptionWhenNumberOfRocketsToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.numberOfRockets(null));
        assertEquals("the number of rockets should not be null", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a empty to numberOfRockets function")
    @Test
    public void shouldThrowExceptionWhenNumberOfRocketsToEmpty() {
        Set<Rocket> rockets = Sets.newLinkedHashSet();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.numberOfRockets(rockets));
        assertEquals("the number of rockets should be at least one", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a valid value to numberOfRockets function")
    @Test
    public void shouldThrowExceptionWhenNumberOfRocketsToValid() {
        Set<Rocket> rockets = Sets.newLinkedHashSet();
        rockets.add(new Rocket("name","country","manufacturer"));
        assertTrue(target.numberOfRockets(rockets));
    }
}
