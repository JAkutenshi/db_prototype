package net.jakutenshi.ui.views;

import net.jakutenshi.ui.components.EntitiesListPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OrganizationsView extends JPanel {

    private EntitiesListPanel organizationsPanel;

    public OrganizationsView() {
        super();
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        //organizationsPanel = new EntitiesListPanel(organizations);
        add(organizationsPanel, c);

        JPanel postsPanel = new JPanel(new GridBagLayout());
        postsPanel.setBorder(BorderFactory.createTitledBorder("Объекты")); //ToDo: local
        c.insets = new Insets(10, 10, 10, 10);
        add(postsPanel, c);
        //postsPanel.add(new EntitiesListPanel(), c);

        //JPanel postInfo
    }

    public EntitiesListPanel getOrganizationsPanel() {
        return organizationsPanel;
    }
}
