public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("GCD của 24 và 18: " + sol.gcd(24, 18)); 
        System.out.println("GCD của 17 và 13: " + sol.gcd(17, 13)); 
        System.out.println("GCD của 0 và 5:   " + sol.gcd(0, 5));   
        System.out.println("GCD của -12 và 8: " + sol.gcd(-12, 8)); 
        System.out.println("GCD của 0 và 0:   " + sol.gcd(0, 0));
    }
}