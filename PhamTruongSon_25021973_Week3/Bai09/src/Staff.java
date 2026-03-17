interface IPayable {
    double getPaymentAmount();
}

abstract class Staff implements IPayable{
    private String id;
    private String name;

    public Staff(String id, String name){
        this.id = id;
        this.name = name;
    }

    // Lưu ý: Không ghi đè getPaymentAmount ở đây để ép các lớp con (FullTime, PartTime) tự định nghĩa

    public String getName(){
        return name;
    }


}
