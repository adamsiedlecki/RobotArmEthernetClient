package entity;

public enum Part {

    BASE("base"),
    BOTTOM_ARM("bottomArm"),
    TOP_ARM("topArm"),
    HAND("hand")
    ;

    private final String name;

    Part(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
