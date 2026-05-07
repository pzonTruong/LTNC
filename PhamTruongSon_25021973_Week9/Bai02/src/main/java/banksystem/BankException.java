package banksystem;

/**
 * Base exception class for bank-related errors.
 */
public class BankException extends Exception {
  public BankException(String message) {
    super(message);
  }
}

