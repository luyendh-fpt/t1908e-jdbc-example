package t1908e.entity;

public class Article {

    private int id;
    private String url;
    private String title;
    private String description;
    private String content;
    private String source;
    private int status;//1. active | 0. deactive

    public Article() {
    }

    public Article(int id, String url, String title, int status) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.status = status;
    }

    public Article(String url) {
        this.url = url;
        this.status = 1;
    }

    @Override
    public String toString() {
        return String.format("Tiêu đề: %s\nMô tả: %s\nNội dung: %s\nNguồn: %s", this.title, this.description, this.content, this.source);
    }

    public String toShortString() {
        return String.format("Id: %d\nTiêu đề: %s\nUrl: %s\nStatus: %d", this.id, this.title, this.url, this.status);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
