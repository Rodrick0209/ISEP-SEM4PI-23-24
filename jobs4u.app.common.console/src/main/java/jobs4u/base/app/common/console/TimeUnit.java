package jobs4u.base.app.common.console;

public enum TimeUnit {
    MILLISECONDS,
    SECONDS,
    MINUTES,
    HOURS,
    DAYS;

    public long toMillis(long duration) {
        switch (this) {
            case MILLISECONDS:
                return duration;
            case SECONDS:
                return duration * 1000;
            case MINUTES:
                return duration * 1000 * 60;
            case HOURS:
                return duration * 1000 * 60 * 60;
            case DAYS:
                return duration * 1000 * 60 * 60 * 24;
            default:
                throw new IllegalArgumentException("Invalid TimeUnit");
        }
    }
}

