package net.jakutenshi.controller;

import net.jakutenshi.model.Descriptions;
import net.jakutenshi.model.entities.Absence;
import net.jakutenshi.model.entities.Organization;
import net.jakutenshi.model.sql.DBTables;
import net.jakutenshi.model.tables.AbstractTable;
import net.jakutenshi.model.tables.Model;
import net.jakutenshi.model.tables.TableDescription;
import net.jakutenshi.ui.views.OrganizationsView;
import net.jakutenshi.utils.Constants;
import net.jakutenshi.utils.UIUtilFunctions;

import javax.swing.*;

public class OrganizationsController {
    //OrganizationsView view;
    JComponent view;

    public OrganizationsController() {
        view = new JScrollPane(new JTable(Model.POSTS));
        UIUtilFunctions.changeFont(view, Constants.FONT_TERMINUS);
    }

    public JComponent getView() {
        return view;
    }

}
