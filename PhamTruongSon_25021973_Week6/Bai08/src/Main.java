public class Main {
    public static void main(String[] args) {
        // Tạo dữ liệu báo cáo
        Report report = new Report("April", "Content goes here...");

        // 1. Xuất bản dạng JSON
        ReportService service = new ReportService(new JsonFormatter());
        System.out.println("--- JSON ---");
        System.out.println(service.export(report));

        // 2. Xuất bản dạng XML (Đổi formatter tại runtime)
        service.setFormatter(new XmlFormatter());
        System.out.println("\n--- XML ---");
        System.out.println(service.export(report));
    }
}