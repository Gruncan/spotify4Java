package dev.gruncan.spotify.requests.util;

import java.util.Locale;

public enum TimeRange {

    LONG_TERM("Calculated from several years of data and including all new data as it becomes available"),
    MEDIUM_TERM("Approximately last 6 months"),
    SHORT_TERM("Approximately last 4 weeks");

    private final String description;

    TimeRange(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return super.name().toLowerCase(Locale.ROOT);
    }


}
