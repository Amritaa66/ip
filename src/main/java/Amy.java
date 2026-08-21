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

        String[] tasks = new String[100];
        boolean[] completed = new boolean[100];
        int taskCount = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            System.out.println(separator);

            if (command.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println(separator);
                break;
            }

            if (command.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < taskCount; i++) {
                    String status = completed[i] ? "[X] " : "[ ] ";
                    System.out.println((i + 1) + "." + status + tasks[i]);
                }
            } else if (command.startsWith("mark ")) {
                try {
                    int taskNumber = Integer.parseInt(command.substring(5).trim());
                    int taskIndex = taskNumber - 1;
                    if (taskIndex >= 0 && taskIndex < taskCount) {
                        completed[taskIndex] = true;
                        System.out.println("Nice! I've marked this task as done:");
                        System.out.println("  [X] " + tasks[taskIndex]);
                    }
                } catch (NumberFormatException ignored) {
                    // Ignore malformed mark commands.
                }
            } else if (taskCount < tasks.length) {
                tasks[taskCount] = command;
                taskCount++;
                System.out.println("added: " + command);
            }

            System.out.println(separator);
        }
    }
}
