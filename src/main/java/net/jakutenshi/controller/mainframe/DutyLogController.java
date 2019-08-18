package net.jakutenshi.controller.mainframe;

import net.jakutenshi.controller.Controller;
import net.jakutenshi.model.ModelsMap;
import net.jakutenshi.model.tables.AbstractTable;

import javax.swing.*;

public class DutyLogController extends Controller<JComponent> {
    public DutyLogController() {
    }

    public DutyLogController(Controller root) {
        super(root);
    }

    public DutyLogController(Controller root, ModelsMap model) {
        super(root, model);
    }

    public DutyLogController(Controller root, JComponent view) {
        super(root, view);
    }

    public DutyLogController(Controller root, JComponent view, ModelsMap model) {
        super(root, view, model);
    }
}
