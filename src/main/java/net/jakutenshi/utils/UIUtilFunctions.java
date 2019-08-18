package net.jakutenshi.utils;

import javax.swing.*;
import java.awt.*;

public class UIUtilFunctions {
    public static void changeFont ( Component component, Font font )
    {
        component.setFont ( font );
        if ( component instanceof Container)
        {
            for ( Component child : ( ( Container ) component ).getComponents () )
            {
                changeFont ( child, font );
            }
        }
    }

    public static boolean isConfirmDialog(Component source, String message, String title) {
        return JOptionPane.showOptionDialog( source, message, title,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new String[] {"Да", "Нет"}, "Нет" ) == 0;
    }

    public static void showMessageDialog(Component source, String message) {
        JOptionPane.showMessageDialog(source, message, "Сообщение от программы", JOptionPane.INFORMATION_MESSAGE);
    }


}
