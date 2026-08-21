# Amy UI test plan

## Test case 1: Exit immediately

**Aim:** Confirm that Amy prints the farewell and exits when the user enters `bye`.

**Inputs:**
```text
bye
```

**Expected output:**
```text
________________________________________________________________________________
  A     m   m  y   y
 A A    mm mm   y y
AAAAA   m m m    y
A   A   m   m    y
A   A   m   m    y
Hello! I'm Amy.
What can I do for you?
________________________________________________________________________________
________________________________________________________________________________
Bye. Hope to see you again soon!
________________________________________________________________________________
```

## Test case 2: Prompt for missing task type

**Aim:** Confirm Amy prompts when task text has no todo, deadline, or event prefix.

**Inputs:**
```text
visit theme park
bye
```

**Expected output:**
```text
________________________________________________________________________________
  A     m   m  y   y
 A A    mm mm   y y
AAAAA   m m m    y
A   A   m   m    y
A   A   m   m    y
Hello! I'm Amy.
What can I do for you?
________________________________________________________________________________
________________________________________________________________________________
Please specify a task type: todo, deadline, or event.
________________________________________________________________________________
________________________________________________________________________________
Bye. Hope to see you again soon!
________________________________________________________________________________
```
## Test case 3: Mark a task done

**Aim:** Confirm Amy marks an existing task as done and shows `[X]` in `list`.

**Inputs:**
```text
todo buy milk
mark 1
list
bye
```

**Expected output:**
```text
________________________________________________________________________________
  A     m   m  y   y
 A A    mm mm   y y
AAAAA   m m m    y
A   A   m   m    y
A   A   m   m    y
Hello! I'm Amy.
What can I do for you?
________________________________________________________________________________
________________________________________________________________________________
Got it. I've added this task:
  [T][ ] buy milk
Now you have 1 tasks in the list.
________________________________________________________________________________
________________________________________________________________________________
Nice! I've marked this task as done:
  [T][X] buy milk
________________________________________________________________________________
________________________________________________________________________________
Here are the tasks in your list:
1.[T][X] buy milk
________________________________________________________________________________
________________________________________________________________________________
Bye. Hope to see you again soon!
________________________________________________________________________________
```

## Test case 4: Unmark a task

**Aim:** Confirm Amy reverses a completed task back to not done.

**Inputs:**
```text
todo buy milk
mark 1
unmark 1
list
bye
```

**Expected output:**
```text
________________________________________________________________________________
  A     m   m  y   y
 A A    mm mm   y y
AAAAA   m m m    y
A   A   m   m    y
A   A   m   m    y
Hello! I'm Amy.
What can I do for you?
________________________________________________________________________________
________________________________________________________________________________
Got it. I've added this task:
  [T][ ] buy milk
Now you have 1 tasks in the list.
________________________________________________________________________________
________________________________________________________________________________
Nice! I've marked this task as done:
  [T][X] buy milk
________________________________________________________________________________
________________________________________________________________________________
OK, I've marked this task as not done yet:
  [T][ ] buy milk
________________________________________________________________________________
________________________________________________________________________________
Here are the tasks in your list:
1.[T][ ] buy milk
________________________________________________________________________________
________________________________________________________________________________
Bye. Hope to see you again soon!
________________________________________________________________________________
```

## Test case 5: Mark invalid index

**Aim:** Confirm Amy handles marking a non-existent task gracefully.

**Inputs:**
```text
todo buy milk
mark 5
bye
```

**Expected output:**
```text
________________________________________________________________________________
  A     m   m  y   y
 A A    mm mm   y y
AAAAA   m m m    y
A   A   m   m    y
A   A   m   m    y
Hello! I'm Amy.
What can I do for you?
________________________________________________________________________________
________________________________________________________________________________
Got it. I've added this task:
  [T][ ] buy milk
Now you have 1 tasks in the list.
________________________________________________________________________________
________________________________________________________________________________
That task does not exist.
________________________________________________________________________________
________________________________________________________________________________
Bye. Hope to see you again soon!
________________________________________________________________________________
```

## Test case 6: Add typed tasks

**Aim:** Confirm Amy stores todos, deadlines, and events with their type and date/time text.

**Inputs:**
```text
todo borrow book
deadline return book /by Sunday
event project meeting /from Mon 2pm /to 4pm
list
bye
```

**Expected output:**
```text
________________________________________________________________________________
  A     m   m  y   y
 A A    mm mm   y y
AAAAA   m m m    y
A   A   m   m    y
A   A   m   m    y
Hello! I'm Amy.
What can I do for you?
________________________________________________________________________________
________________________________________________________________________________
Got it. I've added this task:
  [T][ ] borrow book
Now you have 1 tasks in the list.
________________________________________________________________________________
________________________________________________________________________________
Got it. I've added this task:
  [D][ ] return book (by: Sunday)
Now you have 2 tasks in the list.
________________________________________________________________________________
________________________________________________________________________________
Got it. I've added this task:
  [E][ ] project meeting (from: Mon 2pm to: 4pm)
Now you have 3 tasks in the list.
________________________________________________________________________________
________________________________________________________________________________
Here are the tasks in your list:
1.[T][ ] borrow book
2.[D][ ] return book (by: Sunday)
3.[E][ ] project meeting (from: Mon 2pm to: 4pm)
________________________________________________________________________________
________________________________________________________________________________
Bye. Hope to see you again soon!
________________________________________________________________________________
```

## Test case 7: Unmark invalid index

**Aim:** Confirm Amy handles unmarking a non-existent task gracefully.

**Inputs:**
```text
todo buy milk
unmark 5
bye
```

**Expected output:**
```text
________________________________________________________________________________
  A     m   m  y   y
 A A    mm mm   y y
AAAAA   m m m    y
A   A   m   m    y
A   A   m   m    y
Hello! I'm Amy.
What can I do for you?
________________________________________________________________________________
________________________________________________________________________________
Got it. I've added this task:
  [T][ ] buy milk
Now you have 1 tasks in the list.
________________________________________________________________________________
________________________________________________________________________________
That task does not exist.
________________________________________________________________________________
________________________________________________________________________________
Bye. Hope to see you again soon!
________________________________________________________________________________
```
