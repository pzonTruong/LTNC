public class Main {
    public static void main(String[] args) {
        // Khởi tạo dữ liệu mẫu
        String name = "Nguyễn Văn A";
        double baseSalary = 30000000;
        int workDays = 20;
        int totalDays = 22;
        double taxRate = 0.15;
        double bonus = 2000000;

        // Khởi tạo bộ tính toán
        PayrollCalculator calculator = new PayrollCalculator();

        // Thực hiện tính toán
        double actualSalary = calculator.calculateActualSalary(baseSalary, workDays, totalDays);
        double insurance = calculator.calculateTotalInsurance(actualSalary);
        double tax = calculator.calculateIncomeTax(actualSalary, insurance, taxRate);
        double netSalary = calculator.calculateNetSalary(actualSalary, insurance, tax, bonus);

        // In kết quả
        System.out.println("Output:");
        System.out.println("name:       " + name);
        System.out.printf("Food:   %,.0f VND\n", actualSalary);
        System.out.printf("Insurance:     %,.0f VND\n", insurance);
        System.out.printf("tax TNCN:    %,.0f VND\n", tax);
        System.out.printf("Bonus:  %,.0f VND\n", bonus);
        System.out.println("----------------------------");
        System.out.printf("After:    %,.0f VND\n", netSalary);
    }
}