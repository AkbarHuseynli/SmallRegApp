package util;

public enum Menu {
    Save(1, "Save Person"),
    Register(2, "Register User"),
    Show(3, "Show People"),
    Exit(4, "Exit");

    private int index;
    private String desc;

    Menu(int index, String desc) {
        this.index = index;
        this.desc = desc;
    }


    @Override
    public String toString() {
        return
                index +
                        "." + desc;
    }
}
