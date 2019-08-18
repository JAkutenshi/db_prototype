package net.jakutenshi.ui.forms;

import jdk.vm.ci.meta.Constant;
import net.jakutenshi.ui.components.buttons.ButtonFactory;
import net.jakutenshi.utils.Constants;
import net.jakutenshi.utils.UIUtilFunctions;

import javax.swing.*;
import java.awt.*;

public class EntityForm extends JFrame {
    Form form;
    JButton addButton;
    JButton cancelButton;

    public EntityForm(String title, Form form) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(650, 480);
        this.form = form;
        init();
    }

    private void init() {
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        this.add(this.form);
        this.add(Box.createVerticalGlue());

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.LINE_AXIS));

        buttonsPanel.add(Box.createHorizontalGlue());

        addButton = ButtonFactory.createButton("Добавить");
        buttonsPanel.add(addButton);
        cancelButton = ButtonFactory.createButton("Отменить");
        buttonsPanel.add(cancelButton);
        this.add(buttonsPanel);

        cancelButton.addActionListener(actionEvent -> {
            if (UIUtilFunctions.isConfirmDialog(this, "Вы точно хотите отменить  добавление?", "Отмена")) {
                this.dispose();
            }
        });
    }

    public JButton getAddButton() {
        return addButton;
    }

    public Form getForm() {
        return form;
    }
}
