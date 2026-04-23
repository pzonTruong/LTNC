public class A {
    // Đoạn A:
    // public double calculateFee(String t, int h, double r, boolean m) {
    //  double f = h * r;
    //  if (m)
    //      f = f * 0.9;
    //  return f;
    // }

    // Code Smell: Mysterious Name & Primitive Obsession

    // Sau khi thay đổi:
    public double calculateFee(String type, int hours, double rate, boolean isMember) {
        double totalFee = hours * rate;
        if (isMember) {
            totalFee = totalFee * 0.9;
        }
        return totalFee;
    }
}
