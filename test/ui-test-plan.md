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

## Test case 3: Prompt for missing deadline date

**Aim:** Confirm Amy rejects a deadline without `/by` text instead of displaying an empty deadline.

**Inputs:**
```text
deadline return books
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
Please specify a deadline in the format: deadline <description> /by <date/time>.
________________________________________________________________________________
________________________________________________________________________________
Bye. Hope to see you again soon!
________________________________________________________________________________
```
## Test case 4: Mark a task done

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

## Test case 5: Unmark a task

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

## Test case 6: Mark invalid index

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

## Test case 7: Prompt for incomplete event

**Aim:** Confirm Amy requires both `/from` and `/to` values for an event.

**Inputs:**
```text
event project meeting /from Mon 2pm
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
Please specify an event in the format: event <description> /from <start> /to <end>.
________________________________________________________________________________
________________________________________________________________________________
Bye. Hope to see you again soon!
________________________________________________________________________________
```

## Test case 8: Accept spaced deadline marker

**Aim:** Confirm Amy accepts a deadline marker written as `/ by` and preserves the time text.

**Inputs:**
```text
deadline water plants / by tmr 3pm
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
  [D][ ] water plants (by: tmr 3pm)
Now you have 1 tasks in the list.
________________________________________________________________________________
________________________________________________________________________________
Bye. Hope to see you again soon!
________________________________________________________________________________
```

## Test case 9: Add typed tasks

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

## Test case 10: Accept shorthand event times

**Aim:** Confirm Amy accepts an event with two slash-separated times without `/from` and `/to` labels.

**Inputs:**
```text
event pauls birthday/ 7pm/ 10pm
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
  [E][ ] pauls birthday (from: 7pm to: 10pm)
Now you have 1 tasks in the list.
________________________________________________________________________________
________________________________________________________________________________
Bye. Hope to see you again soon!
________________________________________________________________________________
```

## Test case 11: Valid todo survives invalid deadline

**Aim:** Confirm an invalid deadline does not add a task or alter the existing todo.

**Inputs:**
```text
todo water plants
deadline return books
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
  [T][ ] water plants
Now you have 1 tasks in the list.
________________________________________________________________________________
________________________________________________________________________________
Please specify a deadline in the format: deadline <description> /by <date/time>.
________________________________________________________________________________
________________________________________________________________________________
Here are the tasks in your list:
1.[T][ ] water plants
________________________________________________________________________________
________________________________________________________________________________
Bye. Hope to see you again soon!
________________________________________________________________________________
```

## Test case 12: Valid deadline survives invalid event

**Aim:** Confirm an invalid event does not add a task or alter the existing deadline.

**Inputs:**
```text
deadline return books /by Sunday
event project meeting /from Mon 2pm
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
  [D][ ] return books (by: Sunday)
Now you have 1 tasks in the list.
________________________________________________________________________________
________________________________________________________________________________
Please specify an event in the format: event <description> /from <start> /to <end>.
________________________________________________________________________________
________________________________________________________________________________
Here are the tasks in your list:
1.[D][ ] return books (by: Sunday)
________________________________________________________________________________
________________________________________________________________________________
Bye. Hope to see you again soon!
________________________________________________________________________________
```

## Test case 13: Invalid mark preserves status

**Aim:** Confirm a malformed mark command does not change a task's done status.

**Inputs:**
```text
todo read book
mark nope
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
  [T][ ] read book
Now you have 1 tasks in the list.
________________________________________________________________________________
________________________________________________________________________________
Please specify a valid task number.
________________________________________________________________________________
________________________________________________________________________________
Here are the tasks in your list:
1.[T][ ] read book
________________________________________________________________________________
________________________________________________________________________________
Bye. Hope to see you again soon!
________________________________________________________________________________
```

## Test case 14: Optional deadline marker

**Aim:** Confirm a deadline accepts the shorthand slash form without the `by` label.

**Inputs:**
```text
deadline water plants/ tmr
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
  [D][ ] water plants (by: tmr)
Now you have 1 tasks in the list.
________________________________________________________________________________
________________________________________________________________________________
Bye. Hope to see you again soon!
________________________________________________________________________________
```

## Test case 15: Unmark invalid index

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
