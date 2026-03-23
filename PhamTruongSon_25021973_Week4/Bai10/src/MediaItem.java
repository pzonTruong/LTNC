abstract class MediaItem{
    protected String id;
    protected String title;

    public MediaItem(String id, String title){
        this.id = id;
        this.title = title;
    }

    public abstract String getItemInfo();

    @Override
    public String toString(){
        return "[" + id + "] " + getItemInfo();
    }
}