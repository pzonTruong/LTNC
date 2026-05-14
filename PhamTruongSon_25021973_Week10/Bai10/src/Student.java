import java.sql.*;
import java.util.Arrays;
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

    // Database Operations
    public void save() throws SQLException {
        String sql = "INSERT INTO students (full_name, email, gender, major, interests) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fullName);
            pstmt.setString(2, email);
            pstmt.setString(3, gender);
            pstmt.setString(4, major);
            pstmt.setString(5, String.join(",", interests));
            pstmt.executeUpdate();
        }
    }

    public static Student loadLatest() throws SQLException {
        String sql = "SELECT * FROM students ORDER BY id DESC LIMIT 1";
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                String fullName = rs.getString("full_name");
                String email = rs.getString("email");
                String gender = rs.getString("gender");
                String major = rs.getString("major");
                String interestsStr = rs.getString("interests");
                List<String> interests = interestsStr.isEmpty() ? List.of() : Arrays.asList(interestsStr.split(","));
                return new Student(fullName, email, gender, major, interests);
            }
        }
        return null;
    }
}
