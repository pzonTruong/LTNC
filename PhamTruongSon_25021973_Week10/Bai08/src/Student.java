import java.util.List;

public class Student {
    private String fullName;
    private String email;
    private String gender;
    private String major;
    private List<String> interests;

    public Student(String fullName, String email, String gender, String major, List<String> interests) {
        this.fullName = fullName;
        this.email = email;
        this.gender = gender;
        this.major = major;
        this.interests = interests;
    }

    // Getters and Setters
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    public List<String> getInterests() { return interests; }
    public void setInterests(List<String> interests) { this.interests = interests; }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", major='" + major + '\'' +
                ", interests=" + interests +
                '}';
    }
}
