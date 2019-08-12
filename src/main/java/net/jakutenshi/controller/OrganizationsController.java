package net.jakutenshi.controller;

import net.jakutenshi.model.entities.Organization;
import net.jakutenshi.model.tables.Model;
import net.jakutenshi.ui.components.EntitiesListPanel;
import net.jakutenshi.ui.components.EntityPanel;

import javax.swing.*;
import java.awt.*;

public class OrganizationsController {
    private JComponent view;

    public OrganizationsController() {
        view = new JPanel();

        view.setLayout(new BoxLayout(view, BoxLayout.LINE_AXIS));

        view.add(new EntityPanel());


    }

    public JComponent getView() {
        return view;
    }

}
