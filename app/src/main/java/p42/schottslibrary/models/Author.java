package p42.schottslibrary.models;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Author {
    private int id;
    private String firstname;
    private String lastname;
    private List<Book> books;

    public Author(int id, String firstname, String  lastname){
        this.id=id;
        this.firstname=firstname;
        this.lastname=lastname;
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

    // Getter pour l'attribut 'firstname'
    public String getFirstname() {
        return firstname;
    }

    // Setter pour l'attribut 'firstname'
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    // Getter pour l'attribut 'lastname'
    public String getLastname() {
        return lastname;
    }

    // Setter pour l'attribut 'lastname'
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    // Getter pour l'attribut 'books'
    public List<Book> getBooks() {
        return books;
    }

    // Setter pour l'attribut 'books'
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book){
        this.books.add(book);
    }
    public String getFullName(){
        return firstname+" "+lastname;
    }
}
