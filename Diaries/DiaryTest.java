import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiaryTest {

    private Diary diary;

    @BeforeEach
    public void testThatANewDiaryIsCreated() {
        diary = new Diary("yusuf_umaru", "secret123");
    }

    @Test
    public void testThatNewDiaryIsLockedByDefault() {
        assertTrue(diary.isLocked());
    }

    @Test
    public void testThatDiaryCanBeUnlockedWithCorrectPassword() {
        diary.unlockDiary("secret123");
        assertFalse(diary.isLocked());
    }

    @Test
    public void testThatUnlockingWithWrongPasswordThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> diary.unlockDiary("wrong_pass"));
        assertTrue(diary.isLocked());
    }

    @Test
    public void testThatDiaryCanBeLockedAgain() {
        diary.unlockDiary("secret123");
        assertFalse(diary.isLocked());

        diary.lockDiary();
        assertTrue(diary.isLocked());
    }

    @Test
    public void testThatOperatingOnLockedDiaryThrowsException() {
        assertThrows(IllegalStateException.class, () -> diary.createEntry("My Day", "Today was great!"));
    }

    @Test
    public void testThatEntryCanBeCreatedWhenUnlocked() {
        diary.unlockDiary("secret123");
        diary.createEntry("First Note", "Learning OOP in Java");

        int expectedEntryCount = 1;
        int actualEntryCount = diary.getNumberOfEntries();
        assertEquals(expectedEntryCount, actualEntryCount);
    }

    @Test
    public void testThatEntryCanBeFoundById() {
        diary.unlockDiary("secret123");
        diary.createEntry("First Note", "Learning OOP in Java");

        Entry foundEntry = diary.findEntryById(1);
        assertNotNull(foundEntry);
        assertEquals(1, foundEntry.getId());
        assertEquals("First Note", foundEntry.getTitle());
        assertEquals("Learning OOP in Java", foundEntry.getBody());
        assertNotNull(foundEntry.getDateCreated());
    }

    @Test
    public void testThatEntryCanBeUpdated() {
        diary.unlockDiary("secret123");
        diary.createEntry("Morning Routine", "Woke up at 6 AM");

        diary.updateEntry(1, "Updated Morning Routine", "Woke up at 5:30 AM");

        Entry updatedEntry = diary.findEntryById(1);
        assertEquals("Updated Morning Routine", updatedEntry.getTitle());
        assertEquals("Woke up at 5:30 AM", updatedEntry.getBody());
    }

    @Test
    public void testThatEntryCanBeDeleted() {
        diary.unlockDiary("secret123");
        diary.createEntry("Temporary Note", "This will be deleted");
        assertEquals(1, diary.getNumberOfEntries());

        diary.deleteEntry(1);
        assertEquals(0, diary.getNumberOfEntries());

        assertThrows(IllegalArgumentException.class, () -> diary.findEntryById(1));
    }
}
