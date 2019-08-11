package net.jakutenshi.model.tables;

import net.jakutenshi.model.entities.*;
import net.jakutenshi.model.entities.enums.*;
import net.jakutenshi.model.sql.DBTables;

public class Model {
    final public static AbstractTable<AbsenceReason> ABSENCE_REASONS = new AbstractTable<>(DBTables.ABSENCE_REASON);
    final public static AbstractTable<AutoType>      AUTO_TYPES      = new AbstractTable<>(DBTables.AUTO_TYPE);
    final public static AbstractTable<Category>      CATEGORIES      = new AbstractTable<>(DBTables.CATEGORY);
    final public static AbstractTable<Position>      POSITIONS       = new AbstractTable<>(DBTables.POSITION);
    final public static AbstractTable<SalaryType>    SALARY_TYPES    = new AbstractTable<>(DBTables.SALARY_TYPE);
    final public static AbstractTable<Absence>       ABSENCES        = new AbstractTable<>(DBTables.ABSENCE);
    final public static AbstractTable<ArrivalMethod> ARRIVAL_METHODS = new AbstractTable<>(DBTables.ARRIVAL_METHOD);
    final public static AbstractTable<Duty>          DUTIES          = new AbstractTable<>(DBTables.DUTY);
    final public static AbstractTable<Employee>      EMPLOYEES       = new AbstractTable<>(DBTables.EMPLOYEE);
    final public static AbstractTable<Organization>  ORGANIZATIONS   = new AbstractTable<>(DBTables.ORGANIZATION);
    final public static AbstractTable<OrgObject>     ORG_OBJECTS     = new AbstractTable<>(DBTables.ORG_OBJECT);
    final public static AbstractTable<Post>          POSTS           = new AbstractTable<>(DBTables.POST);
}
