package net.jakutenshi.controller.mainframe;

import net.jakutenshi.controller.Controller;
import net.jakutenshi.model.tables.AbstractTable;

import javax.swing.*;

public class SalaryController extends Controller<JComponent, AbstractTable> {
    public SalaryController() {
    }

    public SalaryController(Controller root) {
        super(root);
    }

    public SalaryController(Controller root, AbstractTable model) {
        super(root, model);
    }

    public SalaryController(Controller root, JComponent view) {
        super(root, view);
    }

    public SalaryController(Controller root, JComponent view, AbstractTable model) {
        super(root, view, model);
    }
}
