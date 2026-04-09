public class Main {
    public static void main(String[] args) {
        // 1. Singleton
        System.out.println("--- Singleton Test ---");
        Logger.getInstance().log("Hệ thống bắt đầu chạy.");

        // 2. Factory Method
        System.out.println("\n--- Factory Method Test ---");
        ExportFactory factory = new PdfFactory(); // Hoặc new ExcelFactory()
        Export exporter = factory.createExport();
        exporter.exportData();

        // 3. Adapter
        System.out.println("\n--- Adapter Test ---");
        Player player = new PlayerAdapter(new OldPlayer());
        player.play("movie.mp4");

        // 4. Prototype
        System.out.println("\n--- Prototype Test ---");
        AppConfig original = new AppConfig("Default");
        AppConfig copy = original.clone();
        copy.setName("Custom User Settings");
        
        System.out.println("Original: " + original);
        System.out.println("Copy: " + copy);
    }
}