-- Список организаций
DROP TABLE IF EXISTS Organization;
CREATE TABLE Organization (
    id            INTEGER   PRIMARY KEY AUTOINCREMENT,
    name          TEXT(100) NOT NULL,
    legal_address TEXT(200) NOT NULL,
    phone_num     TEXT(12)  NOT NULL
);
INSERT INTO Organization (name, legal_address, phone_num)
VALUES
       ('ООО "Рога и Копыта"', 'г.Серпухов, ул. Мира, д.42', '+79216666666'),
       ('ООО "Газпром"', 'г.Санкт-Петербург, Небоскреб', '+79317777777'),
       ('ООО "Мечты сбываются"', 'г.Москва, ул. Тверская, д.13', '+74951111111'),
       ('ООО "BMW"', 'г.Мюнхен, ул. Берлинская, д.13', '+74956666666');

-- Список объектов организаций
DROP TABLE IF EXISTS Object;
CREATE TABLE Object (
    id               INTEGER PRIMARY KEY AUTOINCREMENT,
    organization_id  INTEGER       NOT NULL,
    name             TEXT(100)     NOT NULL,
    address          TEXT(200)     NOT NULL,
    phone_num        TEXT(12)      NOT NULL,
    security_head_id INTEGER       NOT NULL,
    salary_ratio     NUMERIC(2, 1) NOT NULL DEFAULT 1.0 CHECK ( salary_ratio > 0.0 ),
    salary_type_id   INTEGER,

    FOREIGN KEY (organization_id)  REFERENCES Organization(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
    FOREIGN KEY (security_head_id) REFERENCES Employee (id),
    FOREIGN KEY (salary_type_id)   REFERENCES SalaryType(id)
);
INSERT INTO Object (organization_id, name, address, phone_num, security_head_id, salary_ratio, salary_type_id)
VALUES
(1, 'Бар', 'г.Вологда, ул. Воркутинская, д.17', '+79216666667', 1, 1.0, 1);

-- Список всех постов
DROP TABLE IF EXISTS Post;
CREATE TABLE Post (
    id                   INTEGER PRIMARY KEY AUTOINCREMENT,
    object_id            INTEGER   NOT NULL,
    name                 TEXT(100) NOT NULL,
    address              TEXT(200) NOT NULL,
    phone_num            TEXT(12)  NOT NULL,
    number               INTEGER,
    guards_changing_freq INTEGER, -- In totalHours
    surcharge            NUMERIC(10,2),
    checkage             NUMERIC(10,2),
    arrival_method_id    INTEGER,

    FOREIGN KEY (object_id)         REFERENCES Object (id),
    FOREIGN KEY (arrival_method_id) REFERENCES ArrivalMethod(id)
);
INSERT INTO Post (object_id, name, address, phone_num, number,
                  guards_changing_freq, surcharge, checkage, arrival_method_id)
VALUES
(1, 'Вход', 'г.Серпухов, ул. Мира, д.17', '+79216666667', 1, 12, 0.0, 0.0, 1);


-- Список всех сотрудников
DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee (
    id                       INTEGER PRIMARY KEY AUTOINCREMENT,
    second_name              TEXT(20),
    first_name               TEXT(20),
    middle_name              TEXT(20),
    phone_number             TEXT(12) UNIQUE,
    PSD_expiration_date      TEXT(8), -- Private Security Document
    training_expiration_date TEXT(8),
    is_reserved              INTEGER, -- BOOL
    mainPost_id              INTEGER,
    category_id              INTEGER,
    position_id              INTEGER,
    note                     TEXT(400),

    FOREIGN KEY (mainPost_id) REFERENCES Post(id),
    FOREIGN KEY (category_id) REFERENCES Category(id),
    FOREIGN KEY (position_id) REFERENCES Position(id)
);
INSERT INTO Employee (second_name, first_name, middle_name, phone_number, PSD_expiration_date,
                      training_expiration_date, is_reserved, mainPost_id, category_id, position_id, note)
VALUES ('Евсюков', 'Иван', 'Иванович', '+79992019890', '2019-12-01', '2019-12-01', 0, 1, 1, 1, 'Обычный человек'),
       ('Евсюков', 'Василий', 'Иванович', '+79992019891', '2019-11-01', '2019-11-01', 0, 1, 1, 3, 'Обычный человек'),
       ('Евсюкова', 'Мария', 'Иванова', '+79992019892', '2019-10-01', '2019-10-01', 0, 1, 1, 1, 'Обычный человек');

-- Категории сотрудников
DROP TABLE IF EXISTS Category;
CREATE TABLE Category (
    id   INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT(20) );
INSERT INTO Category (name) VALUES ('Оформленный'), ('Неоформленный'), ('С другого поста');

-- Должности сотрудников
DROP TABLE IF EXISTS Position;
CREATE TABLE Position (
                          id   INTEGER PRIMARY KEY AUTOINCREMENT,
                          name TEXT(20) );
INSERT INTO Position (name) VALUES ('Охранник'), ('Начальник охраны?'), ('Водитель-охранник');

-- Тип зарплаты
DROP TABLE IF EXISTS SalaryType;
CREATE TABLE SalaryType (
    id       INTEGER PRIMARY KEY AUTOINCREMENT,
    typename TEXT(20) );
INSERT INTO SalaryType (typename) VALUES ('Почасовая'), ('Дежурство');

-- Дежурства
DROP TABLE IF EXISTS Duty;
CREATE TABLE Duty (
    id             INTEGER PRIMARY KEY AUTOINCREMENT,
    security_id    INTEGER,
    post_id        INTEGER,
    date           TEXT(8),
    category_id    INTEGER,
    total_hours    INTEGER,
    is_holiday     INTEGER, -- BOOL
    night_hours    INTEGER,
    position_id    INTEGER,
    salary_type_id INTEGER,
    salary         REAL,

    FOREIGN KEY (security_id)    REFERENCES Employee (id),
    FOREIGN KEY (post_id)        REFERENCES Post(id),
    FOREIGN KEY (position_id)    REFERENCES Position(id),
    FOREIGN KEY (salary_type_id) REFERENCES SalaryType(id) );
INSERT INTO Duty (security_id, post_id, date, category_id, total_hours, is_holiday,
                  night_hours, position_id, salary_type_id, salary)
VALUES
(2, 1, '20190101', 1, 24, 0, 8, 1, 1, 3000.0);

-- Неявки
DROP TABLE IF EXISTS Absence;
CREATE TABLE Absence (
    id         INTEGER PRIMARY KEY AUTOINCREMENT,
    duty_id    INTEGER,
    reason_id  INTEGER,

    FOREIGN KEY (duty_id)   REFERENCES Duty(id),
    FOREIGN KEY (reason_id) REFERENCES AbsenceReason(id) );
INSERT INTO Absence (duty_id, reason_id)  VALUES (1, 3);

-- Причины неявки
DROP TABLE IF EXISTS AbsenceReason;
CREATE TABLE AbsenceReason (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    reason_name TEXT(30) );
INSERT INTO AbsenceReason (reason_name)
VALUES
       ('Отпуск'),
       ('Командировка'),
       ('Болезнь'),
       ('Невыясненные обстоятельства');

-- Зарплата
-- DROP TABLE IF EXISTS Salary;
-- CREATE TABLE Salary ()

-- Способ прибытия
DROP TABLE IF EXISTS ArrivalMethod;
CREATE TABLE ArrivalMethod (
    id            INTEGER PRIMARY KEY AUTOINCREMENT,
    driver_id     INTEGER,
    auto_type_id  INTEGER,
    auto_number   TEXT(9), -- 9?
    arriving_time TEXT(6),
    frequency     INTEGER,
    arrives_from   TEXT(200),
    FOREIGN KEY (auto_type_id) REFERENCES AutoType(id)
);
INSERT INTO ArrivalMethod (driver_id, auto_type_id, auto_number, arriving_time, frequency, arrives_from)
VALUES (2, 2, 'а777бв35', '07:00:00', 1, 'г.Серпухов, ул. Мира, д.1');

DROP TABLE IF EXISTS AutoType;
CREATE TABLE AutoType (
    id        INTEGER PRIMARY KEY AUTOINCREMENT,
    type_name TEXT(20)
);
INSERT INTO AutoType (type_name) VALUES ('Грузовой'), ('Легковой');
-- INSERT INTO Position (name) VALUES ('Охранник'), ('Начальник охраны?'), ('Водитель-охранник');


