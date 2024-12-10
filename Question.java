public class Question {
    private String title;
    private String url;
    private String dataStructureType;
    private String difficulty;
    private boolean completed;
    private Note note;

    public Question(String title, String url, String dataStructureType, String difficulty, boolean completed, String noteContent) {
        this.title = title;
        this.url = url;
        this.dataStructureType = dataStructureType;
        this.difficulty = difficulty;
        this.completed = completed;
        this.note = new Note(noteContent);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDataStructureType() {
        return dataStructureType;
    }

    public void setDataStructureType(String dataStructureType) {
        this.dataStructureType = dataStructureType;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getNoteContent() {
        return note.getContent();
    }

    public void setNoteContent(String noteContent) {
        note.setContent(noteContent);
    }

    @Override
    public String toString() {
        return String.format("Question[title=%s, url=%s, type=%s, difficulty=%s, completed=%b]",
                title, url, dataStructureType, difficulty, completed);
    }
}

