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

    public final static Font FONT_TERMINUS        = new  Font("Terminus (TTF)", Font.PLAIN, 16);
    public final static Font FONT_TERMINUS_BOLD   = new  Font("Terminus (TTF)", Font.BOLD, 16);
    public final static Font FONT_TERMINUS_ITALIC = new  Font("Terminus (TTF)", Font.ITALIC, 16);

    public final static int TEXT_FIELD_HEIGHT   = 30;
    public final static int TEXT_FIELD_WIDTH    = 120;
    public final static int ENTITIES_LIST_WIDTH = 350;

    public final static Dimension BUTTON_SIZE = new Dimension(Integer.MAX_VALUE, TEXT_FIELD_HEIGHT);

    public final static Composable DEFAULT_FORM_COMPOSER = (pane, components) -> {
        pane.setLayout(new BoxLayout(pane, BoxLayout.LINE_AXIS));
        for (JComponent c : components.values()) {
            pane.add(c);
        }
    };
}
