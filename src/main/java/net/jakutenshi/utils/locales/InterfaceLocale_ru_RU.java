package net.jakutenshi.utils.locales;

import java.util.ListResourceBundle;

public class InterfaceLocale_ru_RU extends ListResourceBundle {
    private Object[][] contents = {
            {"title", "БД Охранного Предприятия"},
            {"organisation_tab_title", "Организации"},
            {"employees_tab_title", "Сотрудники"},
            {"posts_tab_title", "Посты"},
            {"salary_tab_title", "Зарплата"},
            {"duties_log_tab_title", "Дежурства"}
    };
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
