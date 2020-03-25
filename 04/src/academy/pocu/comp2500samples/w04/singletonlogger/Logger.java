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
    private static final String CONFIG_FILENAME = "logger-config.txt";

    private static Logger instance;

    private LogLevel minLogLevel;
    private String outputPath;
    private BufferedWriter outBuffer;

    private Logger(LogLevel minLogLevel, String outputPath) {
        this.minLogLevel = minLogLevel;
        this.outputPath = outputPath;

        try {
            this.outBuffer = new BufferedWriter(new FileWriter(this.outputPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            try {
                String classPath = getClassPath();
                Path loggerConfigPath = Paths.get(classPath, CONFIG_FILENAME);

                File configFile = new File(loggerConfigPath.toString());

                LogLevel logLevel = LogLevel.WARNING;
                String outputFilename = "log.txt";

                if (configFile.isFile()) {
                    List<String> lines = Files.readAllLines(loggerConfigPath, StandardCharsets.UTF_8);

                    for (String line : lines) {
                        String[] splits = line.split("=");

                        switch (splits[0]) {
                            case "loglevel":
                                logLevel = LogLevel.valueOf(splits[1]);
                                break;

                            case "output":
                                outputFilename = splits[1];
                                break;

                            default:
                                throw new IllegalArgumentException("Unknown configuration setting: " + splits[0]);
                        }
                    }
                }

                Path path = Paths.get(classPath, outputFilename);
                String pathString = path.toString();

                instance = new Logger(logLevel, pathString);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return instance;
    }

    public void deleteInstance() {
        if (this.outBuffer != null) {
            try {
                this.outBuffer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void logDebug(String message, Object... args) {
        writeToFile(LogLevel.DEBUG, message, args);
    }

    public void logInformation(String message, Object... args) {
        writeToFile(LogLevel.INFORMATION, message, args);
    }

    public void logWarning(String message, Object... args) {
        writeToFile(LogLevel.WARNING, message, args);
    }

    public void logError(String message, Object... args) {
        writeToFile(LogLevel.ERROR, message, args);
    }

    public void logCritical(String message, Object... args) {
        writeToFile(LogLevel.CRITICAL, message, args);
    }

    private void writeToFile(LogLevel logLevel, String message, Object... args) {
        if (this.minLogLevel.getLogLevel() <= logLevel.getLogLevel()) {
            try {
                String log = String.format("[%s] %s: %s", Instant.now().toString(), logLevel.toString(), String.format(message, args));
                this.outBuffer.write(log);
                this.outBuffer.newLine();
                this.outBuffer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
