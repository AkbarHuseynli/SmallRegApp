package service;

import dao.MenuService;

public class Exit extends MenuService {
    @Override
    public void process() {
        System.out.println("APP is shut down!");
        System.exit(0);
    }
}
