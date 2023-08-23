package util;

import dao.MenuService;
import service.Display;
import service.Register;
import service.Save;
import service.Exit;

public enum Menu {
    Save(1, "Save Person", new Save()),
    Register(2, "Register User", new Register()),
    Show(3, "Show People", new Display()),
    Exit(4, "Exit", new Exit());

    private int index;
    private String desc;
    private MenuService service;

    Menu(int index, String desc, MenuService service) {
        this.index = index;
        this.desc = desc;
        this.service = service;
    }

    public void process() {
        this.service.process();

    }

    @Override
    public String toString() {
        return
                index +
                        "." + desc;
    }
}
