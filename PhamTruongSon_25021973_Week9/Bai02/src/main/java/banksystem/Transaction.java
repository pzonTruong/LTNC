package banksystem;

import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class representing a financial transaction.
 */
public class Transaction {
  private static final Logger logger = LoggerFactory.getLogger(Transaction.class);

  public static final int TYPE_DEPOSIT_CHECKING = 1;
  public static final int TYPE_WITHDRAW_CHECKING = 2;
  public static final int TYPE_DEPOSIT_SAVINGS = 3;
  public static final int TYPE_WITHDRAW_SAVINGS = 4;

  private int type;
  private double amount;
  private double initialBalance;
  private double finalBalance;

  /**
   * Initializes a transaction record.
   */
  public Transaction(int type, double amount, double initialBalance, double finalBalance) {
    this.type = type;
    this.amount = amount;
    this.initialBalance = initialBalance;
    this.finalBalance = finalBalance;
  }

  /**
   * Converts transaction type code to a descriptive string.
   */
  public static String getTypeString(int typeCode) {
    switch (typeCode) {
      case TYPE_DEPOSIT_CHECKING:
        return "Checking Deposit";
      case TYPE_WITHDRAW_CHECKING:
        return "Checking Withdrawal";
      case TYPE_DEPOSIT_SAVINGS:
        return "Savings Deposit";
      case TYPE_WITHDRAW_SAVINGS:
        return "Savings Withdrawal";
      default:
        return "Unknown";
    }
  }

  /**
   * Returns a summary of the transaction.
   */
  public String getTransactionSummary() {
    logger.debug("Generating summary for transaction type: {}", type);
    return String.format(Locale.US,
        "- Type: %s. Initial Balance: $%.2f. Amount: $%.2f. Final Balance: $%.2f.",
        getTypeString(type), initialBalance, amount, finalBalance);
  }
}