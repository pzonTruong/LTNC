package banksystem;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class managing bank operations and customer records.
 */
public class Bank {
  private static final Logger logger = LoggerFactory.getLogger(Bank.class);
  private List<Customer> customerList;

  public Bank() {
    this.customerList = new ArrayList<>();
  }

  public List<Customer> getCustomerList() {
    return customerList;
  }

  /**
   * Reads customer list from an input stream.
   */
  public void readCustomerList(InputStream inputStream) {
    if (inputStream == null) {
      logger.warn("Attempted to read customer list from null InputStream");
      return;
    }
    
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
      String line;
      Customer currentCustomer = null;
      
      while ((line = reader.readLine()) != null) {
        line = line.trim();
        if (line.isEmpty()) {
          continue;
        }

        currentCustomer = processLine(line, currentCustomer);
      }
      logger.info("Finished reading customer list. Total customers: {}", customerList.size());
    } catch (Exception e) {
      logger.error("Error reading customer list", e);
    }
  }

  private Customer processLine(String line, Customer currentCustomer) {
    int lastSpaceIndex = line.lastIndexOf(' ');
    if (lastSpaceIndex <= 0) {
      return currentCustomer;
    }

    String lastToken = line.substring(lastSpaceIndex + 1).trim();
    if (lastToken.matches("\\d{9}")) {
      String name = line.substring(0, lastSpaceIndex).trim();
      Customer customer = new Customer(Long.parseLong(lastToken), name);
      customerList.add(customer);
      logger.info("New customer added: {} (ID: {})", name, lastToken);
      return customer;
    } else if (currentCustomer != null) {
      parseAccount(line, currentCustomer);
      return currentCustomer;
    }
    return currentCustomer;
  }

  private void parseAccount(String line, Customer customer) {
    String[] parts = line.split("\\s+");
    if (parts.length >= 3) {
      try {
        long accNum = Long.parseLong(parts[0]);
        double balance = Double.parseDouble(parts[2]);
        if (parts[1].equals(Account.TYPE_CHECKING)) {
          customer.addAccount(new CheckingAccount(accNum, balance));
          logger.debug("Checking account {} added for customer {}", accNum, customer.getFullName());
        } else if (parts[1].equals(Account.TYPE_SAVINGS)) {
          customer.addAccount(new SavingsAccount(accNum, balance));
          logger.debug("Savings account {} added for customer {}", accNum, customer.getFullName());
        }
      } catch (NumberFormatException e) {
        logger.error("Failed to parse account data: {}", line);
      }
    }
  }

  /**
   * Returns information of all customers sorted by ID.
   */
  public String getCustomersInfoByIdOrder() {
    customerList.sort(Comparator.comparingLong(Customer::getIdNumber));
    return buildCustomerInfoString(customerList);
  }

  private String buildCustomerInfoString(List<Customer> list) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < list.size(); i++) {
      sb.append(list.get(i).getCustomerInfo());
      if (i < list.size() - 1) {
        sb.append("\n");
      }
    }
    return sb.toString();
  }
}