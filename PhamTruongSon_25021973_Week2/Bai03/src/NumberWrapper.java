public class NumberWrapper {
    private int value;

    public NumberWrapper(int value){
        this.setValue(value);
    }

    public void setValue(int val){
        this.value = val;
        System.out.println("Number set to value " + val);
    }

    public int getValue(){
        return this.value;
    }

    public void swap(NumberWrapper other){
        int temp = this.value;
        this.value = other.value;
        other.value = temp;
    }
}
