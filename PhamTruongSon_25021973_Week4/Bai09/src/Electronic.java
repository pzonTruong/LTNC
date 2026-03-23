
class Electronic extends Product {

    private int warrantyMonths;

    public Electronic(String id, String name, int warrantyMonths) {
        super(id, name);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public String getInventoryDetails() {
        return "Bảo hành: " + warrantyMonths + " tháng";
    }
}
