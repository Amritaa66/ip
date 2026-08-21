/**
 * Represents one task in Amy's in-memory task list.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Creates an incomplete task with the given description.
     *
     * @param description the text describing the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
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
     * Returns this task's type marker.
     *
     * @return the task type marker
     */
    public String getTypeIcon() {
        return "T";
    }

    /**
     * Returns this task's display text.
     *
     * @return the task description
     */
    public String getDisplayText() {
        return description;
    }

    /**
     * Returns the complete task marker and description for output.
     *
     * @return the task's type, done status, and display text
     */
    public String getFullDisplayText() {
        return "[" + getTypeIcon() + "][" + getStatusIcon() + "] " + getDisplayText();
    }
}
