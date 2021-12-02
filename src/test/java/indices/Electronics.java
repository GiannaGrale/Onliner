package indices;

public enum Electronics {

    MOBILE_PHONES("4"),
    TV("8"),
    TABLETS_ELECTRONIC_BOOKS("12"),
    AUDIO("16"),
    HI_FI_AUDIO("20"),
    PHOTO_VIDEO("24"),
    VIDEO_GAMES("28"),
    DEVICES("32"),
    SMART_HOUSE("36"),
    E_TRANSPORT("40"),
    IP_TELEPHONY("44"),
    MUSIC_DEVICES("48"),
    OPTICAL_DEVICES("52");

    private final String title;

    Electronics(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
