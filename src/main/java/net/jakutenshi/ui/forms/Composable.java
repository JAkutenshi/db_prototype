package net.jakutenshi.ui.forms;

import javax.swing.*;
import java.util.LinkedHashMap;

public interface Composable {
    void compose(JComponent pane, LinkedHashMap<String, JComponent> components);
}
