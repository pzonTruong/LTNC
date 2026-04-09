public class VideoPlayer implements VideoPlayable {
    @Override
    public void playVideo(String file) {
        System.out.println("Đang phát video từ file: " + file);
    }
}