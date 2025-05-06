package com.account;

public class Validator {

    // E-mail doğrulama metodu
    public static boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email != null && email.matches(regex);
    }

    // Şifre doğrulama metodu
    public static boolean isStrongPassword(String pw) {
        return pw != null && pw.length() >= 8 &&
               pw.matches(".*[a-z].*") &&
               pw.matches(".*[A-Z].*") &&
               pw.matches(".*[0-9].*") &&
               pw.matches(".*[!@#$%^&()_\\-+=.].*");
    }

    // Şifrelerin eşleşip eşleşmediğini kontrol etme metodu
    public static boolean passwordsMatch(String pw, String cpw) {
        return pw != null && pw.equals(cpw);
    }

    // Doğum tarihi formatı doğrulama metodu
    public static boolean isValidDOB(String dob) {
        String regex = "^\\d{4}-\\d{2}-\\d{2}$"; // YYYY-MM-DD formatı
        return dob != null && dob.matches(regex);
    }

    // Şifrenin hata mesajını döndüren metot
    public static String getPasswordErrorMessage(String pw) {
        if (pw == null || pw.isEmpty()) {
            return "⚠ Password cannot be empty.";
        }
        if (!pw.matches(".*[a-z].*")) {
            return "⚠ Password must contain at least one lowercase letter.";
        }
        if (!pw.matches(".*[A-Z].*")) {
            return "⚠ Password must contain at least one uppercase letter.";
        }
        if (!pw.matches(".*[0-9].*")) {
            return "⚠ Password must contain at least one digit.";
        }
        if (!pw.matches(".*[!@#$%^&()_\\-+=.].*")) {
            return "⚠ Password must contain at least one special character (!@#$%^&* etc.).";
        }
        return "Password is valid.";
    }
}
