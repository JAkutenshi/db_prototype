package net.jakutenshi.ui.views;

import net.jakutenshi.controller.Controller;
import net.jakutenshi.controller.mainframe.OrganizationsController;
import net.jakutenshi.model.entities.OrgObject;
import net.jakutenshi.model.entities.Organization;
import net.jakutenshi.model.tables.Model;
import net.jakutenshi.ui.components.EntitiesListComponent;
import net.jakutenshi.ui.components.EntityTextFieldComponent;
import net.jakutenshi.ui.forms.OrganizationForm;
import net.jakutenshi.utils.BoxPanelFactory;
import net.jakutenshi.utils.Constants;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.LinkedHashMap;

import static javax.swing.BoxLayout.LINE_AXIS;
import static javax.swing.BoxLayout.PAGE_AXIS;

public class OrganizationsView extends View {

    private EntitiesListComponent<Organization> organizationsListComponent;
    //private JPanel organizationInfoPanel;
    private OrganizationForm organizationForm;
    private EntitiesListComponent<OrgObject> orgObjectsListComponent;
    //private JPanel objectInfoPanel;

    public OrganizationsView(Controller controller) {
        super(controller);
        setLayout(new BoxLayout(this, LINE_AXIS));

        //Список организаций
        add(organizationsListComponent = new EntitiesListComponent<>("Список организаций", Model.ORGANIZATIONS));

        //Информация об организации
        JPanel organizationInfoPanel = BoxPanelFactory.create(PAGE_AXIS, "Информация об организации");
        organizationForm = new OrganizationForm("Выберите организацию", "Выберите организацию", "Выберите организацию",
                false, Constants.DEFAULT_FORM_COMPOSER);
        organizationInfoPanel.add(organizationForm);
        //organizationInfoPanel.add(Box.createVerticalGlue());

        // Раздел с информацией об объектах
        JPanel objectsSide = BoxPanelFactory.create(LINE_AXIS);

        //Список объектов
        objectsSide.add(orgObjectsListComponent = new EntitiesListComponent<>("Список объектов"));

        //Информация об объекте
        JPanel objectInfoPanel = BoxPanelFactory.create(PAGE_AXIS, "Информация об объекте");
        objectInfoPanel.add(new JTextArea("WIP"));
        objectsSide.add(objectInfoPanel);

        organizationInfoPanel.add(objectsSide);
        add(organizationInfoPanel);
    }

    public EntitiesListComponent getOrganizationsListComponent() {
        return organizationsListComponent;
    }

    public EntitiesListComponent<OrgObject> getOrgObjectsListComponent() {
        return orgObjectsListComponent;
    }

    public Organization getSelectedOrganization() {
        return organizationsListComponent.getSelectedEntity();
    }

    public OrgObject getSelectedOrgObject() {
        return orgObjectsListComponent.getSelectedEntity();
    }

    public OrganizationForm getOrganizationForm() {
        return organizationForm;
    }

    public boolean isOrganizationSelectionEmpty() {
        return organizationsListComponent.getObjectsList().isSelectionEmpty();
    }

    public boolean isOrgObjectSelectionEmpty() {
        return orgObjectsListComponent.getObjectsList().isSelectionEmpty();
    }

    public void deselectOrganizationView() {
        for (JComponent c : organizationForm.getFormComponents().values()) {
            ((EntityTextFieldComponent) c).setField("Выберите организацию");
        }
        orgObjectsListComponent.clear();
    }
}
