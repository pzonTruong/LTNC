public class Main {
    public static void main(String[] args) {
        
        MathUtils m = new AdvancedMath();
        System.out.println(m.sum(5, 5)); // 20 (A)

        // (B)
        // System.out.println(m.sum(5.5, 5.5)); 
        // Có lỗi: imcompatible types

    }
}
