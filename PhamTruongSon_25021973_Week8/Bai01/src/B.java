public class B {
    // class UserService {
    // public User findById(int id) { ... }
    // public void sendWelcomeEmail(User user) { ... }
    // public void sendPasswordResetEmail(User user) { ... }
    // public void renderUserProfile(User user) { ... }
    // public String exportUserToCsv(User user) { ... }
    // }

    // Code smell: Large Class, Lack of Cohesion
    // Vi phạm quy tắc Singleton: Mỗi class chỉ có 1 nhiệm vụ duy nhất

    // Kỹ thuật Refactor cần sử dụng: Extract class
    // Tách class thành các file riêng:
    
    // class UserService {
    //  public User findById(int id) { ... }
    // }

    // class EmailService {
    //  public void sendWelcomeEmail(User user) { ... }

    // public void sendPasswordResetEmail(User user) { ... }
    // }

    // class UserProfileView {
    //  public void renderUserProfile(User user) { ... }
    // }

    // class UserExportService {
    //  public String exportUserToCsv(User user) { ... }
    // }
}
