
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Food extends Product {

    private LocalDate expireDate;

    public Food(String name, double initialPrice, LocalDate expireDate) {
        super(name, initialPrice);
        this.expireDate = expireDate;
    }

    @Override
    public double getFinalPrice() {
        LocalDate today = LocalDate.now();

        long remainDays = ChronoUnit.DAYS.between(today, expireDate);

        if (remainDays < 7) {
            return initialPrice * 0.8;
        }
        return initialPrice;
    }

    @Override
    public String getItemType() {
        return "Food";
    }
}
