/**
 * Represents one task in Amy's in-memory task list.
 */
public class Task {
    protected String description;
    protected boolean isDone;
    protected String type;
    protected String dateTimeInfo;

    /**
     * Creates an incomplete task with the given description.
     *
     * @param description the text describing the task
     */
    public Task(String description) {
        this(description, "T", "");
    }

    /**
     * Creates an incomplete task with a type and optional date/time text.
     *
     * @param description the text describing the task
     * @param type the task type marker, such as T, D, or E
     * @param dateTimeInfo the date/time detail, without display labels
     */
    public Task(String description, String type, String dateTimeInfo) {
        this.description = description;
        this.isDone = false;
        this.type = type;
        this.dateTimeInfo = dateTimeInfo;
    }

    /**
     * Returns the status icon used when displaying this task.
     *
     * @return {@code X} for a completed task, or a space otherwise
     */
    public String getStatusIcon() {
        return isDone ? "X" : " ";
    }

    /**
     * Marks this task as completed.
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Marks this task as incomplete.
     */
    public void unmarkAsDone() {
        isDone = false;
    }

    /**
     * Returns this task's description.
     *
     * @return the task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the task type marker.
     *
     * @return the task type marker
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the task text including its date/time detail when present.
     *
     * @return the displayable task text
     */
    public String getDisplayText() {
        if (dateTimeInfo.isEmpty()) {
            return description;
        }
        String label = type.equals("D") ? "by: " : "from: ";
        String suffix = type.equals("D")
                ? "(" + label + dateTimeInfo + ")"
                : "(" + label + dateTimeInfo + ")";
        return description + " " + suffix;
    }

    /**
     * Returns the complete task marker and description for output.
     *
     * @return the task's type, done status, and display text
     */
    public String getFullDisplayText() {
        return "[" + type + "][" + getStatusIcon() + "] " + getDisplayText();
    }
}
