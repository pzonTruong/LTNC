
// ==========================================
// PHẦN 2: PROTOTYPE PATTERN
// ==========================================
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 1. Lớp ReportTemplate hỗ trợ nhân bản (Cloneable)
class ReportTemplate implements Cloneable {
    private String title;
    private String footer;
    private List<String> sections;

    public ReportTemplate(String title, String footer) {
        this.title = title;
        this.footer = footer;
        this.sections = new ArrayList<>();
    }

    // Thực hiện Deep Copy (Sao chép sâu)
    @Override
    public ReportTemplate clone() {
        try {
            ReportTemplate copy = (ReportTemplate) super.clone();
            // Khởi tạo List mới để tránh dùng chung vùng nhớ với bản gốc
            copy.sections = new ArrayList<>(this.sections);
            return copy;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addSection(String section) {
        this.sections.add(section);
    }

    @Override
    public String toString() {
        return String.format("Report[Title='%s', Footer='%s', Sections=%s]",
                title, footer, sections);
    }
}