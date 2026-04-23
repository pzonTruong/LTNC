

public class Main {
    public static void main(String[] args) {
        Student sv = new Student("SV001", "Nguyễn Văn A");
        Course mh = new Course("CS101", "Lập trình Java", 3);
        Grade diem = new Grade(8.0, 7.5, 9.0);

        TranscriptPrinter printer = new TranscriptPrinter(sv, mh, diem);
        printer.printTranscript();
    }
}