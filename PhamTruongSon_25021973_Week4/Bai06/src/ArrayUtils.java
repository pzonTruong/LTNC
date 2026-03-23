
class ArrayUtils {

    // Phương thức hoán đổi vị trí 2 phần tử (Sử dụng Generic T bất kỳ)
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Thuật toán Bubble Sort tổng quát
    // T bắt buộc phải implements Comparable để có hàm compareTo
    public static <T extends Comparable<T>> void sort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Sử dụng compareTo thay vì dấu >
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }
}
