public class RegularRoom extends Room{
    public RegularRoom(double basePrice, int days){
        super(basePrice, days);
    }

    @Override
    public double getFinalPrice(){
        double fullPrice = basePrice * days;
        if(days > 3){
            double discount = 0.05 * fullPrice;
            double finalPrice = fullPrice - discount;
            return finalPrice;
        } else{
            return fullPrice;
        }
    }
}
