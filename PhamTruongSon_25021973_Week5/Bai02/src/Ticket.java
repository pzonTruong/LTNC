public class Ticket {
    private String id;
    private String content;
    private String timestamp;

    public Ticket(String id, String content, String timestamp){
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
    }

    @Override
    public String toString(){
        return "Ticket ID: " + id + " Content: " + content + " Timestamp: " + timestamp;
    }
}
