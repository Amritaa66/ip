import java.util.ArrayList;

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

    public boolean isEmpty() { return tasks.isEmpty(); }

    public int size() { return tasks.size(); }

    public Task get(int index) { return tasks.get(index); }

    public void add(Task task) { tasks.add(task); }

    public Task remove(int index) { return tasks.remove(index); }

    /** @return the current tasks for persistence */
    public ArrayList<Task> asList() { return tasks; }
}
