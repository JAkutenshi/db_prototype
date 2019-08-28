package net.jakutenshi.ui.forms;

import net.jakutenshi.ui.components.FieldComponent;

import javax.swing.*;
import java.util.LinkedHashMap;

public interface Composable {
    void compose(JComponent pane, LinkedHashMap<String, FieldComponent> components);
}
