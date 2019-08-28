package net.jakutenshi.controller.mainframe;

import net.jakutenshi.controller.Controller;
import net.jakutenshi.model.ModelsMap;
import net.jakutenshi.model.entities.OrgObject;
import net.jakutenshi.model.entities.Organization;
import net.jakutenshi.model.tables.Model;
import net.jakutenshi.ui.components.EntityTextFieldComponent;
import net.jakutenshi.ui.forms.EntityForm;
import net.jakutenshi.ui.forms.OrgObjectForm;
import net.jakutenshi.ui.forms.OrganizationForm;
import net.jakutenshi.ui.views.OrganizationsView;
import net.jakutenshi.utils.UIUtilFunctions;

import java.util.LinkedHashMap;

import static net.jakutenshi.utils.Constants.PAGE_FORM_COMPOSER;

public class OrganizationsController extends Controller<OrganizationsView> {

    public OrganizationsController() {
        super();
    }

    public OrganizationsController(Controller root, OrganizationsView view, ModelsMap model) {
        super(root, view, model);
        createListeners();
    }

    @Override
    public Controller setView(OrganizationsView view) {
        super.setView(view);
        createListeners();
        return this;
    }

    private void createListeners() {
        createAddOrganizationButtonAction();
        createOrganizationSelectionAction();
        createRemoveOrganizationButton();
    }

    private void createAddOrganizationButtonAction() {
        getView().getOrganizationsListComponent().getAddButton().addActionListener(actionEvent -> {
            System.out.println("!");
            Organization selectedOrganization = getView().getSelectedOrganization();
            OrganizationForm form = new OrganizationForm(
                    selectedOrganization == null ? "Новая организация" : selectedOrganization.getName(),
                    selectedOrganization == null ? "Новый адрес"       : selectedOrganization.getLegalAddress(),
                    selectedOrganization == null ? "+70000000000"      : selectedOrganization.getPhoneNum(),
                    true, PAGE_FORM_COMPOSER );
            EntityForm frame = new EntityForm("Создать новую организацию", form);

            frame.getAddButton().addActionListener(addNewOrganizetionEvent -> {
                LinkedHashMap<String, Object> values = frame.getForm().getValues();
                frame.dispose();

                Organization newOrganization = new Organization( -1,
                        values.get("Название").toString(),
                        values.get("Адрес").toString(),
                        values.get("Номер телефона").toString());
                Organization result = (Organization) getModel("organizations").insert(newOrganization);
                if (result != null) {
                    updateOrganizationsView();
                    UIUtilFunctions.showMessageDialog(getView(), "Новая организация " + result.getName() + "  добавлена!");
                } else {
                    UIUtilFunctions.showMessageDialog(getView(), "Не получилось добавить организацию"); //ToDo
                }
            });
            form.setVisible(true);
        });
    }

    private void createOrganizationSelectionAction() {
        getView().getOrganizationsListComponent().getObjectsList().addListSelectionListener(listSelectionEvent -> {
            if (listSelectionEvent.getValueIsAdjusting()) {
                showOrganizationInfo(getView().getSelectedOrganization());
                //return;
            }
            //getView().showOrganizationInfo(getView().getSelectedOrganization());
        });
    }

    private void createRemoveOrganizationButton() {
        getView().getOrganizationsListComponent().getRemoveButton().addActionListener(actionEvent -> {
            if (getView().isOrganizationSelectionEmpty()) {
                UIUtilFunctions.showMessageDialog(getView(), "Организация не выбрана!");
                return;
            }
            if (UIUtilFunctions.isConfirmDialog(getView(),
                    "Вы точно хотите удалить организацию " + getView().getSelectedOrganization().getName() + " ?",
                    "Подтверждение удаления")) {
                if (getModel("organizations").delete(getView().getSelectedOrganization())) {
                    updateOrganizationsView();
                    UIUtilFunctions.showMessageDialog(getView(), "Организация удалена");
                } else {
                    UIUtilFunctions.showMessageDialog(getView(), "Не удалось удалить организацию!");
                }
            }
        });
    }

    public void updateOrganizationsView() {
        getView().getOrganizationsListComponent().setModel(getModel("organizations"));
        getView().deselectOrganizationView();

    }

    public void showOrganizationInfo(Organization organization) {
        LinkedHashMap organizationFields = getView().getOrganizationForm().getFormComponents();
        ((EntityTextFieldComponent) organizationFields.get("Название")).setField(organization.getName());
        ((EntityTextFieldComponent) organizationFields.get("Адрес")).setField(organization.getLegalAddress());
        ((EntityTextFieldComponent) organizationFields.get("Номер телефона")).setField(organization.getPhoneNum());

        getView().getOrgObjectsListComponent().setModel(Model.ORG_OBJECTS.selectToTable(
                object -> organization.getID() == object.getOrganizationID()
                ));
    }

    public void createAddOrgObjectActionListener() {
        getView().getOrgObjectsListComponent().getAddButton().addActionListener(actionEvent -> {
            OrgObject selectedOrgObject = getView().getSelectedOrgObject();
            OrgObjectForm form = new OrgObjectForm(
                selectedOrgObject.getName(),
                selectedOrgObject.getAddress(),
                selectedOrgObject.getPhoneNum(),
                Model.ORGANIZATIONS.getEntity(selectedOrgObject.getOrganizationID()),
                Model.EMPLOYEES.getEntity(selectedOrgObject.getSecurityHeadID()),
                String.valueOf(selectedOrgObject.getSalaryRatio()),
                Model.SALARY_TYPES.getEntity(selectedOrgObject.getSalaryTypeID()),
                true, PAGE_FORM_COMPOSER);

            EntityForm frame = new EntityForm("Новый объект", form);
            frame.getAddButton().addActionListener(addNewObjectListener -> {
                LinkedHashMap<String, Object> values = frame.getForm().getValues();
                frame.dispose();

                OrgObject newOrgObject = new OrgObject( -1,

                );
                OrgObject result = (OrgObject) getModel("org_objects").insert(newOrgObject);
                if (result != null) {
                    updateOrgObjectsInfo();
                    UIUtilFunctions.showMessageDialog(getView(), "Новая организация " + result.getName() + "  добавлена!");
                } else {
                    UIUtilFunctions.showMessageDialog(getView(), "Не получилось добавить организацию"); //ToDo
                }
            });
        });
    }

    public void updateOrgObjectsInfo() {
        updateModel("objects", Model.ORG_OBJECTS.selectToTable(object -> {
            if (getView().isOrgObjectSelectionEmpty()) { return false; }
            if (getView().getSelectedOrgObject().getID() == object.getOrganizationID()) { return true; }
            return false;
        }));
        //ToDo
    }

}
