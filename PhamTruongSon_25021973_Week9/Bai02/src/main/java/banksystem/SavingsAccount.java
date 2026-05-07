package banksystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class representing a savings account with withdrawal limits and minimum balance.
 */
public class SavingsAccount extends Account {
  private static final Logger logger = LoggerFactory.getLogger(SavingsAccount.class);
  private static final double MAX_WITHDRAWAL_LIMIT = 1000.0;
  private static final double MINIMUM_BALANCE_REQUIRED = 5000.0;

  public SavingsAccount(long accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  public void deposit(double amount) {
    logger.info("Processing deposit for account {}: +${}", getAccountNumber(), amount);
    double initialBalance = getBalance();
    try {
      doDepositing(amount);
      Transaction t = new Transaction(
          Transaction.TYPE_DEPOSIT_SAVINGS, amount, initialBalance, getBalance());
      addTransaction(t);
      logger.info("Deposit successful. New balance: ${}", getBalance());
    } catch (InvalidFundingAmountException e) {
      logger.error("Deposit failed: Invalid amount {}", amount);
    }
  }

  @Override
  public void withdraw(double amount) {
    double initialBalance = getBalance();
    try {
      if (amount > MAX_WITHDRAWAL_LIMIT) {
        throw new InvalidFundingAmountException(amount);
      }
      if (getBalance() - amount < MINIMUM_BALANCE_REQUIRED) {
        throw new InsufficientFundsException(amount);
      }
      doWithdrawing(amount);
      Transaction t = new Transaction(
          Transaction.TYPE_WITHDRAW_SAVINGS, amount, initialBalance, getBalance());
      addTransaction(t);
      logger.info("Withdrawal successful for account {}: -${}", getAccountNumber(), amount);
    } catch (BankException e) {
      logger.warn("Withdrawal denied: {}", e.getMessage());
    } catch (Exception e) {
      logger.error("System error during withdrawal", e);
    }
  }
}