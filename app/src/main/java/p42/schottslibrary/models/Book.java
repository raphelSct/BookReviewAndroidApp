package p42.schottslibrary.models;



import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Book {
    private int id;
    private String title;
    private Author author;
    private List<Tag> tags;
    private List<Comment> comments;
    private List<Rating> ratings;
    private double averageRating;

    public Book(int id, String title, Author author, List<Tag> tags, List<Comment> comments, List<Rating> ratings){
        this.id=id;
        this.title=title;
        this.author=author;
        this.tags=tags;
        this.comments=comments;
        this.ratings=ratings;
    }
    public Book(int id, String title){
        this.id=id;
        this.title=title;

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


    public void addComment(Comment comment){
        this.comments.add(comment);
    }
    public void addRating(Rating rating){
        this.ratings.add(rating);
    }
}
