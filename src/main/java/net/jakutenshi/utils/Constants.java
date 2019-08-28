package net.jakutenshi.utils;

import net.jakutenshi.ui.forms.Composable;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;

public class Constants {
    public final static String NONE       = "NONE";
    public final static String PHONE_NONE = "+00000000000";
    public final static Date   DATE_NONE  = new Date(0);

    public final static SimpleDateFormat SQLITE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public final static SimpleDateFormat DATE_FORMAT        = new SimpleDateFormat("dd.MM.yyyy");
    public final static SimpleDateFormat TIME_FORMAT        = new SimpleDateFormat("HH:mm");

    public final static Font FONT = new  Font("Terminus (TTF)", Font.PLAIN, 20);
    public final static Font FONT_BOLD = new  Font("Terminus (TTF)", Font.BOLD, 20);
    public final static Font FONT_ITALIC = new  Font("Terminus (TTF)", Font.ITALIC, 20);

    public final static int TEXT_FIELD_HEIGHT   = 30;
    public final static int TEXT_FIELD_WIDTH    = 120;
    public final static int ENTITIES_LIST_WIDTH = 350;

    public final static Dimension BUTTON_SIZE = new Dimension(Integer.MAX_VALUE, TEXT_FIELD_HEIGHT);

    public final static Composable FLOW_FORM_COMPOSER = (pane, components) -> {
        pane.setLayout(new FlowLayout());
        for(JComponent c : components.values()) {
            pane.add(c);
        }
    };

    public final static Composable PAGE_FORM_COMPOSER = (pane, components) -> {

        pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
        int width = 0;
        int height = 0;
        for(JComponent c : components.values()) {
            pane.add(c);
            width += c.getWidth();
            if (c.getHeight() > height) { height = c.getHeight(); }
        }
        pane.setSize(width, height);
    };

    public final static Composable LINE_FORM_COMPOSER = (pane, components) -> {
        int width = 0;
        int height = 0;
        pane.setLayout(new BoxLayout(pane, BoxLayout.LINE_AXIS));
        for (JComponent c : components.values()) {
            pane.add(c);
            width += c.getWidth();
            if (c.getHeight() > height) { height = c.getHeight(); }
        }
        pane.setSize(width, height);
    };

    public final static Composable DEFAULT_FORM_COMPOSER = LINE_FORM_COMPOSER;
}
