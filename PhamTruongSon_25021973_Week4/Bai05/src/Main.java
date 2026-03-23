public class Main {
    public static void main(String[] args) {
        // 1. Tạo Pair<String, Integer>
        Pair<String, Integer> agePair = new Pair<>("Tuổi", 20);
        System.out.println(agePair);

        // 2. Tạo Pair<String, String>
        Pair<String, String> studentPair = new Pair<>("Mã SV", "SV001");
        System.out.println(studentPair);

        // 3. Tạo Pair<Integer, Double>
        Pair<Integer, Double> geoPair = new Pair<>(105, 21.5);
        System.out.println(geoPair);

        // Pair<String, Integer> errorPair = new Pair<>("Test", "Hai mươi"); 
        // System.out.println(errorPair);
        // Lỗi biên dịch sẽ xuất hiện: 
        // "Incompatible types: String cannot be converted to Integer"
    }
}
