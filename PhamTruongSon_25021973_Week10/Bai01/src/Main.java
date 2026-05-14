public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Main <server|client>");
            return;
        }

        String mode = args[0].toLowerCase();
        if (mode.equals("server")) {
            EchoServer.main(new String[]{});
        } else if (mode.equals("client")) {
            EchoClient.main(new String[]{});
        } else {
            System.out.println("Unknown mode: " + mode);
            System.out.println("Usage: java Main <server|client>");
        }
    }
}
