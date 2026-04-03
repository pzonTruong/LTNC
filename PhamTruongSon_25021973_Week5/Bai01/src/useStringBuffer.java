
public class useStringBuffer {

    public useStringBuffer() {

    }

    public void calcTimeUsingStringBuffer() {
        long startTime = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < 100000; i++) {
            sb.append("Hello");
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time using stringBuffer: " + (endTime - startTime));
    }
}
