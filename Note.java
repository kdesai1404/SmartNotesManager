import java.io.Serializable;

public class Note implements Serializable {
    private String title;
    private String content;
    private String category;

    public Note(String title, String content, String category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getCategory() { return category; }

    public void display() {
        System.out.println("\nTitle: " + title);
        System.out.println("Category: " + category);
        System.out.println("Content: " + content);
    }
}
