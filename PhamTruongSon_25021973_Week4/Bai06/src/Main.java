import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. Mảng Integer
        Integer[] numbers = {5, 1, 3, 2};
        ArrayUtils.sort(numbers);
        System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\],]", ""));

        // 2. Mảng String
        String[] languages = {"Java", "C++", "Python"};
        ArrayUtils.sort(languages);
        System.out.println(Arrays.toString(languages).replaceAll("[\\[\\],]", ""));

    }
}