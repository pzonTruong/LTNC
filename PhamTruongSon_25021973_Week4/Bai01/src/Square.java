public class Square extends Shape{
    public Square(int x, int y){
        super(x, y);
    }

    @Override
    public void draw(){
        System.out.println("Draw square at: " + x + " " + y);
    }

    @Override
    public void erase(){
        System.out.println("Erase square at: " + x + " " + y);
    }
}
