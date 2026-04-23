
public class PayrollCalculator {

    public double calculateActualSalary(double baseSalary, int workDays, int totalDays) {
        return baseSalary * workDays / totalDays;
    }

    public double calculateTotalInsurance(double actualSalary) {
        double socialInsurance = actualSalary * PayrollConstants.SOCIAL_INSURANCE_RATE;
        double healthInsurance = actualSalary * PayrollConstants.HEALTH_INSURANCE_RATE;
        return socialInsurance + healthInsurance;
    }

    public double calculateIncomeTax(double actualSalary, double insurance, double personalTaxRate) {
        double taxableIncome = actualSalary - insurance - PayrollConstants.PERSONAL_DEDUCTION;

        if (taxableIncome <= 0)
            return 0;

        if (taxableIncome <= PayrollConstants.TAX_LEVEL_1_LIMIT) {
            return taxableIncome * PayrollConstants.TAX_RATE_LEVEL_1;
        } else if (taxableIncome <= PayrollConstants.TAX_LEVEL_2_LIMIT) {
            return PayrollConstants.TAX_BASE_LEVEL_2 +
                    (taxableIncome - PayrollConstants.TAX_LEVEL_1_LIMIT) * PayrollConstants.TAX_RATE_LEVEL_2;
        } else {
            return PayrollConstants.TAX_BASE_LEVEL_3 +
                    (taxableIncome - PayrollConstants.TAX_LEVEL_2_LIMIT) * personalTaxRate;
        }
    }

    public double calculateNetSalary(double actualSalary, double insurance, double tax, double bonus) {
        return actualSalary - insurance - tax + bonus;
    }

    // Áp dụng Extract Method
    // Hàm printPayroll ban đầu chứa quá nhiều trách nhiệm (tính lương, tính thuế,
    // tính bảo hiểm, in ấn). Sau khi tách:

    // Mỗi hàm con chỉ làm duy nhất một việc (Single Responsibility).
}