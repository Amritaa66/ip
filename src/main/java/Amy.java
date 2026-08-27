import java.io.IOException;
import java.util.ArrayList;

public class Amy {
    public static void main(String[] args) {
        Ui ui = new Ui();
        Parser parser = new Parser();
        Storage storage = new Storage("data/amy.txt");
        ui.showWelcome();

        TaskList tasks = new TaskList(loadTasks(storage));
        while (ui.hasNextCommand()) {
            String command = ui.readCommand();
            String normalizedCommand = command.trim();
            ui.showSeparator();

            try {
            if (normalizedCommand.equals("bye")) {
                ui.showFarewell();
                break;
            }

            if (normalizedCommand.equals("list")) {
                if (tasks.isEmpty()) {
                    ui.showMessage("There are no tasks in your list!");
                } else {
                    ui.showMessage("Here are the tasks in your list:");
                    for (int i = 0; i < tasks.size(); i++) {
                        ui.showMessage((i + 1) + "." + tasks.get(i).getFullDisplayText());
                    }
                }
            } else if (normalizedCommand.equals("mark")
                    || normalizedCommand.equals("unmark")
                    || normalizedCommand.equals("delete")) {
                throw new AmyException("Please provide a task number.");
            } else if (normalizedCommand.startsWith("mark ")) {
                try {
                    int taskNumber = Integer.parseInt(normalizedCommand.substring(5).trim());
                    int taskIndex = taskNumber - 1;
                    if (taskIndex >= 0 && taskIndex < tasks.size()) {
                        tasks.mark(taskIndex);
                        saveTasks(storage, tasks.asList());
                        ui.showMessage("Nice! I've marked this task as done:");
                        ui.showMessage("  " + tasks.get(taskIndex).getFullDisplayText());
                    } else {
                        throw new AmyException("That task does not exist.");
                    }
                } catch (NumberFormatException ignored) {
                    throw new AmyException("Please specify a valid task number.");
                }
            } else if (normalizedCommand.startsWith("unmark ")) {
                try {
                    int taskNumber = Integer.parseInt(normalizedCommand.substring(7).trim());
                    int taskIndex = taskNumber - 1;
                    if (taskIndex >= 0 && taskIndex < tasks.size()) {
                        tasks.unmark(taskIndex);
                        saveTasks(storage, tasks.asList());
                        ui.showMessage("OK, I've marked this task as not done yet:");
                        ui.showMessage("  " + tasks.get(taskIndex).getFullDisplayText());
                    } else {
                        throw new AmyException("That task does not exist.");
                    }
                } catch (NumberFormatException ignored) {
                    throw new AmyException("Please specify a valid task number.");
                }
            } else if (normalizedCommand.startsWith("delete ")) {
                try {
                    int taskNumber = Integer.parseInt(normalizedCommand.substring(7).trim());
                    int taskIndex = taskNumber - 1;
                    if (taskIndex >= 0 && taskIndex < tasks.size()) {
                        Task deletedTask = tasks.get(taskIndex);
                        tasks.remove(taskIndex);
                        saveTasks(storage, tasks.asList());
                        ui.showMessage("Noted. I've removed this task:");
                        ui.showMessage("  " + deletedTask.getFullDisplayText());
                        ui.showMessage("Now you have " + tasks.size() + " tasks in the list.");
                    } else {
                        throw new AmyException("That task does not exist.");
                    }
                } catch (NumberFormatException ignored) {
                    throw new AmyException("Please specify a valid task number.");
                }
            } else if (parser.isTaskCommand(normalizedCommand)) {
                Task task = parser.createTask(normalizedCommand, command);
                if (task != null) {
                    tasks.add(task);
                    saveTasks(storage, tasks.asList());
                    ui.showMessage("Got it. I've added this task:");
                    ui.showMessage("  " + task.getFullDisplayText());
                    ui.showMessage("Now you have " + tasks.size() + " tasks in the list.");
                } else if (normalizedCommand.startsWith("deadline ")) {
                    throw new AmyException("Please specify a deadline in the format: "
                            + "deadline <description> /by <date/time>.");
                } else {
                    throw new AmyException("Please specify an event in the format: "
                            + "event <description> /from <start> /to <end>.");
                }
            } else if (!parser.isTaskCommand(normalizedCommand)) {
                throw new AmyException("I'm sorry, but I don't know what that means.");
            }
            } catch (AmyException exception) {
                ui.showMessage(exception.getMessage());
            }

            ui.showSeparator();
        }
    }

    /**
     * Saves the task list and reports an error if the hard disk cannot be written.
     *
     * @param tasks the current task list
     */
    private static void saveTasks(Storage storage, ArrayList<Task> tasks) {
        try {
            storage.save(tasks);
        } catch (IOException | SecurityException exception) {
            System.out.println("Unable to save tasks to the hard disk.");
        }
    }

    /**
     * Loads the previous task list and starts with an empty list if it cannot be read.
     *
     * @return the tasks loaded from the hard disk
     */
    private static ArrayList<Task> loadTasks(Storage storage) {
        try {
            return storage.load();
        } catch (IOException | SecurityException exception) {
            System.out.println("Unable to load tasks from the hard disk.");
            return new ArrayList<>();
        }
    }

}
