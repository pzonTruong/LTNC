public class Book extends MediaItem{
    private String author;
    private int noPages;

    public Book(String id, String title, String author, int noPages){
        super(id, title);
        this.author = author;
        this.noPages = noPages;
    }

    @Override
    public String getItemInfo(){
        return title + " - Tac gia: " + author + " - So trang: " + noPages;
    }
}
