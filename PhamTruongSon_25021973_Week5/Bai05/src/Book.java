public class Book {
    private String id;
    private String author;
    private String title;
    private int year;

    public Book(String id, String author, String title, int year){
        this.id = id;
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String getId() {return id;}

    @Override
    public String toString(){
        return "ID: " + id + " Author: " + author + " Title: " + title + " Year: " + year;
    }
}
