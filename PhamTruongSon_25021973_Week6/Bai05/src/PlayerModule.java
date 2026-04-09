// Lớp cũ không được sửa
class OldPlayer {
    void playFile(String name) {
        System.out.println("Playing file via OldPlayer: " + name);
    }
}

// Interface mới yêu cầu
interface Player {
    void play(String name);
}

// Adapter kết nối
class PlayerAdapter implements Player {
    private OldPlayer oldPlayer;

    public PlayerAdapter(OldPlayer oldPlayer) {
        this.oldPlayer = oldPlayer;
    }

    @Override
    public void play(String name) {
        oldPlayer.playFile(name);
    }
}