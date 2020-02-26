package constants;


public enum Browser {

    CHROME      ("chrome"),
    FIREFOX     ("firefox"),
    OPERA       ("opera"),
    EDGE        ("edge"),
    IE          ("ie");

    public final String value;


    Browser(String value) {
        this.value = value;
    }
}