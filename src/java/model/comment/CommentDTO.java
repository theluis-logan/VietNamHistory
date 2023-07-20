/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.comment;

import java.time.LocalDateTime;

/**
 *
 * @author NguyenTheAnh
 */
public class CommentDTO {
    private String author;
    private String content;
    private LocalDateTime timestamp;

    public CommentDTO(String author, String content, LocalDateTime timestamp) {
        this.author = author;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "CommentDTO{" + "author=" + author + ", content=" + content + ", timestamp=" + timestamp + '}';
    }
}
