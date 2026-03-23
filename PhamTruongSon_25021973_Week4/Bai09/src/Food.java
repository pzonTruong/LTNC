
class Food extends Product {

    private String expiryDate;

    public Food(String id, String name, String expiryDate) {
        super(id, name);
        this.expiryDate = expiryDate;
    }

    @Override
    public String getInventoryDetails() {
        return "Hạn sử dụng: " + expiryDate;
    }
}
