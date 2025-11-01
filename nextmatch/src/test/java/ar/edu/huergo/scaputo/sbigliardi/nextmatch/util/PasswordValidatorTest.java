package ar.edu.huergo.scaputo.sbigliardi.nextmatch.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PasswordValidatorTest {

    @Test
    void testIsValid_ValidPassword_ReturnsTrue() {
        // Given
        String validPassword = "ValidPassword123!X"; // 17 caracteres

        // When
        boolean result = PasswordValidator.isValid(validPassword);

        // Then
        assertTrue(result); // ahora sí debe ser válido
    }

    @Test
    void testIsValid_InvalidPassword_ReturnsFalse() {
        // Given
        String invalidPassword = "short";

        // When
        boolean result = PasswordValidator.isValid(invalidPassword);

        // Then
        assertFalse(result);
    }

    @Test
    void testIsValid_NullPassword_ReturnsFalse() {
        // Given
        String nullPassword = null;

        // When
        boolean result = PasswordValidator.isValid(nullPassword);

        // Then
        assertFalse(result);
    }

    @Test
    void testValidate_ValidPassword_NoException() {
        // Given
        String validPassword = "ThisIsAValidPassword123!";

        // When & Then
        assertDoesNotThrow(() -> PasswordValidator.validate(validPassword));
    }

    @Test
    void testValidate_InvalidPassword_ThrowsException() {
        // Given
        String invalidPassword = "invalid";

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.validate(invalidPassword);
        });
        assertEquals(PasswordValidator.getValidationMessage(), exception.getMessage());
    }

    @Test
    void testGetValidationMessage_ReturnsMessage() {
        // When
        String message = PasswordValidator.getValidationMessage();

        // Then
        assertNotNull(message);
        assertTrue(message.length() > 0);
    }
}
