import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiariesTest {

    private Diaries diaries;

    @BeforeEach
    public void testThatANewDiariesCollectionIsCreated() {
        diaries = new Diaries();
    }

    @Test
    public void testThatDiaryCanBeAddedToDiaries() {
        diaries.add("yusuf_umaru", "pass123");

        int expectedTotalDiaries = 1;
        int actualTotalDiaries = diaries.getTotalDiaries();
        assertEquals(expectedTotalDiaries, actualTotalDiaries);
    }

    @Test
    public void testThatAddingDuplicateUsernameThrowsException() {
        diaries.add("yusuf_umaru", "pass123");

        assertThrows(IllegalArgumentException.class, () -> diaries.add("yusuf_umaru", "another_password"));
    }

    @Test
    public void testThatDiaryCanBeFoundByUsername() {
        diaries.add("amina_bello", "secure456");

        Diary retrievedDiary = diaries.findByUsername("amina_bello");

        assertNotNull(retrievedDiary);
        assertEquals("amina_bello", retrievedDiary.getUsername());
    }

    @Test
    public void testThatFindingNonExistentDiaryThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> diaries.findByUsername("ghost_user"));
    }

    @Test
    public void testThatDiaryCanBeDeletedWithCorrectPassword() {
        diaries.add("yusuf_umaru", "secretPass");
        assertEquals(1, diaries.getTotalDiaries());

        diaries.delete("yusuf_umaru", "secretPass");
        assertEquals(0, diaries.getTotalDiaries());

        assertThrows(IllegalArgumentException.class, () -> diaries.findByUsername("yusuf_umaru"));
    }

    @Test
    public void testThatDeletingDiaryWithWrongPasswordFails() {
        diaries.add("yusuf_umaru", "secretPass");

        assertThrows(IllegalArgumentException.class, () -> diaries.delete("yusuf_umaru", "wrongPass"));

        assertEquals(1, diaries.getTotalDiaries());
    }
}


// javac -cp "junit-platform-console-standalone-1.11.0.jar:." Diary.java DiaryTest.java DiariesTest.java Diaries.java Entry.java

// java -jar junit-platform-console-standalone-1.11.0.jar --class-path . --scan-class-path

