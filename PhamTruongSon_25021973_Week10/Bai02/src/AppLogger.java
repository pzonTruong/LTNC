import java.util.logging.*;
import java.io.IOException;
import java.io.File;

public class AppLogger {
    private static final Logger logger = Logger.getLogger(AppLogger.class.getName());

    public static void setup() {
        LogManager.getLogManager().reset();
        logger.setLevel(Level.ALL);

        // Console Handler
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.ALL);
        ch.setFormatter(new SimpleFormatter());
        logger.addHandler(ch);

        try {
            // File Handler
            File logDir = new File("logs");
            if (!logDir.exists()) {
                logDir.mkdir();
            }
            FileHandler fh = new FileHandler("logs/server.log", true);
            fh.setLevel(Level.ALL);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Logger could not be initialized", e);
        }
    }

    public static Logger getLogger() {
        return logger;
    }
}
