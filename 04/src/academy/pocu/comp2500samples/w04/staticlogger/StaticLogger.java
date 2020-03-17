package academy.pocu.comp2500samples.w04.staticlogger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;

public class StaticLogger {
    private static final String CONFIG_FILE_NAME = "logger-config.txt";

    private static LogLevel logLevel = LogLevel.WARNING;
    private static String outputFileName = "log.txt";
    private static boolean isConfigLoaded = false;
    private static String output;

    private StaticLogger() { }

    public static void loadConfig() throws IOException {
        String classPath = getClassPath();
        Path loggerConfigPath = Paths.get(classPath, CONFIG_FILE_NAME);

        File configFile = new File(loggerConfigPath.toString());

        if (configFile.isFile()) {
            List<String> lines = Files.readAllLines(loggerConfigPath, StandardCharsets.UTF_8);

            for (String line : lines) {
                String[] splits = line.split("=");

                switch (splits[0]) {
                    case "loglevel":
                        logLevel = LogLevel.valueOf(splits[1]);
                        break;

                    case "output":
                        outputFileName = splits[1];
                        break;

                    default:
                        throw new IllegalArgumentException("Unknown configuration setting: " + splits[0]);
                }
            }
        }

        Path outputPath = Paths.get(classPath, outputFileName);
        output = outputPath.toString();

        BufferedWriter out = new BufferedWriter(new FileWriter(output));
        out.close();

        isConfigLoaded = true;
    }

    public static void logDebug(String message, Object ... args) throws IOException {
        assert (isConfigLoaded) : "Configuration not loaded";

        if (isConfigLoaded && logLevel.getLogLevel() <= LogLevel.DEBUG.getLogLevel()) {
            writeToFile(output, message, args);
        }
    }

    public static void logInformation(String message, Object ... args) throws IOException {
        assert (isConfigLoaded) : "Configuration not loaded";

        if (isConfigLoaded && logLevel.getLogLevel() <= LogLevel.INFORMATION.getLogLevel()) {
            writeToFile(output, message, args);
        }
    }

    public static void logWarning(String message, Object ... args) throws IOException {
        assert (isConfigLoaded) : "Configuration not loaded";

        if (isConfigLoaded && logLevel.getLogLevel() <= LogLevel.WARNING.getLogLevel()) {
            writeToFile(output, message, args);
        }
    }

    public static void logError(String message, Object ... args) throws IOException {
        assert (isConfigLoaded) : "Configuration not loaded";

        if (isConfigLoaded && logLevel.getLogLevel() <= LogLevel.ERROR.getLogLevel()) {
            writeToFile(output, message, args);
        }
    }

    public static void logCritical(String message, Object ... args) throws IOException {
        assert (isConfigLoaded) : "Configuration not loaded";

        if (isConfigLoaded && logLevel.getLogLevel() <= LogLevel.CRITICAL.getLogLevel()) {
            writeToFile(output, message, args);
        }
    }

    private static void writeToFile(String fileName, String str, Object ... args) throws IOException {
        String log = String.format("[%s] %s", Instant.now().toString(), String.format(str, args));

        BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
        out.write(log);
        out.newLine();
        out.close();
    }

    private static String getClassPath() {
        File f = new File(StaticLogger.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String packageName = StaticLogger.class.getPackageName();
        packageName = packageName.replace('.', '/');

        Path p = Paths.get(f.getPath(), packageName);

        return p.toAbsolutePath().normalize().toString();
    }
}
