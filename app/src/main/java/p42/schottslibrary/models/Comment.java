package p42.schottslibrary.models;

import java.util.Date;

public class Comment {
    private int id;
    private String content;
    private Date creation;
    private Date update;
    private int userId;
    private int bookId;

    public Comment(int id,String content,int userId,int bookId){
        this.id=id;
        this.content=content;
        this.creation=new Date();
        this.update=new Date();
        this.userId=userId;
        this.bookId=bookId;
    }
    public Comment(String content){

        this.content=content;

    }
    // Getter pour l'attribut 'id'
    public int getId() {
        return id;
    }

    // Setter pour l'attribut 'id'
    public void setId(int id) {
        this.id = id;
    }

    // Getter pour l'attribut 'content'
    public String getContent() {
        return content;
    }

    // Setter pour l'attribut 'content'
    public void setContent(String content) {
        this.content = content;
    }

    // Getter pour l'attribut 'creation'
    public Date getCreation() {
        return creation;
    }

    // Getter pour l'attribut 'update'
    public Date getUpdate() {
        return update;
    }

    // Setter pour l'attribut 'update'
    public void setUpdate(Date update) {
        this.update = update;
    }

    // Getter pour l'attribut 'userId'
    public int getUserId() {
        return userId;
    }

    // Setter pour l'attribut 'userId'
    public void setUserId(int userId) {
        this.userId = userId;
    }

    // Getter pour l'attribut 'bookId'
    public int getBookId() {
        return bookId;
    }

    // Setter pour l'attribut 'bookId'
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
