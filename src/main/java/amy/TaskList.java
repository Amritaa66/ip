package amy;

import java.util.ArrayList;
import amy.task.Task;

/**
 * Stores Amy's tasks and provides operations for changing the collection.
 */
public class TaskList {
    private final ArrayList<Task> tasks;

    /**
     * Creates a task list containing the supplied tasks.
     *
     * @param tasks the initial tasks
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /** Creates an empty task list. */
    public TaskList() {
        this(new ArrayList<>());
    }

    /** @return true when this list contains no tasks. */
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    /** @return the number of tasks in this list. */
    public int size() {
        return tasks.size();
    }

    /** @return the task at the specified zero-based index. */
    public Task get(int index) {
        return tasks.get(index);
    }

    /** Adds a task to the end of this list. */
    public void add(Task task) {
        tasks.add(task);
    }

    /** Removes and returns the task at the specified zero-based index. */
    public Task remove(int index) {
        return tasks.remove(index);
    }

    /** Marks the task at the given zero-based index as done. */
    public void mark(int index) {
        tasks.get(index).markAsDone();
    }

    /** Marks the task at the given zero-based index as not done. */
    public void unmark(int index) {
        tasks.get(index).unmarkAsDone();
    }

    /** @return the current tasks for persistence */
    public ArrayList<Task> asList() {
        return tasks;
    }
}
