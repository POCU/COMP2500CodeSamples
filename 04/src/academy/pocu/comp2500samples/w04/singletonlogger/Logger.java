package academy.pocu.comp2500samples.w04.singletonlogger;

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

public class Logger {
    private static final String CONFIG_FILE_NAME = "logger-config.txt";

    private static Logger instance;

    private LogLevel minLogLevel;
    private String outputLogFilePath;

    private Logger(LogLevel minLogLevel, String outputLogFilePath) {
        this.minLogLevel = minLogLevel;
        this.outputLogFilePath = outputLogFilePath;
    }

    public static Logger getInstance() throws IOException {
        if (instance == null) {
            String classPath = getClassPath();
            Path loggerConfigPath = Paths.get(classPath, CONFIG_FILE_NAME);

            File configFile = new File(loggerConfigPath.toString());

            LogLevel defaultLogLevel = LogLevel.WARNING;
            String defaultOutputFilename = "log.txt";

            if (configFile.isFile()) {
                List<String> lines = Files.readAllLines(loggerConfigPath, StandardCharsets.UTF_8);

                for (String line : lines) {
                    String[] splits = line.split("=");

                    switch (splits[0]) {
                        case "loglevel":
                            defaultLogLevel = LogLevel.valueOf(splits[1]);
                            break;

                        case "output":
                            defaultOutputFilename = splits[1];
                            break;

                        default:
                            throw new IllegalArgumentException("Unknown configuration setting: " + splits[0]);
                    }
                }
            }

            Path path = Paths.get(classPath, defaultOutputFilename);
            String pathString = path.toString();

            BufferedWriter out = new BufferedWriter(new FileWriter(pathString));
            out.close();

            instance = new Logger(defaultLogLevel, pathString);
        }

        return instance;
    }

    public void logDebug(String message, Object ... args) throws IOException {
        writeToFile(LogLevel.DEBUG, message, args);
    }

    public void logInformation(String message, Object ... args) throws IOException {
        writeToFile(LogLevel.INFORMATION, message, args);
    }

    public void logWarning(String message, Object ... args) throws IOException {
        writeToFile(LogLevel.WARNING, message, args);
    }

    public void logError(String message, Object ... args) throws IOException {
        writeToFile(LogLevel.ERROR, message, args);
    }

    public void logCritical(String message, Object ... args) throws IOException {
        writeToFile(LogLevel.CRITICAL, message, args);
    }

    private void writeToFile(LogLevel logLevel, String message, Object ... args) throws IOException {
        if (this.minLogLevel.getLogLevel() <= logLevel.getLogLevel()) {
            String log = String.format("[%s] %s: %s", Instant.now().toString(), logLevel.toString(), String.format(message, args));

            BufferedWriter out = new BufferedWriter(new FileWriter(this.outputLogFilePath, true));
            out.write(log);
            out.newLine();
            out.close();
        }
    }

    private static String getClassPath() {
        File f = new File(Logger.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String packageName = Logger.class.getPackageName();
        packageName = packageName.replace('.', '/');

        Path p = Paths.get(f.getPath(), packageName);

        return p.toAbsolutePath().normalize().toString();
    }
}
