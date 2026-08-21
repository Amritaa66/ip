/**
 * Represents a task without a date or time.
 */
public class Todo extends Task {
    /**
     * Creates an incomplete todo task.
     *
     * @param description the todo description
     */
    public Todo(String description) {
        super(description);
    }
}
