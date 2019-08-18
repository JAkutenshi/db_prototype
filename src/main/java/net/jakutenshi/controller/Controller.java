package net.jakutenshi.controller;

import net.jakutenshi.model.tables.AbstractTable;

import javax.swing.*;
import java.awt.*;

public class Controller<C extends Component, M> {
    private Controller root;
    private C view;
    private M model;

    public Controller() {
        this.root  = null;
        this.view  = null;
        this.model = null;
    }

    public Controller(Controller root) {
        this.root  = root;
        this.view  = null;
        this.model = null;
    }

    public Controller(Controller root, M model) {
        this.root  = root;
        this.view  = null;
        this.model = model;
    }

    public Controller(Controller root, C view) {
        this.root  = root;
        this.view  = view;
        this.model = null;
    }

    public Controller(Controller root, C view, M model) {
        this.root  = root;
        this.view  = view;
        this.model = model;
    }

    public Controller getRoot() {
        return root;
    }

    public Controller setRoot(Controller root) {
        this.root = root;
        return this;
    }

    public C getView() {
        return view;
    }

    public Controller setView(C view) {
        this.view = view;
        return this;
    }

    public M getModel() {
        return model;
    }

    public Controller setModel(M model) {
        this.model = model;
        return this;
    }
}
