package net.jakutenshi.ui.views;

import net.jakutenshi.controller.Controller;
import net.jakutenshi.model.entities.Organization;
import net.jakutenshi.model.tables.Model;
import net.jakutenshi.ui.components.EntitiesListComponent;
import net.jakutenshi.ui.components.EntityTextFieldComponent;
import net.jakutenshi.ui.forms.OrganizationForm;
import net.jakutenshi.utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

public class OrganizationsView extends View {

    private EntitiesListComponent<Organization> organizationsPanel;
    private JPanel organizationInfoPanel;

    public OrganizationsView(Controller controller) {
        super(controller);
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        organizationsPanel = new EntitiesListComponent<>(Model.ORGANIZATIONS);
        add(organizationsPanel);


        Organization selected = organizationsPanel.getSelectedEntity();
        organizationInfoPanel = new JPanel();
        organizationInfoPanel.setLayout(new BoxLayout(organizationInfoPanel, BoxLayout.PAGE_AXIS));
        organizationInfoPanel.setBorder(BorderFactory.createTitledBorder("Объекты")); //ToDo: local
        organizationInfoPanel.add(new OrganizationForm(selected.getName(),
                selected.getLegalAddress(),
                selected.getPhoneNum(),
                false,
                Constants.DEFAULT_FORM_COMPOSER));
        organizationInfoPanel.add(Box.createVerticalGlue());
        add(organizationInfoPanel);


        //postsPanel.add(new EntitiesListComponent(), c);

        //JPanel postInfo
    }

    public EntitiesListComponent getOrganizationsPanel() {
        return organizationsPanel;
    }

    public Organization getSelectedOrganization() {
        return organizationsPanel.getSelectedEntity();
    }

    public void showOrganizationInfo(Organization organization) {
        OrganizationForm organizationForm = (OrganizationForm) organizationInfoPanel.getComponent(0);
        LinkedHashMap fields = organizationForm.getFormComponents();
        ((EntityTextFieldComponent) fields.get("Название")).setField(organization.getName());
        ((EntityTextFieldComponent) fields.get("Адрес")).setField(organization.getLegalAddress());
        ((EntityTextFieldComponent) fields.get("Номер телефона")).setField(organization.getPhoneNum());
    }
}
