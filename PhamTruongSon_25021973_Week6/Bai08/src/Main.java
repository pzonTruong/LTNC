public class Main {
    public static void main(String[] args) {
        // Tạo dữ liệu báo cáo
        Report report = new Report("Tháng 04/2026", "Nội dung báo cáo tiến độ học tập.");

        // 1. Xuất bản dạng JSON
        ReportService service = new ReportService(new JsonFormatter());
        System.out.println("--- Xuất JSON ---");
        System.out.println(service.export(report));

        // 2. Xuất bản dạng XML (Đổi formatter tại runtime)
        service.setFormatter(new XmlFormatter());
        System.out.println("\n--- Xuất XML ---");
        System.out.println(service.export(report));
    }
}