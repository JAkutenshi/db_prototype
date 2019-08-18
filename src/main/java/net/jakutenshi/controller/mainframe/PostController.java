package net.jakutenshi.controller.mainframe;

import net.jakutenshi.controller.Controller;
import net.jakutenshi.model.ModelsMap;
import net.jakutenshi.model.tables.AbstractTable;

import javax.swing.*;

public class PostController extends Controller<JComponent> {
    public PostController() {
    }

    public PostController(Controller root) {
        super(root);
    }

    public PostController(Controller root, ModelsMap models) {
        super(root, models);
    }

    public PostController(Controller root, JComponent view) {
        super(root, view);
    }

    public PostController(Controller root, JComponent view, ModelsMap model) {
        super(root, view, model);
    }
}
