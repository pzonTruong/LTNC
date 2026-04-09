// File: Main.java
public class Main {
    public static void main(String[] args) {
        // Khởi tạo các thành phần cụ thể bên ngoài
        AudioPlayable myAudio = new AudioPlayer();
        VideoPlayable myVideo = new VideoPlayer();

        // Truyền phụ thuộc vào MediaPlayer
        MediaPlayer myMediaSystem = new MediaPlayer(myAudio, myVideo);

        // Vận hành hệ thống
        System.out.println("--- Hệ thống giải trí đa phương tiện ---");
        myMediaSystem.playMusic("Chills_Lofi_Beats.mp3");
        myMediaSystem.playMovie("Design_Patterns_Tutorial.mp4");
    }
}