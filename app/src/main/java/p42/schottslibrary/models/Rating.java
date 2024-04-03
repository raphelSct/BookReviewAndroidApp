package p42.schottslibrary.models;

public class Rating {
    private int id;
    private int value;
    private  int userId;
    private int bookId;

    public Rating(int id,int value,int userId,int bookId){
        this.id=id;
        this.value=value;
        this.userId=userId;
        this.bookId=bookId;
    }
    public int getId() {
        return id;
    }

    // Setter pour l'attribut 'id'
    public void setId(int id) {
        this.id = id;
    }

    // Getter pour l'attribut 'value'
    public int getValue() {
        return value;
    }

    // Setter pour l'attribut 'value'
    public void setValue(int value) {
        this.value = value;
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
