package org.example;

public class Article {
    public Integer id = 0;
    public String title = "";
    public String content = "";
    public Long created_at = 0L;

    public Article() {
    }

    public Article(Integer id, String title, String content, Long created_at) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.created_at = created_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Long created_at) {
        this.created_at = created_at;
    }
}
