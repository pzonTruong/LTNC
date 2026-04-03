public class Message {
    private String id;
    private String content;

    public Message(String id, String content) {
        this.id = id;
        this.content = content;
    }       

    @Override
    public String toString(){
        return "ID: " + id + " Message: " + content;
    }
}
