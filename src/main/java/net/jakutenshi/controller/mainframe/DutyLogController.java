package net.jakutenshi.controller.mainframe;

import net.jakutenshi.controller.Controller;
import net.jakutenshi.model.tables.AbstractTable;

import javax.swing.*;

public class DutyLogController extends Controller<JComponent, AbstractTable> {
    public DutyLogController() {
    }

    public DutyLogController(Controller root) {
        super(root);
    }

    public DutyLogController(Controller root, AbstractTable model) {
        super(root, model);
    }

    public DutyLogController(Controller root, JComponent view) {
        super(root, view);
    }

    public DutyLogController(Controller root, JComponent view, AbstractTable model) {
        super(root, view, model);
    }
}
