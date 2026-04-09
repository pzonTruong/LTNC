interface Export {
    void exportData();
}

class PdfExport implements Export {
    public void exportData() { System.out.println("Exporting to PDF..."); }
}

class ExcelExport implements Export {
    public void exportData() { System.out.println("Exporting to Excel..."); }
}

abstract class ExportFactory {
    public abstract Export createExport();
}

class PdfFactory extends ExportFactory {
    public Export createExport() { return new PdfExport(); }
}

class ExcelFactory extends ExportFactory {
    public Export createExport() { return new ExcelExport(); }
}