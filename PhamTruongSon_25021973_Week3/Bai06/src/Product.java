abstract class Product {
    protected String id;
    protected String name;
    protected double initialPrice;

    public Product(String name, double initialPrice){
        // this.id = id;
        this.name = name;
        this.initialPrice = initialPrice;
    }

    public String getName(){
        return name;
    }

    public abstract String getItemType();

    public abstract double getFinalPrice();
}
