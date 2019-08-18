package net.jakutenshi.controller.mainframe;

import net.jakutenshi.controller.Controller;
import net.jakutenshi.model.tables.AbstractTable;

import javax.swing.*;

public class PostController extends Controller<JComponent, AbstractTable> {
    public PostController() {
    }

    public PostController(Controller root) {
        super(root);
    }

    public PostController(Controller root, AbstractTable model) {
        super(root, model);
    }

    public PostController(Controller root, JComponent view) {
        super(root, view);
    }

    public PostController(Controller root, JComponent view, AbstractTable model) {
        super(root, view, model);
    }
}
