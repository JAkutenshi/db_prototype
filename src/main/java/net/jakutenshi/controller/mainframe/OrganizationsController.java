package net.jakutenshi.controller.mainframe;

import net.jakutenshi.controller.Controller;
import net.jakutenshi.model.ModelsMap;
import net.jakutenshi.model.entities.Organization;
import net.jakutenshi.model.tables.Model;
import net.jakutenshi.ui.forms.EntityForm;
import net.jakutenshi.ui.forms.OrganizationForm;
import net.jakutenshi.ui.views.OrganizationsView;
import net.jakutenshi.utils.UIUtilFunctions;

import javax.swing.*;
import java.util.LinkedHashMap;

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
            EntityForm form = new EntityForm("Создать новую организацию", new OrganizationForm(
                    selectedOrganization == null ? "Новая организация" : selectedOrganization.getName(),
                    selectedOrganization == null ? "Новый адрес"       : selectedOrganization.getLegalAddress(),
                    selectedOrganization == null ? "+70000000000"      : selectedOrganization.getPhoneNum(),
                    true, (pane, components) -> {
                        pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
                        for(JComponent c : components.values()) {
                           pane.add(c);
                        }
                    }));

            form.getAddButton().addActionListener(addNewOrganizetionEvent -> {
                LinkedHashMap<String, String> values = form.getForm().getValues();
                form.dispose();

                Organization result;
                if ((result = (Organization) getModel("organizations").insert(
                        new Organization(-1,
                                values.get("Название"),
                                values.get("Адрес"),
                                values.get("Номер телефона")))) != null) {
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
                getView().showOrganizationInfo(getView().getSelectedOrganization());
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
        getView().deselectOrganizationForm();

    }

    public void updateOrgObjectsInfo() {
        updateModel("objects", Model.ORG_OBJECTS.selectToTable(object -> {
            if (getView().isOrgObjectSelectionEmpty()) { return false; }
            if (getView().getSelectedOrgObject().getID() == object.getOrganizationID()) { return true; }
            return false;
        }));
    }

}
