import java.util.Scanner;

public class Amy {
    public static void main(String[] args) {
        String separator = "_".repeat(80);
        String banner = "  A     m   m  y   y\n"
                + " A A    mm mm   y y\n"
                + "AAAAA   m m m    y\n"
                + "A   A   m   m    y\n"
                + "A   A   m   m    y\n";

        System.out.println(separator);
        System.out.print(banner);
        System.out.println("Hello! I'm Amy.");
        System.out.println("What can I do for you?");
        System.out.println(separator);

        Task[] tasks = new Task[100];
        int taskCount = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            String normalizedCommand = command.trim();
            System.out.println(separator);

            if (normalizedCommand.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println(separator);
                break;
            }

            if (normalizedCommand.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < taskCount; i++) {
                    System.out.println((i + 1) + "." + tasks[i].getFullDisplayText());
                }
            } else if (normalizedCommand.startsWith("mark ")) {
                try {
                    int taskNumber = Integer.parseInt(normalizedCommand.substring(5).trim());
                    int taskIndex = taskNumber - 1;
                    if (taskIndex >= 0 && taskIndex < taskCount) {
                        tasks[taskIndex].markAsDone();
                        System.out.println("Nice! I've marked this task as done:");
                        System.out.println("  " + tasks[taskIndex].getFullDisplayText());
                    } else {
                        System.out.println("That task does not exist.");
                    }
                } catch (NumberFormatException ignored) {
                    System.out.println("Please specify a valid task number.");
                }
            } else if (normalizedCommand.startsWith("unmark ")) {
                try {
                    int taskNumber = Integer.parseInt(normalizedCommand.substring(7).trim());
                    int taskIndex = taskNumber - 1;
                    if (taskIndex >= 0 && taskIndex < taskCount) {
                        tasks[taskIndex].unmarkAsDone();
                        System.out.println("OK, I've marked this task as not done yet:");
                        System.out.println("  " + tasks[taskIndex].getFullDisplayText());
                    } else {
                        System.out.println("That task does not exist.");
                    }
                } catch (NumberFormatException ignored) {
                    System.out.println("Please specify a valid task number.");
                }
            } else if (isTaskCommand(normalizedCommand) && taskCount < tasks.length) {
                Task task = createTask(normalizedCommand, command);
                tasks[taskCount] = task;
                taskCount++;
                System.out.println("Got it. I've added this task:");
                System.out.println("  " + task.getFullDisplayText());
                System.out.println("Now you have " + taskCount + " tasks in the list.");
            } else if (!isTaskCommand(normalizedCommand)) {
                System.out.println("Please specify a task type: todo, deadline, or event.");
            }

            System.out.println(separator);
        }
    }

    /**
     * Converts a task command into a task object without parsing dates.
     *
     * @param normalizedCommand the trimmed command
     * @param originalCommand the original input, used as a fallback description
     * @return the task represented by the command
     */
    private static Task createTask(String normalizedCommand, String originalCommand) {
        if (normalizedCommand.startsWith("deadline ")) {
            String body = normalizedCommand.substring(9).trim();
            int byIndex = body.indexOf("/by");
            if (byIndex >= 0) {
                return new Deadline(body.substring(0, byIndex).trim(),
                        body.substring(byIndex + 3).trim());
            }
            return new Deadline(body, "");
        }
        if (normalizedCommand.startsWith("event ")) {
            String body = normalizedCommand.substring(6).trim();
            int fromIndex = body.indexOf("/from");
            int toIndex = body.indexOf("/to", fromIndex + 5);
            if (fromIndex >= 0 && toIndex >= 0) {
                String description = body.substring(0, fromIndex).trim();
                String from = body.substring(fromIndex + 5, toIndex).trim();
                String to = body.substring(toIndex + 3).trim();
                return new Event(description, from, to);
            }
            return new Event(body, "", "");
        }
        String description = normalizedCommand.startsWith("todo ")
                ? normalizedCommand.substring(5).trim()
                : originalCommand;
        return new Todo(description);
    }

    /**
     * Checks whether a command explicitly identifies a supported task type.
     *
     * @param command the trimmed user command
     * @return true when the command starts with todo, deadline, or event
     */
    private static boolean isTaskCommand(String command) {
        return command.startsWith("todo ")
                || command.startsWith("deadline ")
                || command.startsWith("event ");
    }
}
