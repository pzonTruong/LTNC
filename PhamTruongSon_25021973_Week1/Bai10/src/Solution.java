
public class Solution {
    public int secondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        boolean foundSecond = false;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
                if (secondLargest != Integer.MIN_VALUE) {
                    foundSecond = true;
                }
            } 
            // Nếu số hiện tại nhỏ hơn largest nhưng lớn hơn secondLargest
            else if (num < largest && num > secondLargest) {
                secondLargest = num;
                foundSecond = true;
            }
        }

        return foundSecond ? secondLargest : -1;
    }
}
