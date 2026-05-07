package banksystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class representing a checking account.
 */
public class CheckingAccount extends Account {
  private static final Logger logger = LoggerFactory.getLogger(CheckingAccount.class);

  public CheckingAccount(long accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  public void deposit(double amount) {
    double initialBalance = getBalance();
    try {
      doDepositing(amount);
      double finalBalance = getBalance();
      Transaction t = new Transaction(
          Transaction.TYPE_DEPOSIT_CHECKING,
          amount,
          initialBalance,
          finalBalance);
      addTransaction(t);
      logger.info("Deposit successful for checking account {}: +${}", getAccountNumber(), amount);
    } catch (BankException e) {
      logger.error("Deposit failed for checking account {}: {}", getAccountNumber(), e.getMessage());
    }
  }

  @Override
  public void withdraw(double amount) {
    double initialBalance = getBalance();
    try {
      doWithdrawing(amount);
      double finalBalance = getBalance();
      Transaction t = new Transaction(
          Transaction.TYPE_WITHDRAW_CHECKING,
          amount,
          initialBalance,
          finalBalance);
      addTransaction(t);
      logger.info("Withdrawal successful for checking account {}: -${}", getAccountNumber(), amount);
    } catch (BankException e) {
      logger.error("Withdrawal failed for checking account {}: {}", getAccountNumber(), e.getMessage());
    }
  }
}

