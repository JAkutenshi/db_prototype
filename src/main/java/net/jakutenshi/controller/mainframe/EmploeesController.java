package net.jakutenshi.controller.mainframe;

import net.jakutenshi.controller.Controller;
import net.jakutenshi.model.tables.AbstractTable;

import javax.swing.*;

public class EmploeesController extends Controller<JComponent, AbstractTable> {
    public EmploeesController() {
    }

    public EmploeesController(Controller root) {
        super(root);
    }

    public EmploeesController(Controller root, AbstractTable model) {
        super(root, model);
    }

    public EmploeesController(Controller root, JComponent view) {
        super(root, view);
    }

    public EmploeesController(Controller root, JComponent view, AbstractTable model) {
        super(root, view, model);
    }
}
