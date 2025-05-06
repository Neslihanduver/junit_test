package com.account;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreateAccountTest {

    // E-mail doğrulama testleri
    @Test
    void testValidEmail() {
        assertTrue(Validator.isValidEmail("test@example.com"));
    }

    @Test
    void testInvalidEmail() {
        assertFalse(Validator.isValidEmail("testexample.com"));
    }

    // Şifre doğrulama testleri
    @Test
    void testStrongPassword() {
        assertTrue(Validator.isStrongPassword("StrongP@ssw0rd"));
    }

    @Test
    void testWeakPassword() {
        assertFalse(Validator.isStrongPassword("weakpassword"));
    }

    // Şifrelerin eşleşmesi testleri
    @Test
    void testPasswordsMatch() {
        assertTrue(Validator.passwordsMatch("password123", "password123"));
    }

    @Test
    void testPasswordsDoNotMatch() {
        assertFalse(Validator.passwordsMatch("password123", "password124"));
    }

    // Doğum tarihi doğrulama testleri
    @Test
    void testValidDOB() {
        assertTrue(Validator.isValidDOB("1995-02-23"));
    }

    @Test
    void testInvalidDOB() {
        assertFalse(Validator.isValidDOB("23-02-1995"));
    }

    // Şifre hata mesajı testleri
    @Test
    void testPasswordMissingLowercase() {
        assertEquals("⚠ Password must contain at least one lowercase letter.", Validator.getPasswordErrorMessage("ABC123$#"));
    }

    @Test
    void testPasswordMissingUppercase() {
        assertEquals("⚠ Password must contain at least one uppercase letter.", Validator.getPasswordErrorMessage("abc123$#"));
    }

    @Test
    void testPasswordMissingDigit() {
        assertEquals("⚠ Password must contain at least one digit.", Validator.getPasswordErrorMessage("Abcdef$#"));
    }

    @Test
    void testPasswordMissingSpecialChar() {
        assertEquals("⚠ Password must contain at least one special character (!@#$%^&* etc.).", Validator.getPasswordErrorMessage("Abc12345"));
    }

    @Test
    void testPasswordEmpty() {
        assertEquals("⚠ Password cannot be empty.", Validator.getPasswordErrorMessage(""));
    }

    @Test
    void testPasswordValid() {
        assertEquals("Password is valid.", Validator.getPasswordErrorMessage("Abc123$#"));
    }
}
