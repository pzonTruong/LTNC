import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MathUtils {
    private static final Logger logger = LoggerFactory.getLogger(MathUtils.class);

    public int add(int a, int b) {
        logger.info("Performing addition: {} + {}", a, b);
        return a + b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            logger.error("Division by zero error with divisor: {}", b);
            throw new ArithmeticException("Cannot divide by zero");
        }
        logger.debug("Dividing {} by {}", a, b);
        return a / b;
    }
}