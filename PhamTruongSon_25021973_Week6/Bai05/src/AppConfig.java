public class AppConfig implements Cloneable {
    private String settingName;

    public AppConfig(String name) { this.settingName = name; }
    public void setName(String name) { this.settingName = name; }

    @Override
    public AppConfig clone() {
        try {
            return (AppConfig) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() { return "Config: " + settingName; }
}