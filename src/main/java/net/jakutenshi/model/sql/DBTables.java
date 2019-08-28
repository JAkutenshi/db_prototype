package net.jakutenshi.model.sql;

import net.jakutenshi.model.entities.*;
import net.jakutenshi.model.entities.enums.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;

public enum DBTables {
    ABSENCE,
    ABSENCE_REASON,
    ARRIVAL_METHOD,
    AUTO_TYPE,
    CATEGORY,
    DUTY,
    EMPLOYEE,
    ORGANIZATION,
    ORG_OBJECT,
    POSITION,
    POST,
    SALARY_TYPE;

    public SQLEntity getEntity(ResultSet rs) throws SQLException {
        switch (this) {
            case ABSENCE:
                return new Absence(rs);
            case ABSENCE_REASON:
                return new AbsenceReason(rs);
            case ARRIVAL_METHOD:
                return new ArrivalMethod(rs);
            case AUTO_TYPE:
                return new AutoType(rs);
            case CATEGORY:
                return new Category(rs);
            case DUTY:
                return new Duty(rs);
            case EMPLOYEE:
                return new Employee(rs);
            case ORGANIZATION:
                return new Organization(rs);
            case ORG_OBJECT:
                return new OrgObject(rs);
            case POSITION:
                return new Position(rs);
            case POST:
                return new Post(rs);
            case SALARY_TYPE:
                return new SalaryType(rs);
            default:
                return null;
        }
    }

    public String getTableName() {
        switch (this) {

            case ABSENCE:
                return "Absence";
            case ABSENCE_REASON:
                return "AbsenceReason";
            case ARRIVAL_METHOD:
                return "ArrivalMethod";
            case AUTO_TYPE:
                return "AutoType";
            case CATEGORY:
                return "Category";
            case DUTY:
                return "Duty";
            case EMPLOYEE:
                return "Employee";
            case ORGANIZATION:
                return "Organization";
            case ORG_OBJECT:
                return "OrgObject";
            case POSITION:
                return "Position";
            case POST:
                return "Post";
            case SALARY_TYPE:
                return "SalaryType";
            default:
                return null;
        }
    }

    public SQLSchema getTableSchema() {
        LinkedHashMap<String, SQLiteType> schema = new LinkedHashMap<>();
        switch (this) {
            case ABSENCE:
                schema.put("id",                       SQLiteType.INTEGER);
                schema.put("duty_id",                  SQLiteType.INTEGER);
                schema.put("reason_id",                SQLiteType.INTEGER);
                return new SQLSchema(schema);
            case ABSENCE_REASON:
                schema.put("id",                       SQLiteType.INTEGER);
                schema.put("reason_name",              SQLiteType.TEXT);
                return new SQLSchema(schema);
            case ARRIVAL_METHOD:
                schema.put("id",                       SQLiteType.INTEGER);
                schema.put("driver_id",                SQLiteType.INTEGER);
                schema.put("auto_type_id",             SQLiteType.INTEGER);
                schema.put("auto_number",              SQLiteType.TEXT);
                schema.put("arriving_time",            SQLiteType.DATE);
                schema.put("frequency",                SQLiteType.INTEGER);
                schema.put("arrives_from",             SQLiteType.TEXT);
                return new SQLSchema(schema);
            case AUTO_TYPE:
            case SALARY_TYPE:
                schema.put("id",                       SQLiteType.INTEGER);
                schema.put("type_name",                SQLiteType.TEXT);
                return new SQLSchema(schema);
            case CATEGORY:
            case POSITION:
                schema.put("id",                       SQLiteType.INTEGER);
                schema.put("name",                     SQLiteType.TEXT);
                return new SQLSchema(schema);
            case DUTY:
                schema.put("id",                       SQLiteType.INTEGER);
                schema.put("security_id",              SQLiteType.INTEGER);
                schema.put("post_id",                  SQLiteType.INTEGER);
                schema.put("position_id",              SQLiteType.INTEGER);
                schema.put("category_id",              SQLiteType.INTEGER);
                schema.put("date",                     SQLiteType.DATE);
                schema.put("total_hours",              SQLiteType.INTEGER);
                schema.put("night_hours",              SQLiteType.INTEGER);
                schema.put("is_holiday",               SQLiteType.INTEGER);
                schema.put("salary_type_id",           SQLiteType.INTEGER);
                schema.put("salary",                   SQLiteType.NUMERIC);
                return new SQLSchema(schema);
            case EMPLOYEE:
                schema.put("id",                       SQLiteType.INTEGER);
                schema.put("second_name",              SQLiteType.TEXT);
                schema.put("first_name",               SQLiteType.TEXT);
                schema.put("middle_name",              SQLiteType.TEXT);
                schema.put("phone_number",             SQLiteType.TEXT);
                schema.put("PSD_expiration_date",      SQLiteType.DATE);
                schema.put("training_expiration_date", SQLiteType.DATE);
                schema.put("is_reserved",              SQLiteType.INTEGER);
                schema.put("main_post_id",             SQLiteType.INTEGER);
                schema.put("position_id",              SQLiteType.INTEGER);
                schema.put("category_id",              SQLiteType.INTEGER);
                schema.put("note",                     SQLiteType.TEXT);
                return new SQLSchema(schema);
            case ORGANIZATION:
                schema.put("id",                       SQLiteType.INTEGER);
                schema.put("name",                     SQLiteType.TEXT);
                schema.put("legal_address",            SQLiteType.TEXT);
                schema.put("phone_num",                SQLiteType.TEXT);
                return new SQLSchema(schema);
            case ORG_OBJECT:
                schema.put("id",                       SQLiteType.INTEGER);
                schema.put("organization_id",          SQLiteType.INTEGER);
                schema.put("name",                     SQLiteType.TEXT);
                schema.put("address",                  SQLiteType.TEXT);
                schema.put("phone_mum",                SQLiteType.TEXT);
                schema.put("security_head_id",         SQLiteType.INTEGER);
                schema.put("salary_ratio",             SQLiteType.NUMERIC);
                schema.put("salary_type_id",           SQLiteType.INTEGER);
                return new SQLSchema(schema);
            case POST:
                schema.put("id",                       SQLiteType.INTEGER);
                schema.put("object_id",                SQLiteType.INTEGER);
                schema.put("name",                     SQLiteType.TEXT);
                schema.put("address",                  SQLiteType.TEXT);
                schema.put("phone_num",                SQLiteType.TEXT);
                schema.put("number",                   SQLiteType.INTEGER);
                schema.put("guards_changing_freq",     SQLiteType.INTEGER);
//                schema.put("surcharge",                SQLiteType.NUMERIC);
//                schema.put("checkage",                 SQLiteType.NUMERIC);
                schema.put("arrival_method_id",        SQLiteType.INTEGER);
                return new SQLSchema(schema);
            default:
                return null;
        }
    }

