
public class MediaPlayer {
    private AudioPlayable audioService;
    private VideoPlayable videoService;

    // Phụ thuộc được truyền qua Constructor (Dependency Injection)
    // Thỏa mãn DIP: Phụ thuộc vào Abstraction, không phụ thuộc vào Concretion
    public MediaPlayer(AudioPlayable audio, VideoPlayable video) {
        this.audioService = audio;
        this.videoService = video;
    }

    public void playMusic(String fileName) {
        audioService.playAudio(fileName);
    }

    public void playMovie(String fileName) {
        videoService.playVideo(fileName);
    }
}