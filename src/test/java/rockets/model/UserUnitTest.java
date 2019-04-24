package rockets.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserUnitTest {
    private User target;

    @BeforeEach
    public void setUp() {
        target = new User();
    }

    @Test
    public void shouldConstructUser() {
        assertNotNull(target);
    }

    @DisplayName("should throw exception when pass a empty email address to setEmail function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetEmailToEmpty(String email) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setEmail(email));
        assertEquals("email cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass null to setEmail function")
    @Test
    public void shouldThrowExceptionWhenSetEmailToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setEmail(null));
        assertEquals("email cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a  email address with wrong format to setEmail function")
    @ParameterizedTest
    @ValueSource(strings = {"11", "1223@", "character@","@character11"})
    public void shouldThrowExceptionWhenSetEmailIntoWrongFormat(String email) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.isEmailFormat(email));
        assertEquals("It is not a email of right format", exception.getMessage());
    }

    @DisplayName("should be recorded when pass a email with correct format to setEmail function")
    @ParameterizedTest
    @ValueSource(strings = {"ypan0021@monash.edu"})
    public void shouldPassWhenSetEmailIntoCorrectFormat(String email) {
        target.setEmail(email);
        assertTrue(target.getEmail().equals("ypan0021@monash.edu"));
    }

    @DisplayName("should throw exception when pass a empty password to setPassword function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetPasswordToEmpty(String email) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setPassword(email));
        assertEquals("password cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exceptions when pass a null password to setPassword function")
    @Test
    public void shouldThrowExceptionWhenSetPasswordToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setPassword(null));
        assertEquals("password cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a  password with at least 6 digits to setPassword function")
    @ParameterizedTest
    @ValueSource(strings = {"12345", "1234", "123"})
    public void shouldThrowExceptionWhenSetPasswordLessThanSix(String password) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.passwordIsAtLeast6(password));
        assertEquals("password should be at least 6", exception.getMessage());
    }

    @DisplayName("should pass a  password with at least 6 digits to setPassword function")
    @ParameterizedTest
    @ValueSource(strings = {"123456"})
    public void shouldPassWhenSetPasswordAtLessThanSix(String password) {
        assertTrue(target.passwordIsAtLeast6(password));
    }

    @DisplayName("should throw exception when pass a password has lowercase and uppercase character and digits to setPassword function")
    @ParameterizedTest
    @ValueSource(strings = {"123456", "qwerty", "QWERT","Qwerty","1QWERT","1qwert"})
    public void shouldThrowExceptionWhenSetPasswordHasNoDigitLowerCaseCharAndUpperCaseChar(String password) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.passwordHasDigitAndUpperCaseCharAndLowCaseChar(password));
        assertEquals("password should contain at least one digit one lowerCase character and one uppercase character", exception.getMessage());
    }

    @DisplayName("should pass a password has lowercase and uppercase character and digits to setPassword function")
    @ParameterizedTest
    @ValueSource(strings = {"aA1234"})
    public void shouldPassWhenSetPasswordHasNoDigitLowerCaseCharAndUpperCaseChar(String password) {
        assertTrue(target.passwordHasDigitAndUpperCaseCharAndLowCaseChar(password));
    }

    @DisplayName("should return true when two users have the same email")
    @Test
    public void shouldReturnTrueWhenUsersHaveSameEmail() {
        String email = "abc@example.com";
        target.setEmail(email);
        User anotherUser = new User();
        anotherUser.setEmail(email);
        assertTrue(target.equals(anotherUser));
    }


    @DisplayName("should return false when two users have different emails")
    @Test
    public void shouldReturnFalseWhenUsersHaveDifferentEmails() {
        target.setEmail("abc@example.com");
        User anotherUser = new User();
        anotherUser.setEmail("def@example.com");
        assertFalse(target.equals(anotherUser));
    }

    @DisplayName("should throw exception when pass a empty first name to setFirstName function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetFirstNameToEmpty(String email) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setFirstName(email));
        assertEquals("first name cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exceptions when pass a null first name to setFirstName function")
    @Test
    public void shouldThrowExceptionWhenSetFirstNameToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setFirstName(null));
        assertEquals("first name cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass valid first name to setFirstName function")
    @ParameterizedTest
    @ValueSource(strings = {"allen"})
    public void shouldThrowExceptionWhenSetFirstNameToValidValue(String firstName) {
        target.setFirstName(firstName);
        assertEquals("allen",target.getFirstName());
    }

    @DisplayName("should throw exception when pass a empty last name to getLastName function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetLastNameToEmpty(String email) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setLastName(email));
        assertEquals("last name cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exceptions when pass a null last name to getLastName function")
    @Test
    public void shouldThrowExceptionWhenSetLastNameToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setLastName(null));
        assertEquals("last name cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a valid name to setLastName function")
    @ParameterizedTest
    @ValueSource(strings = {"zhang"})
    public void shouldThrowExceptionWhenSetLastNameToValidValue(String lastName) {
        target.setLastName(lastName);
        assertEquals("zhang",target.getLastName());
    }

}