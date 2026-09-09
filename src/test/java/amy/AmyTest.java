package amy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/** Tests Amy command responses and session-only undo behavior. */
class AmyTest {
    @TempDir
    Path temporaryDirectory;

    @Test
    void undo_withoutHistory_reportsUnavailable() {
        Amy amy = createAmy();

        assertEquals("There is no command to undo.", amy.getResponse("undo"));
    }

    @Test
    void undo_confirmedAdd_removesAddedTask() {
        Amy amy = createAmy();

        amy.getResponse("todo buy milk");
        assertEquals("Confirm undo: remove the task \"buy milk\"? [yes/no]", amy.getResponse("undo"));
        assertEquals("Undone. I've restored the previous task list.", amy.getResponse("yes"));
        assertEquals("There are no tasks in your list!", amy.getResponse("list"));
    }

    @Test
    void undo_invalidConfirmation_keepsConfirmationPending() {
        Amy amy = createAmy();

        amy.getResponse("todo buy milk");
        amy.getResponse("undo");
        assertEquals("Please answer yes or no.", amy.getResponse("list"));
        assertEquals("Undo cancelled.", amy.getResponse("no"));
        assertEquals("1.[T][ ] buy milk", amy.getResponse("list").split("\\n")[1]);
    }

    @Test
    void undo_multipleCommands_revertsInReverseOrder() {
        Amy amy = createAmy();

        amy.getResponse("todo first");
        amy.getResponse("todo second");
        amy.getResponse("undo");
        amy.getResponse("y");
        amy.getResponse("undo");
        amy.getResponse("yes");

        assertEquals("There are no tasks in your list!", amy.getResponse("list"));
    }

    private Amy createAmy() {
        return new Amy(temporaryDirectory.resolve("amy.txt").toString());
    }
}
