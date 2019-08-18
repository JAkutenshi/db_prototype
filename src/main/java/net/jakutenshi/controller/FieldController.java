package net.jakutenshi.controller;

import net.jakutenshi.ui.components.EntityTextFieldComponent;

public class FieldController<M> extends Controller<EntityTextFieldComponent, M> {

    public FieldController(Controller root, EntityTextFieldComponent view, M model) {
        super(root, view, model);
    }


}
