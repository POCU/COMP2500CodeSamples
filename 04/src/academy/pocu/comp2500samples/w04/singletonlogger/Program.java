package academy.pocu.comp2500samples.w04.singletonlogger;

import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        try {
            SingletonLogger logger = SingletonLogger.getInstance();
            logger.logDebug("Printed if LogLevel is DEBUG");
            logger.logInformation("Printed if LogLevel is INFORMATION or lower");
            logger.logWarning("Printed if LogLevel is WARNING or lower");
            logger.logError("Printed if LogLevel is ERROR or lower");
            logger.logCritical("Printed if LogLevel is CRITICAL or lower");

            int x = 10;
            int y = 20;

            logger.logDebug("%d * %d = %d", x, y, x * y);
            logger.logInformation("%d * %d = %d", x, y, x * y);
            logger.logWarning("%d * %d = %d", x, y, x * y);
            logger.logError("%d * %d = %d", x, y, x * y);
            logger.logCritical("%d * %d = %d", x, y, x * y);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
