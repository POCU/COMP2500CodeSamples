package academy.pocu.comp2500samples.w04.singletonlogger;

public enum LogLevel {
    DEBUG(0),
    INFORMATION(1),
    WARNING(2),
    ERROR(3),
    CRITICAL(4);

    private int level;

    public int getLogLevel() {
        return this.level;
    }

    private LogLevel(int level) {
        this.level = level;
    }
}
