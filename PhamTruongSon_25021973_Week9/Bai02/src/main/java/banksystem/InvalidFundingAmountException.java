package banksystem;

import java.util.Locale;

/**
 * Exception thrown when a transaction amount is invalid (e.g., negative or zero).
 */
public class InvalidFundingAmountException extends BankException {
  public InvalidFundingAmountException(double amount) {
    super("Invalid transaction amount: $" + String.format(Locale.US, "%.2f", amount));
  }
}

