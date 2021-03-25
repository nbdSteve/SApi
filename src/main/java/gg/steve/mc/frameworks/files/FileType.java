package gg.steve.mc.frameworks.files;

public enum FileType {
    PLAYER("player-data"),
    CONFIGURATION(""),
    GUI("guis"),
    MESSAGE("lang"),
    DEFAULT("");

    private String parentFolder;

    FileType(String parentFolder) {
        this.parentFolder = parentFolder;
    }

    public void setParentFolder(String parentFolder) {
        this.parentFolder = parentFolder;
    }

    public static FileType parseFileTypeFromString(String fileType) {
        if (fileType == null) return DEFAULT;
        switch (fileType) {
            case "player":
                return PLAYER;
            case "configuration":
                return CONFIGURATION;
            case "gui":
                return GUI;
            case "message":
                return MESSAGE;
        }
        return DEFAULT;
    }

    public String getParentFolder() {
        return this.parentFolder;
    }
}
