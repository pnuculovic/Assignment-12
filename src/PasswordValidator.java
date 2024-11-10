import java.util.Scanner;

public class PasswordValidator {
    public static boolean validatePassword(String password) {
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if ("~!@#$%^&*()-=+_".contains(String.valueOf(c))) {
                hasSpecial = true;
            }
        }

        int categoryCount = 0;
        if (hasLower) categoryCount++;
        if (hasUpper) categoryCount++;
        if (hasDigit) categoryCount++;
        if (hasSpecial) categoryCount++;

        return categoryCount >= 3;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (validatePassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }

        scanner.close();
    }
}
