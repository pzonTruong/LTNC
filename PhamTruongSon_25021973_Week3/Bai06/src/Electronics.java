public class Electronics extends Product{
    private double warrantyFee;

    public Electronics(String name, double initialPrice, double warrantyFee){
        super(name, initialPrice);
        this.warrantyFee = warrantyFee;
    }

    @Override
    public double getFinalPrice(){
        return initialPrice * 1.1 + warrantyFee;
    }

    @Override
    public String getItemType(){
        return "Electronics";
    }
}
