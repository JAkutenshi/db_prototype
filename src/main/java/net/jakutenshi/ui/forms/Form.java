package net.jakutenshi.ui.forms;

import jdk.vm.ci.meta.Constant;
import net.jakutenshi.utils.Constants;

import javax.swing.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

public abstract class Form extends JPanel {
    private LinkedHashMap<String, JComponent> formComponents;
    private Composable compositor = Constants.DEFAULT_FORM_COMPOSER;

    public Form() {
        super();
        this.formComponents = new LinkedHashMap<>();
    }

    public Form(LinkedHashMap<String, JComponent> formComponents, Composable compositor) {
        super();
        this.formComponents = formComponents;
        setCompositor(compositor);
    };

    public void setEnabled(boolean isEnabled) {
        for (JComponent c : formComponents.values()) {
            c.setEnabled(isEnabled);
        }
    }

    public LinkedHashMap<String, JComponent> getFormComponents() {
        return formComponents;
    }

    public void setFormComponents(LinkedHashMap<String, JComponent> formComponents) {
        this.formComponents = formComponents;
    }


    public void addFormComponent(String title, JComponent component) {
        formComponents.put(title, component);
    }

    public LinkedHashMap<String, String> getValues() {
        LinkedHashMap<String, String> result = new LinkedHashMap<String, String>();
        for(String key : formComponents.keySet()) {
            result.put(key, formComponents.get(key).toString());
        }
        return result;
    }

    public void setCompositor(Composable compositor) {
        this.compositor = compositor;
    }

    public void compose() {
        compositor.compose(this, formComponents);
    }

}
