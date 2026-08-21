/**
 * Represents a task occurring during a specified time range.
 */
public class Event extends Task {
    protected String from;
    protected String to;

    /**
     * Creates an incomplete event.
     *
     * @param description the event description
     * @param from the event start time text
     * @param to the event end time text
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String getTypeIcon() {
        return "E";
    }

    @Override
    public String getDisplayText() {
        return description + " (from: " + from + " to: " + to + ")";
    }
}
