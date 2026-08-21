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
                for (int i = 0; i < taskCount; i++) {
                    System.out.println((i + 1) + ". " + tasks[i]);
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
