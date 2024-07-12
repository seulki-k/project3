package project3.vo;

public enum AuthGrade {
    GUEST(1,"게스트"),
    ADMIN(3,"관리자");

    private final int level;

    public int getLevel() {
        return level;
    }
    public String getDescription() {
        return description;
    }
    private final String description;

    AuthGrade(int level, String description) {
        this.level = level;
        this.description = description;
    }
}
