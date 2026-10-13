import java.util.ArrayList;
import java.util.List;

public class Diaries {
    private List<Diary> diaries;

    public Diaries() {
        this.diaries = new ArrayList<>();
    }

    public void add(String username, String password) {
        int totalDiariesCount = this.diaries.size();
        for (int diaryCount = 0; diaryCount < totalDiariesCount; diaryCount++) {
            Diary currentDiary = this.diaries.get(diaryCount);
            if (currentDiary.getUsername().equals(username)) {
                throw new IllegalArgumentException("Diary with username '" + username + "' already exists.");
            }
        }
        Diary newDiary = new Diary(username, password);
        this.diaries.add(newDiary);
    }

    public Diary findByUsername(String username) {
        int totalDiariesCount = this.diaries.size();
        for (int diaryCount = 0; diaryCount < totalDiariesCount; diaryCount++) {
            Diary currentDiary = this.diaries.get(diaryCount);
            if (currentDiary.getUsername().equals(username)) {
                return currentDiary;
            }
        }
        throw new IllegalArgumentException("Diary not found for username: " + username);
    }

    public void delete(String username, String password) {
        Diary diaryToDelete = findByUsername(username);
        diaryToDelete.unlockDiary(password);
        this.diaries.remove(diaryToDelete);
    }

    public int getTotalDiaries() {
        return this.diaries.size();
    }
}
