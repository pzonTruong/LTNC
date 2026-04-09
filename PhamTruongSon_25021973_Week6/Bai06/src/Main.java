public class Main {
    public static void main(String[] args) {
        // Cấp 1: Thư mục gốc
        Folder root = new Folder("root");

        // Cấp 2: Thư mục docs và file readme
        Folder docs = new Folder("docs");
        FileItem readme = new FileItem("readme.md", 4);
        
        root.add(docs);
        root.add(readme);

        // Cấp 3: Nội dung bên trong docs
        FileItem aTxt = new FileItem("a.txt", 12);
        FileItem bTxt = new FileItem("b.txt", 8);
        Shortcut aShortcut = new Shortcut("a-shortcut", aTxt);

        docs.add(aTxt);
        docs.add(bTxt);
        docs.add(aShortcut);

        // In toàn bộ hệ thống file
        root.print("");
    }
}