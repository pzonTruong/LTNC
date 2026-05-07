package banksystem;

import java.util.Locale;

/**
 * Exception thrown when an account has insufficient funds for a transaction.
 */
public class InsufficientFundsException extends BankException {
  public InsufficientFundsException(double amount) {
    super("Insufficient funds: required $" + String.format(Locale.US, "%.2f", amount));
  }
}

