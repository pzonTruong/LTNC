package bank_system;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lớp quản lý các hoạt động của ngân hàng.
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
   * Đọc danh sách khách hàng từ luồng dữ liệu.
   */
  public void readCustomerList(InputStream inputStream) {
    if (inputStream == null) {
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

        processLine(line, currentCustomer);
      }
    } catch (Exception e) {
      logger.error("Error reading customer list", e);
    }
  }

  private void processLine(String line, Customer currentCustomer) {
    int lastSpaceIndex = line.lastIndexOf(' ');
    if (lastSpaceIndex <= 0) {
      return;
    }

    String lastToken = line.substring(lastSpaceIndex + 1).trim();
    if (lastToken.matches("\\d{9}")) {
      String name = line.substring(0, lastSpaceIndex).trim();
      currentCustomer = new Customer(Long.parseLong(lastToken), name);
      customerList.add(currentCustomer);
      logger.info("Customer added: {}", name);
    } else if (currentCustomer != null) {
      parseAccount(line, currentCustomer);
    }
  }

  private void parseAccount(String line, Customer customer) {
    String[] parts = line.split("\\s+");
    if (parts.length >= 3) {
      long accNum = Long.parseLong(parts[0]);
      double balance = Double.parseDouble(parts[2]);
      if (parts[1].equals(Account.TYPE_CHECKING)) {
        customer.addAccount(new CheckingAccount(accNum, balance));
      } else if (parts[1].equals(Account.TYPE_SAVINGS)) {
        customer.addAccount(new SavingsAccount(accNum, balance));
      }
    }
  }

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