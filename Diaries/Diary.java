

import java.util.ArrayList;
import java.util.List;

public class Diary {
    private String username;
    private String password;
    private boolean isLocked;
    private List<Entry> entries;
    private int entryIdCounter;

    public Diary(String username, String password) {
        this.username = username;
        this.password = password;
        this.isLocked = true;
        this.entries = new ArrayList<>();
        this.entryIdCounter = 0;
    }

    public void unlockDiary(String password) {
        if (this.password.equals(password)) {
            this.isLocked = false;
        } else {
            throw new IllegalArgumentException("Incorrect password.");
        }
    }

    public void lockDiary() {
        this.isLocked = true;
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public void createEntry(String title, String body) {
        validateUnlockedState();
        this.entryIdCounter = this.entryIdCounter + 1;
        Entry newEntry = new Entry(this.entryIdCounter, title, body);
        this.entries.add(newEntry);
    }

    public void deleteEntry(int id) {
        validateUnlockedState();
        Entry entryToDelete = findEntryById(id);
        this.entries.remove(entryToDelete);
    }

    public Entry findEntryById(int id) {
        validateUnlockedState();
        int totalEntriesCount = this.entries.size();

        for (int entryCount = 0; entryCount < totalEntriesCount; entryCount++) {
            Entry currentEntry = this.entries.get(entryCount);
            if (currentEntry.getId() == id) {
                return currentEntry;
            }
        }

        throw new IllegalArgumentException("Entry not found with ID: " + id);
    }

    public void updateEntry(int id, String title, String body) {
        validateUnlockedState();
        Entry existingEntry = findEntryById(id);
        existingEntry.setTitle(title);
        existingEntry.setBody(body);
    }

    public String getUsername() {
        return this.username;
    }

    public int getNumberOfEntries() {
        validateUnlockedState();
        return this.entries.size();
    }

    private void validateUnlockedState() {
        if (this.isLocked) {
            throw new IllegalStateException("Diary is locked. Please unlock it to perform operations.");
        }
    }
}
