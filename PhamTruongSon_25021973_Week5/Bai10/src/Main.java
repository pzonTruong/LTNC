import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập đường dẫn file config: ");
        String filePath = sc.nextLine();

        Map<String, String> configMap = new HashMap<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;

            // 1. Đọc và tách Key=Value
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty() || !line.contains("=")) continue;
                
                String[] parts = line.split("=", 2);
                String key = parts[0].trim();
                String value = parts[1].trim();
                configMap.put(key, value);
            }

            // 2. Kiểm tra logic dữ liệu
            validateConfig(configMap);

            // 3. Nếu mọi thứ ổn áp
            System.out.println("\n--- Nội dung cấu hình ---");
            configMap.forEach((k, v) -> System.out.println(k + " : " + v));
            System.out.println("Config loaded successfully.");

        } catch (FileNotFoundException e) {
            System.err.println("Config file not found.");
        } catch (IOException e) {
            System.err.println("I/O error.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format.");
        } catch (InvalidConfigException e) {
            System.err.println(e.getMessage());
        } finally {
            System.out.println("Program finished.");
            try {
                if (reader != null) reader.close();
                sc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void validateConfig(Map<String, String> config) throws InvalidConfigException {
        // Kiểm tra bắt buộc có username và timeout
        if (!config.containsKey("username")) {
            throw new InvalidConfigException("Missing username.");
        }
        if (!config.containsKey("timeout")) {
            throw new InvalidConfigException("Missing timeout.");
        }

        // Kiểm tra timeout (phải là số nguyên > 0)
        int timeout = Integer.parseInt(config.get("timeout"));
        if (timeout <= 0) {
            throw new InvalidConfigException("timeout must be > 0.");
        }

        // Kiểm tra maxConnections nếu có (phải >= 1)
        if (config.containsKey("maxConnections")) {
            int maxConn = Integer.parseInt(config.get("maxConnections"));
            if (maxConn < 1) {
                throw new InvalidConfigException("maxConnections must be >= 1.");
            }
        }
    }
}