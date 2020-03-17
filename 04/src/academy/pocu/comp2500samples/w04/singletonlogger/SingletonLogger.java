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

public class SingletonLogger {
    private static final String CONFIG_FILE_NAME = "logger-config.txt";

    private static SingletonLogger instance;

    private LogLevel logLevel;
    private String output;

    private SingletonLogger(LogLevel logLevel, String output) {
        this.logLevel = logLevel;
        this.output = output;
    }

    public static SingletonLogger getInstance() throws IOException {
        if (instance == null) {
            String classPath = getClassPath();
            Path loggerConfigPath = Paths.get(classPath, CONFIG_FILE_NAME);

            File configFile = new File(loggerConfigPath.toString());

            LogLevel defaultLogLevel = LogLevel.WARNING;
            String outputFileName = "log.txt";

            if (configFile.isFile()) {
                List<String> lines = Files.readAllLines(loggerConfigPath, StandardCharsets.UTF_8);

                for (String line : lines) {
                    String[] splits = line.split("=");

                    switch (splits[0]) {
                        case "loglevel":
                            defaultLogLevel = LogLevel.valueOf(splits[1]);
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
            String outputPathString = outputPath.toString();

            BufferedWriter out = new BufferedWriter(new FileWriter(outputPathString));
            out.close();

            instance = new SingletonLogger(defaultLogLevel, outputPathString);
        }

        return instance;
    }

    public void logDebug(String message, Object ... args) throws IOException {
        if (this.logLevel.getLogLevel() <= LogLevel.DEBUG.getLogLevel()) {
            writeToFile(output, message);
        }
    }

    public void logInformation(String message, Object ... args) throws IOException {
        if (this.logLevel.getLogLevel() <= LogLevel.INFORMATION.getLogLevel()) {
            writeToFile(output, message);
        }
    }

    public void logWarning(String message, Object ... args) throws IOException {
        if (this.logLevel.getLogLevel() <= LogLevel.WARNING.getLogLevel()) {
            writeToFile(output, message);
        }
    }

    public void logError(String message, Object ... args) throws IOException {
        if (this.logLevel.getLogLevel() <= LogLevel.ERROR.getLogLevel()) {
            writeToFile(output, message);
        }
    }

    public void logCritical(String message, Object ... args) throws IOException {
        if (this.logLevel.getLogLevel() <= LogLevel.CRITICAL.getLogLevel()) {
            writeToFile(output, message);
        }
    }

    private void writeToFile(String fileName, String str) throws IOException {
        String log = String.format("[%s] %s", Instant.now().toString(), str);

        BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
        out.write(log);
        out.newLine();
        out.close();
    }

    private static String getClassPath() {
        Path p1 = Paths.get(".").toAbsolutePath().normalize();

        File f = new File(SingletonLogger.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String packageName = SingletonLogger.class.getPackageName();
        packageName = packageName.replace('.', '/');

        Path p = Paths.get(f.getPath(), packageName);

        return p.toAbsolutePath().normalize().toString();
    }
}
