package net.jakutenshi;

import net.jakutenshi.controller.OrganizationsController;
import net.jakutenshi.ui.MainFrame;
import net.jakutenshi.utils.locales.InterfaceLocale_ru_RU;

import java.util.ResourceBundle;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        //DBConnection.connect("jdbc:sqlite:/home/jakutenshi/projects/java/db_prototype/src/main/resources/security_corp.sqlite3");


        OrganizationsController c = new OrganizationsController();
        ResourceBundle locale_RU = new InterfaceLocale_ru_RU();
        MainFrame frame =  new MainFrame(locale_RU.getString("title"), locale_RU, c.getView());
        frame.setVisible(true);

    }
}
