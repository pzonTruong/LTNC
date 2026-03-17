public class VIPRoom extends Room{
    public VIPRoom(double basePrice, int days){
        super(basePrice, days);
    }

    @Override
    public double getFinalPrice(){
        return basePrice * days;
    }
}
