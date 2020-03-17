package academy.pocu.comp2500samples.w04.staticlogger;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        try {
            StaticLogger.loadConfig();
            StaticLogger.logDebug("Printed if the minimum log level is DEBUG");
            StaticLogger.logInformation("Printed if the minimum log level is INFORMATION or lower");
            StaticLogger.logWarning("Printed if the minimum log level is WARNING or lower");
            StaticLogger.logError("Printed if the minimum log level is ERROR or lower");
            StaticLogger.logCritical("Printed if the minimum log level is CRITICAL or lower");

            int x = 10;
            int y = 20;

            StaticLogger.logDebug("%d * %d = %d", x, y, x * y);
            StaticLogger.logInformation("%d * %d = %d", x, y, x * y);
            StaticLogger.logWarning("%d * %d = %d", x, y, x * y);
            StaticLogger.logError("%d * %d = %d", x, y, x * y);
            StaticLogger.logCritical("%d * %d = %d", x, y, x * y);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
