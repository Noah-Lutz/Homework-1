import java.util.Scanner;

public class Bank {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        // Array layout: [0] = balance, [1] = rate, [2] = years.
        double[] checkingResponses, savingResponses;
        double checkingInterest, savingInterest;

        // Handle for checking account.
        checkingResponses = promptUser("Checking");
        checkingInterest = calculateInterest(checkingResponses);
        System.out.println();
        System.out.printf("Interest earned for Checking Account across %.1f years: %.2f\n", checkingResponses[2], checkingInterest);
        System.out.println();
        System.out.println();

        // Handle for saving account.
        savingResponses = promptUser("Saving");
        savingInterest = calculateInterest(savingResponses);
        System.out.println();
        System.out.printf("Interest earned for Saving Account across %.1f years: %.2f\n", savingResponses[2], savingInterest);
        System.out.println();
        System.out.println();

        System.out.println("COMMUNITY FIRST FEDERAL CREDIT UNION ACCOUNT STATEMENT");
        printStatement("Checking", checkingResponses, checkingInterest);
        System.out.println();
        printStatement("Saving", savingResponses, savingInterest);
    }

    /**
     * Return how much interest would be earned given the inputted data.
     */
    private static double calculateInterest(double[] responses) {
        // We're doing simple interest. Initially wrote this as compounding interest.
        return ((responses[1] * responses[2]) / 100 + 1) * responses[0] - responses[0];
    }

    /**
     * Prompt the user for information about an account.
     * Return the data in an array.
     */
    private static double[] promptUser(String account) {
        double[] responses = new double[3];

        System.out.println(" -- " + account + " Account Interest Calculator --");

        // Prompt for inputs.
        System.out.print("Please enter the current balance of your account (ex: \"4000.23\" for $4000.23): ");
        responses[0] = scanner.nextDouble();
        System.out.print("Please enter the current interest rate of your account (ex: \"4.55\" for 4.55%): ");
        responses[1] = scanner.nextDouble();
        System.out.print("Please enter the duration in years for interest to collect: ");
        responses[2] = scanner.nextDouble();

        return responses;
    }

    /**
     * Print a breakdown of the given account.
     */
    private static void printStatement(String account, double[] responses, double interest) {
        System.out.println(" -- " + account + " Account Statement --");
        System.out.println("|-----------------|-----------------|-------|-----------------|-----------------|");
        System.out.printf("| %-15s | %-15s | %-5s | %-15s | %-15s |\n", "Starting Bal", "Interest Rate", "Years", "Interest Earned", "Ending Bal");
        System.out.println("|-----------------|-----------------|-------|-----------------|-----------------|");
        System.out.printf("| %-15.2f | %-15.2f | %-5.1f | %-15.2f | %-15.2f |\n", responses[0], responses[1], responses[2], interest, responses[0] + interest);
        System.out.println("|-----------------|-----------------|-------|-----------------|-----------------|");
    }
}
