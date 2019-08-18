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


        add(organizationsListComponent = new EntitiesListComponent<>(Model.ORGANIZATIONS));

        JPanel panel = BoxPanelFactory.create(PAGE_AXIS, "!!!");
        organizationForm = new OrganizationForm("Выберите организацию", "Выберите организацию", "Выберите организацию",
                false, Constants.DEFAULT_FORM_COMPOSER);
        panel.add(organizationForm);

        JPanel panel2 = BoxPanelFactory.create(LINE_AXIS, "^^^");
        panel2.add(new EntitiesListComponent<>());
        panel2.add(Box.createHorizontalGlue());
        panel.add(panel2);

        add(panel);

//        add(organizationsListComponent);

        //Информация об организации
        /*JPanel organizationInfoPanel = new JPanel();
        organizationInfoPanel.setLayout(new BoxLayout(organizationInfoPanel, BoxLayout.PAGE_AXIS));
        organizationInfoPanel.setBorder(BorderFactory.createTitledBorder("Информация об организации")); //ToDo: local
        ((TitledBorder) organizationInfoPanel.getBorder()).setTitleFont(Constants.FONT_BOLD);
        organizationForm = new OrganizationForm("Выберите организацию", "Выберите организацию", "Выберите организацию",
                false, Constants.DEFAULT_FORM_COMPOSER);
        //organizationInfoPanel.add(organizationForm);
        //organizationInfoPanel.add(Box.createVerticalGlue());

        // Раздел с информацией об объектах
        JPanel objectsSide = new JPanel();
        objectsSide.setLayout(new BoxLayout(objectsSide, BoxLayout.LINE_AXIS));
        objectsSide.setBorder(BorderFactory.createTitledBorder("???"));

        //Список объектов
        orgObjectsListComponent = new EntitiesListComponent<>();
        objectsSide.add(orgObjectsListComponent);
        objectsSide.add(Box.createHorizontalGlue());
        objectsSide.add(new JTextArea());

        //Информация об объекте
        JPanel objectInfoPanel = new JPanel();
        objectInfoPanel.setBorder(BorderFactory.createTitledBorder("Информация об объекте"));
        ((TitledBorder) objectInfoPanel.getBorder()).setTitleFont(Constants.FONT_BOLD);
        objectInfoPanel.setLayout(new BoxLayout(objectInfoPanel, BoxLayout.PAGE_AXIS));
        objectInfoPanel.add(objectsSide);
        organizationInfoPanel.add(objectsSide);

//        organizationInfoPanel.add(Box.createVerticalStrut(20));


        add(organizationInfoPanel);*/
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

    public void showOrganizationInfo(Organization organization) {
        LinkedHashMap fields = organizationForm.getFormComponents();
        ((EntityTextFieldComponent) fields.get("Название")).setField(organization.getName());
        ((EntityTextFieldComponent) fields.get("Адрес")).setField(organization.getLegalAddress());
        ((EntityTextFieldComponent) fields.get("Номер телефона")).setField(organization.getPhoneNum());
    }

    public boolean isOrganizationSelectionEmpty() {
        return organizationsListComponent.getObjectsList().isSelectionEmpty();
    }

    public boolean isOrgObjectSelectionEmpty() {
        return orgObjectsListComponent.getObjectsList().isSelectionEmpty();
    }

    public void deselectOrganizationForm() {
        for (JComponent c : organizationForm.getFormComponents().values()) {
            ((EntityTextFieldComponent) c).setField("Выберите организацию");
        }
    }
}
