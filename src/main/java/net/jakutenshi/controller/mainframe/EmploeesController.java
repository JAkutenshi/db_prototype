package net.jakutenshi.controller.mainframe;

import net.jakutenshi.controller.Controller;
import net.jakutenshi.model.ModelsMap;
import net.jakutenshi.model.tables.AbstractTable;

import javax.swing.*;

public class EmploeesController extends Controller<JComponent> {
    public EmploeesController() {
    }

    public EmploeesController(Controller root) {
        super(root);
    }

    public EmploeesController(Controller root, ModelsMap model) {
        super(root, model);
    }

    public EmploeesController(Controller root, JComponent view) {
        super(root, view);
    }

    public EmploeesController(Controller root, JComponent view, ModelsMap model) {
        super(root, view, model);
    }
}