    public String[] getColumnNames() {
        switch (this) {
            case ABSENCE:
                return new String[] {
                        "Номер дежурства",
                        "Причина" };
            case ABSENCE_REASON:
                return new String[] { "Причина" };
            case ARRIVAL_METHOD:
                return new String[] {
                        "Водитель",
                        "Тип А/Т",
                        "Номер А/Т",
                        "Время прибытия",
                        "Периодичность",
                        "Место выезда" };
            case AUTO_TYPE:
                return new String[] { "Тип А/Т" };
            case CATEGORY:
                return new String[] { "Категория" };
            case DUTY:
                return new String[] {
                        "#",
                        "Охранник",
                        "Пост",
                        "Должность",
                        "Категория",
                        "Дата",
                        "Кол-во часов",
                        "Ночных часов",
                        "Выходной?",
                        "Тип З/П",
                        "Итого З/П" };
            case EMPLOYEE:
                return new String[] {
                        "Фамилия",
                        "Имя",
                        "Отчество",
                        "Телефон",
                        "Действие УЧО",
                        "Действие подготовки",
                        "Резерв?",
                        "Основной пост",
                        "Должность",
                        "Категория",
                        "Информация"
                };
            case ORGANIZATION:
                return new String[] {
                        "Название",
                        "Юр. Адрес",
                        "Телефон" };
            case ORG_OBJECT:
                return new String[] {
                        "Организация",
                        "Название",
                        "Адрес",
                        "Телефон",
                        "Нач. охраны",
                        "Коэфф. З/П",
                        "Тип З/П" };
            case POSITION:
                return new String[] { "Должность" };
            case POST:
                return new String[] {
                        "Объект",
                        "Название",
                        "Адрес",
                        "Телефон",
                        "Номер",
                        "Частота смены",
//                        "Доплата",
//                        "Вычет",
                        "Способ прибытия" };
            case SALARY_TYPE:
                return new String[] { "Тип З/П" };
            default:
                return null;
        }
    }

    public boolean isIDVisible() {
        switch (this) {
            case ABSENCE:
            case ABSENCE_REASON:
            case ARRIVAL_METHOD:
            case AUTO_TYPE:
            case CATEGORY:
            case ORGANIZATION:
            case ORG_OBJECT:
            case POSITION:
            case POST:
            case SALARY_TYPE:
                return false;
            case DUTY:
            case EMPLOYEE:
            default:
                return true;
        }
    }
}
