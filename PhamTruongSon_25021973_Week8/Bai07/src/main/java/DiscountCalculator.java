public class DiscountCalculator {
    public static double calculateDiscount(double price, String memberType) {
        if (price < 0) {
            throw new IllegalArgumentException("Price must not be negative");
        }

        if (memberType == null) {
            throw new IllegalArgumentException("Invalid member type");
        }

        switch (memberType.toUpperCase()) {
            case "GUEST":
                return 0.0;
            case "MEMBER":
                return (price < 100) ? price * 0.05 : price * 0.10;
            case "VIP":
                return (price < 100) ? price * 0.15 : price * 0.20;
            default:
                throw new IllegalArgumentException("Invalid member type: " + memberType);
        }
    }
}