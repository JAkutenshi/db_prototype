package net.jakutenshi.ui.forms;

import jdk.vm.ci.meta.Constant;
import net.jakutenshi.ui.components.FieldComponent;
import net.jakutenshi.utils.Constants;

import javax.swing.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

public abstract class Form extends JPanel {
    private LinkedHashMap<String, FieldComponent> formComponents;
    private Composable compositor = Constants.DEFAULT_FORM_COMPOSER;

    public Form() {
        super();
        this.formComponents = new LinkedHashMap<>();
    }

    public Form(LinkedHashMap<String, FieldComponent> formComponents, Composable compositor) {
        super();
        this.formComponents = formComponents;
        setCompositor(compositor);
    };

    public void setEnabled(boolean isEnabled) {
        for (FieldComponent c : formComponents.values()) {
            c.setEnabled(isEnabled);
        }
    }

    public LinkedHashMap<String, FieldComponent> getFormComponents() {
        return formComponents;
    }

    public void setFormComponents(LinkedHashMap<String, FieldComponent> formComponents) {
        this.formComponents = formComponents;
    }


    public void addFormComponent(String title, FieldComponent component) {
        formComponents.put(title, component);
    }

    public LinkedHashMap<String, Object> getValues() {
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        for(String key : formComponents.keySet()) {
            result.put(key, formComponents.get(key).getValue());
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
