

-- Как выбрать записи с нечётными Id?
select * from women where women_id % 2 !=0;


-- Как найти дубли в поле email?
alter table women add column email char(100);

update women set women.email = 'aa@tut.by' where women_id =1;
update women set women.email = 'ab@tut.by' where women_id =2;
update women set women.email = 'aa@tut.by' where women_id =3;
update women set women.email = 'bb@tut.by' where women_id =4;
select email,count(email) from women group by email having count(women.email) > 1;



-- При выборке из таблицы прибавьте к дате 1 день

alter table women add column women_date date;
update women set women_date = '2020-03-17' where women_id = 1;
update women set women_date = '2002-02-15' where women_id = 2;
update women set women_date = '2009-06-11' where women_id = 3;
update women set women_date = '2001-07-25' where women_id = 4;

insert into women(women_name, age, city_id,email,women_date) values ('Katya','21','2',
                                                                     'ee@tut.by', '2008-08-08');

select DATE_ADD(women.women_date,interval 1 day) from women where women_id = 1;


-- Выберите только уникальные имена
select distinct women_name from women;


-- Найдите в таблице среднюю зарплату работников
alter table women add column salary int;

update women set salary = '1000' where women_id = 1;
update women set salary = '1500' where women_id = 2;
update women set salary = '2000' where women_id = 3;
update women set salary = '2500' where women_id = 4;
update women set salary = '3000' where women_id = 6;

select avg(salary) from women;


-- А теперь получите список сотрудников с зарплатой выше средней

select * FROM women WHERE salary > (select AVG(salary) from women);



-- Даны таблицы women и departments. Найдите все департаменты без единого сотрудника
create table departments (
                             department_id int not null auto_increment unique primary key,
                             department_name char(100) unique,
                             worker_name char(100)
);

alter table women add column department_id int;

insert into departments(department_name, worker_name) values ('Бюстхалтерия','Иванова Даша');
insert into departments(department_name, worker_name) values ('Производство','Петрова Маша');
insert into departments(department_name, worker_name) values ('Водители',null);

alter table women add constraint women_department_id_fk foreign key (department_id)
    references departments(department_id);


update women set department_id = 1 where women_id = 1;
update women set department_id = 2 where women_id = 3;
update women set department_id = 1 where women_id = 5;


-- 1й вариант решения с right join
SELECT department_name
FROM women w
         RIGHT JOIN departments d ON (w.department_id = d.department_id)
WHERE worker_name IS NULL;

-- 2й вариант без join
select department_name from departments where worker_name is null;



-- Замените в таблице зарплату работника на 15000, если она равна 1500, и на 1000 в остальных случаях
update women set salary =
                     case
                         when salary = 1500 then 15000
                         else 1000
                         end;


-- При выборке из таблицы пользователей создайте поле, которое будет включать в себя и имена, и зарплату
select concat(women_name,salary) as new_name_salary from women;


-- Переименуйте таблицу
alter table women rename superwomen;