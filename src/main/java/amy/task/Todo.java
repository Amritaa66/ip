package amy.task;

/**
 * Represents a task without a date or time.
 */
public class Todo extends Task {
    /** Creates an incomplete todo task with the given description. */
    public Todo(String description) {
        super(description);
    }
}
