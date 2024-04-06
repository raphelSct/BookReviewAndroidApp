package p42.schottslibrary.models;

import java.util.ArrayList;
import java.util.List;

public class Tag {
    private int id;
    private String name;
    private List<Book> books;

    public Tag(int id,String name){
        this.id=id;
        this.name=name;
        this.books=new ArrayList<>();
    }
    public Tag(String name){
        this.name=name;
        this.books=new ArrayList<>();
    }
    // Getter pour l'attribut 'id'
    public int getId() {
        return id;
    }

    // Setter pour l'attribut 'id'
    public void setId(int id) {
        this.id = id;
    }

    // Getter pour l'attribut 'name'
    public String getName() {
        return name;
    }

    // Setter pour l'attribut 'name'
    public void setName(String name) {
        this.name = name;
    }

    // Getter pour l'attribut 'books'
    public List<Book> getBooks() {
        return books;
    }

    // Setter pour l'attribut 'books'
    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
