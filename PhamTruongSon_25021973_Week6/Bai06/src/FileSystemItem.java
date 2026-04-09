public abstract class FileSystemItem {
    protected String name;
    protected Folder parent; // Dùng để truy vết đường dẫn logic

    public FileSystemItem(String name) {
        this.name = name;
    }

    public abstract void print(String indent);

    // Phương thức hỗ trợ lấy đường dẫn logic (Path)
    public String getPath() {
        if (parent == null) return "/" + name;
        return parent.getPath() + "/" + name;
    }

    public void setParent(Folder parent) {
        this.parent = parent;
    }
}