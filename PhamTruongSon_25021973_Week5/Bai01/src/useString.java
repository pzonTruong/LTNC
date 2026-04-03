
public class useString {

    public useString() {

    }

    public void calcTimeusingString() {
        long startTime = System.currentTimeMillis();
        String s = "";

        for (int i = 0; i < 100000; i++) {
            s += "Hello";
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time use string: " + (endTime - startTime));
    }
}
