package net.jakutenshi.utils;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

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

    public final static int TEXT_FIELD_HEIGHT = 25;
}
