package amy.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task that must be completed by a specified date and time.
 */
public class Deadline extends Task {
    protected LocalDateTime by;

    public static final DateTimeFormatter INPUT_FORMAT =
            DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private static final DateTimeFormatter OUTPUT_FORMAT =
            DateTimeFormatter.ofPattern("MMM d yyyy, h:mma");
    public static final DateTimeFormatter SAVE_FORMAT =
            DateTimeFormatter.ofPattern("d/M/yyyy HHmm");

    /**
     * Creates an incomplete deadline.
     *
     * @param description the deadline description
     * @param by the deadline date and time, in the format d/M/yyyy HHmm (e.g. 2/12/2019 1800)
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = LocalDateTime.parse(by, INPUT_FORMAT);
    }

    @Override
    public String getTypeIcon() {
        return "D";
    }

    @Override
    public String getDisplayText() {
        return description + " (by: " + by.format(OUTPUT_FORMAT) + ")";
    }

    /**
     * Returns the deadline date and time.
     *
     * @return the deadline date and time
     */
    public LocalDateTime getBy() {
        return by;
    }
}
