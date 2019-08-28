package net.jakutenshi.ui.forms;

import net.jakutenshi.controller.mainframe.EmploeesController;
import net.jakutenshi.model.entities.Employee;
import net.jakutenshi.model.entities.Organization;
import net.jakutenshi.model.entities.enums.SalaryType;
import net.jakutenshi.model.tables.Model;
import net.jakutenshi.ui.components.EntitiesListComponent;
import net.jakutenshi.ui.components.EntityComboBoxComponent;
import net.jakutenshi.ui.components.EntityTextFieldComponent;
import net.jakutenshi.utils.Constants;

import javax.swing.*;

import static net.jakutenshi.utils.Constants.FONT_BOLD;

public class OrgObjectForm extends Form {
    private EntityTextFieldComponent              name;
    private EntityTextFieldComponent              address;
    private EntityTextFieldComponent              phoneNum;
    private EntityComboBoxComponent<Organization> organizationList;
    private EntityComboBoxComponent<Employee>     securityHeadList;
    private EntityTextFieldComponent              salaryRatio;
    private EntityComboBoxComponent<SalaryType>   salaryTypeList;

    public OrgObjectForm(
            String       initName,
            String       initAddress,
            String       initPhoneNum,
            Organization initOrganization,
            Employee     initSecurityHead,
            String       initSalaryRatio,
            SalaryType   initSalaryType,
            boolean      isEnabled,
            Composable   compositor
    ) {
        super();
        this.addFormComponent("name", name = new EntityTextFieldComponent("Название", initName, false));
        this.addFormComponent("address", address = new EntityTextFieldComponent("Адрес", initAddress, false));
        this.addFormComponent("phone_num", phoneNum = new EntityTextFieldComponent("Номер телефона", initPhoneNum, false));
        this.addFormComponent("_organization", organizationList
                = new EntityComboBoxComponent<>(Model.ORGANIZATIONS, "Организации", initOrganization));
        this.addFormComponent("_security_head", securityHeadList
                = new EntityComboBoxComponent<>(Model.EMPLOYEES, "Начальник охраны", initSecurityHead));
        this.addFormComponent("salary_ratio", salaryRatio = new EntityTextFieldComponent("Коэффициент З/П", initSalaryRatio, false));
        this.addFormComponent("_salary_type", salaryTypeList
                = new EntityComboBoxComponent<>(Model.SALARY_TYPES, "Способ оплаты", initSalaryType));

        name.setFont(FONT_BOLD);
        phoneNum.setFont(FONT_BOLD);
        securityHeadList.setFont(FONT_BOLD);

        if (isEnabled) {
            for (JPanel c : super.getFormComponents().values()) {
                c.setEnabled(true);
            }
        }
        setCompositor(compositor);
        this.compose();
    }
}
