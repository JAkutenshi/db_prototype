package net.jakutenshi.controller;

import net.jakutenshi.model.Descriptions;
import net.jakutenshi.model.entities.Absence;
import net.jakutenshi.model.entities.Organization;
import net.jakutenshi.model.sql.DBTables;
import net.jakutenshi.model.tables.AbstractTable;
import net.jakutenshi.model.tables.TableDescription;
import net.jakutenshi.ui.views.OrganizationsView;

import javax.swing.*;

public class OrganizationsController {
    //OrganizationsView view;
    JComponent view;
    //OrganizationTable organizationTable;
    AbstractTable<Organization> model;
    AbstractTable<Absence> model1;

    public OrganizationsController() {
        model = new AbstractTable<Organization>(DBTables.ORGANIZATION);
        model1 = new AbstractTable<Absence>(DBTables.ABSENCE);
        //view = new OrganizationsView(organizationTable.toStringArrayList());
        view = new JScrollPane(new JTable(model1));
    }

    public JComponent getView() {
        return view;
    }

}
