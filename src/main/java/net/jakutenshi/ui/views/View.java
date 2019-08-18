package net.jakutenshi.ui.views;

import net.jakutenshi.controller.Controller;

import javax.swing.*;

public class View extends JPanel {
    private Controller owner;

    public View(Controller controller) {
        super();
        this.owner = controller;
    }

    public Controller getOwner() {
        return owner;
    }

    public void setOwner(Controller owner) {
        this.owner = owner;
    }
}
