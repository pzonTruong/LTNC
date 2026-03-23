public class DVD extends MediaItem {
    private String director;
    private int length;

    public DVD(String id, String title, String director, int length){
        super(id, title);
        this.director = director;
        this.length = length;
    }

    @Override
    public String getItemInfo(){
        return title + " - Dao dien: " + director + " - Thoi luong: " + length;
    }
}
