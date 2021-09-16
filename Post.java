package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.Clock;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Post {
    @Id
    @Column(name = "PK_ID")
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    @CreationTimestamp
    private Timestamp creation_date;

    @JsonIgnore
    @OneToMany(targetEntity = Comment.class, mappedBy = "post", fetch = FetchType.LAZY)
    private List <Comment> comments;
    private Post(){}

    public Post(String title, String content){
        this.title = title;
        this.content = content;
        this.creation_date = new Timestamp(Clock.systemUTC().millis());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) &&
                Objects.equals(title, post.title) &&
                Objects.equals(content, post.content) &&
                Objects.equals(creation_date, post.creation_date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, content, creation_date);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", creation_date=" + creation_date +
                ", comments=" + comments +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Timestamp getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Timestamp creation_date) {
        this.creation_date = creation_date;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Comment> getComments() {
        return comments;
    }
    
}
