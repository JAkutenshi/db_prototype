package net.jakutenshi.ui.forms;

import net.jakutenshi.ui.components.EntityTextFieldComponent;
import net.jakutenshi.utils.Constants;

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

        name.setFont(Constants.FONT_BOLD);
        phoneNum.setFont(Constants.FONT_BOLD);

        if (isEnabled) {
            name.setEnabled(true);
            address.setEnabled(true);
            phoneNum.setEnabled(true);
        }
        setCompositor(compositor);
        this.compose();
    }
}
