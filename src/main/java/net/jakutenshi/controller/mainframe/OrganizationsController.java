package net.jakutenshi.controller.mainframe;

import net.jakutenshi.controller.Controller;
import net.jakutenshi.model.entities.Organization;
import net.jakutenshi.model.tables.AbstractTable;
import net.jakutenshi.ui.forms.EntityForm;
import net.jakutenshi.ui.forms.OrganizationForm;
import net.jakutenshi.ui.views.OrganizationsView;
import net.jakutenshi.utils.UIUtilFunctions;

import javax.swing.*;
import java.util.LinkedHashMap;

public class OrganizationsController extends Controller<OrganizationsView, AbstractTable> {



    public OrganizationsController() {
        super();
    }

    public OrganizationsController(Controller root, OrganizationsView view, AbstractTable model) {
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
        getView().getOrganizationsPanel().getAddButton().addActionListener(actionEvent -> {
            System.out.println("!");
            if (isOrganizationSelectionEmpty()) {
                UIUtilFunctions.showMessageDialog(getView(), "Организация не выбрана!");
                return;
            }
            Organization selectedOrganization = getView().getSelectedOrganization();
            EntityForm form = new EntityForm("Создать новую организацию", new OrganizationForm(
                    selectedOrganization.getName(),
                    selectedOrganization.getLegalAddress(),
                    selectedOrganization.getPhoneNum(), true, (pane, components) -> {
                        pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
                        for(JComponent c : components.values()) {
                           pane.add(c);
                        }
                    }));
            form.getAddButton().addActionListener(addNewOrganizetionEvent -> {
                LinkedHashMap<String, String> values = form.getForm().getValues();
                Organization result;
                if ((result = (Organization) getModel().insert(
                        new Organization(-1,
                                values.get("Название"),
                                values.get("Адрес"),
                                values.get("Номер телефона")))) != null) {
                    updateOrganizationsView();
                } else {
                    UIUtilFunctions.showMessageDialog(getView(), "Не получилось удалить организацию"); //ToDo
                }
                form.dispose();
            });
            form.setVisible(true);
        });
    }

    private void createOrganizationSelectionAction() {
        getView().getOrganizationsPanel().getObjectsList().addListSelectionListener(listSelectionEvent -> {
            if (listSelectionEvent.getValueIsAdjusting()) {
                getView().showOrganizationInfo(getView().getSelectedOrganization());
                //return;
            }
            //getView().showOrganizationInfo(getView().getSelectedOrganization());
        });
    }

    private void createRemoveOrganizationButton() {
        getView().getOrganizationsPanel().getRemoveButton().addActionListener(actionEvent -> {
            if (isOrganizationSelectionEmpty()) {
                UIUtilFunctions.showMessageDialog(getView(), "Организация не выбрана!");
                return;
            }
            if (UIUtilFunctions.isConfirmDialog(getView(),
                    "Вы точно хотите удалить организацию " + getView().getSelectedOrganization().getName() + " ?",
                    "Подтверждение удаления")) {
                if (getModel().delete(getView().getSelectedOrganization())) {
                    updateOrganizationsView();
                    UIUtilFunctions.showMessageDialog(getView(), "Организация удалена");
                } else {
                    UIUtilFunctions.showMessageDialog(getView(), "Не удалось удалить организацию!");
                }
            }
        });
    }

    private void updateOrganizationsView() {
        getView().getOrganizationsPanel().setModel(getModel());
    }

    private boolean isOrganizationSelectionEmpty() {
        return getView().getOrganizationsPanel().getObjectsList().isSelectionEmpty();
    }
}
