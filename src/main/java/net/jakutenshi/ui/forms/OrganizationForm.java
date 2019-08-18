package net.jakutenshi.ui.forms;

import net.jakutenshi.ui.components.EntityTextFieldComponent;

public class OrganizationForm extends Form {
    private EntityTextFieldComponent name;
    private EntityTextFieldComponent address;
    private EntityTextFieldComponent phoneNum;

    public OrganizationForm(
            String initName,
            String initAddress,
            String initPhoneNum,
            boolean isEnabled,
            Composable compositor
    ) {
        super();
        this.addFormComponent("Название",       name = new EntityTextFieldComponent("Название", initName, false));
        this.addFormComponent("Адрес",          address = new EntityTextFieldComponent("Адрес", initAddress, false));
        this.addFormComponent("Номер телефона", phoneNum = new EntityTextFieldComponent("Номер телефона", initPhoneNum, false));

        if (isEnabled) {
            name.setEnabled(true);
            address.setEnabled(true);
            phoneNum.setEnabled(true);
        }
        setCompositor(compositor);
        this.compose();
    }
}
