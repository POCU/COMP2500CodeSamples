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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
