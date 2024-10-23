import java.util.Scanner;

public class Lab1 {
    private String ccNumber;
    private int lastDigit;

    // Constructor to initialize the credit card number
    public Lab1(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    // Method to validate the credit card number
    public void validateCard() {
        if (ccNumber.length() < 8 || ccNumber.length() > 9) {
            System.out.println("Invalid credit card number");
            return;
        }

        // Step a: Remove the last digit and store it
        lastDigit = Integer.parseInt(ccNumber.substring(ccNumber.length() - 1));
        String remainingNumber = ccNumber.substring(0, ccNumber.length() - 1);

        // Step b: Reverse the remaining digits
        String reversedNumber = new StringBuilder(remainingNumber).reverse().toString();

        // Step c: Double the digits at odd-numbered positions and handle cases where the result is a double-digit
        int sum = 0;
        for (int i = 0; i < reversedNumber.length(); i++) {
            int digit = Character.getNumericValue(reversedNumber.charAt(i));
            if (i % 2 == 0) { // Odd-positioned digits in the reversed string (which correspond to even indices)
                digit *= 2;
                if (digit > 9) {
                    digit = digit / 10 + digit % 10; // Sum of the digits of the double-digit result
                }
            }
            sum += digit;
        }

        // Step d: Sum of all digits is already done in the loop (sum variable)

        // Step e: Subtract the last digit from 10
        int stepE = 10 - (sum % 10);

        // Step f: Compare the result of step e with the original last digit
        switch (stepE) {
            case 10:
                stepE = 0; // If the result of step e is 10, use 0 instead
                // fallthrough
            default:
                if (stepE == lastDigit) {
                    System.out.println("The credit card is valid.");
                } else {
                    System.out.println("The credit card is invalid.");
                }
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the credit card number: ");
        String ccNumber = scanner.nextLine();

        // Creating an instance of Lab1
        Lab1 validator = new Lab1(ccNumber);

        // Validating the card
        validator.validateCard();
        
        scanner.close();
    }
}
