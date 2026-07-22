public class PlaylistNode {
    String code;
    String name;
    PlaylistNode next;

    public PlaylistNode(String code, String name) {
        this.code = code.trim();
        this.name = name.trim();
        this.next = null;
    }
}