package academy.pocu.comp2500samples.w04.staticlogger;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        try {
            StaticLogger.loadConfig();
            StaticLogger.logDebug("Printed if LogLevel is DEBUG");
            StaticLogger.logInformation("Printed if LogLevel is INFORMATION or lower");
            StaticLogger.logWarning("Printed if LogLevel is WARNING or lower");
            StaticLogger.logError("Printed if LogLevel is ERROR or lower");
            StaticLogger.logCritical("Printed if LogLevel is CRITICAL or lower");

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
