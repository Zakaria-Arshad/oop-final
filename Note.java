import java.time.LocalDateTime;

public class Note {
    String content;
    LocalDateTime lastUpdated;


    public Note() {
        this.content = "";
        this.lastUpdated = LocalDateTime.now();
    }

    public Note(String content) {
        this.content = content;
        this.lastUpdated = LocalDateTime.now();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.lastUpdated = LocalDateTime.now();
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }   
    
}
