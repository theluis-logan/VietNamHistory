/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.post;

/**
 *
 * @author NguyenTheAnh
 */
public class PostDTO {
    private int id ;
    private String title ;
    private String content ;
    private int categoryId ;
    private int markerId ;
    private String description ;

    public PostDTO() {
    }

    public PostDTO(int id, String title, String content, int categoryId, int markerId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.categoryId = categoryId;
        this.markerId = markerId;
        this.description = content.substring(0, 200) + "...";
    }

    public String getDescription() {
        return description ;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getMarkerId() {
        return markerId;
    }

    public void setMarkerId(int markerId) {
        this.markerId = markerId;
    }

    @Override
    public String toString() {
        return "PostDTO{" + "id=" + id + ", title=" + title + ", content=" + content + ", categoryId=" + categoryId + ", markerId=" + markerId + '}';
    }
}
