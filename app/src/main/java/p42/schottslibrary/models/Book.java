package p42.schottslibrary.models;



import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Book {
    private int id;
    private String title;
    private int authorId;
    private List<Tag> tags;
    private List<Comment> comments;
    private List<Rating> ratings;

    public Book(int id, String title, int authorId, List<Tag> tags, List<Comment> comments, List<Rating> ratings){
        this.id=id;
        this.title=title;
        this.authorId=authorId;
        this.tags=tags;
        this.comments=comments;
        this.ratings=ratings;
    }
    public Book(int id, String title, int authorId){
        this.id=id;
        this.title=title;
        this.authorId=authorId;
    }

    // Getter pour l'attribut 'id'
    public int getId() {
        return id;
    }

    // Setter pour l'attribut 'id'
    public void setId(int id) {
        this.id = id;
    }

    // Getter pour l'attribut 'title'
    public String getTitle() {
        return title;
    }

    // Setter pour l'attribut 'title'
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter pour l'attribut 'authorId'
    public int getAuthorId() {
        return authorId;
    }

    // Setter pour l'attribut 'authorId'
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    // Getter pour l'attribut 'publicationYear'


    // Setter pour l'attribut 'publicationYear'
    public void addComment(Comment comment){
        this.comments.add(comment);
    }
    public void addRating(Rating rating){
        this.ratings.add(rating);
    }
}
