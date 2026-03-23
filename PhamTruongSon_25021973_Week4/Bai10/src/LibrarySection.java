
import java.util.*;

public class LibrarySection<T extends MediaItem> {

    private String sectionName;
    private List<T> items = new ArrayList<>();

    public LibrarySection(String sectionName) {
        this.sectionName = sectionName;
    }

    public void addItem(T item) {
        items.add(item);
        System.out.println("Da them vao khu vuc " + sectionName + ": " + item.title);
    }

    public void removeItem(String id) {
        boolean removed = items.removeIf(item -> item.id.equals(id));
        if (removed) {
            System.out.println("Da xoa tai lieu co id: " + id);
        } else {
            System.out.println("Khong tim thay tai lieu co id: " + id);
        }
    }

    public void displaySection(){
        if(items.isEmpty()){
            System.out.println("Section trong.");
        } else{
            for(T item: items){
                System.out.println(item);
            }
        }
    }
}
