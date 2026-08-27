/**
 * Represents a task that must be completed by a specified time.
 */
public class Deadline extends Task {
    protected String by;

    /**
     * Creates an incomplete deadline.
     *
     * @param description the deadline description
     * @param by the deadline text
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String getTypeIcon() {
        return "D";
    }

    @Override
    public String getDisplayText() {
        return description + " (by: " + by + ")";
    }

    /**
     * Returns the deadline text.
     *
     * @return the deadline text
     */
    public String getBy() {
        return by;
    }

}
