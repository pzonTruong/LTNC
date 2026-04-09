public class ReportService {
    private ReportFormatter formatter;

    // Nhận formatter qua constructor (Dependency Injection)
    public ReportService(ReportFormatter formatter) {
        this.formatter = formatter;
    }

    // Thay đổi formatter linh hoạt nếu cần
    public void setFormatter(ReportFormatter formatter) {
        this.formatter = formatter;
    }

    public String export(Report data) {
        return formatter.format(data);
    }
}