
-- Создаем таблицу проектов и вносим данные
create table projects ( id int unique
                            not null primary key,
                        project_name char(100),
                        project_time char(100),
                        complexity char(100),
                        projectexecutor_name char(100),
                        projectexecutor_surname char(100),
                        projectexecutor_otchestvo char(100)
);

insert into projects(id,project_name, project_time, complexity, projectexecutor_name,projectexecutor_surname,
                     projectexecutor_otchestvo)
values (1,'проект 1','2 дня','сложный','Сергей', 'Смирнов',
        'Сергеевич');

insert into projects(id,project_name, project_time, complexity, projectexecutor_name,projectexecutor_surname,
                     projectexecutor_otchestvo)
values (2,'проект 2','1 дня','легкий','Федоров',
        'Сергей','Юрьевич');



-- Создаем таблицу taskexecutor и заполняем ФИО исполнителей.
create table taskexecutor (
                              taskexecutor_id int not null
                                  auto_increment primary key,
                              taskexecutor_fio char(200));

alter table taskexecutor drop column  taskexecutor_fio;

alter table taskexecutor add column first_name char(50);
alter table taskexecutor add column second_name char(50);
alter table taskexecutor add column otchestvo char(50);

update taskexecutor set first_name = 'Петров', second_name='Петя ', otchestvo = 'Сергеевич'
where taskexecutor_id = 1;

update taskexecutor set first_name = 'Смирнов', second_name='Сергей ', otchestvo = 'Сергеевич'
where taskexecutor_id = 2;

update taskexecutor set first_name = 'Федоров', second_name='Сергей ', otchestvo = 'Юрьевич'
where taskexecutor_id = 3;



-- Создаем таблицу tasks,добавляем внешние ключи и заполняем
create table tasks (
                       task_name char(100) not null unique
                           primary key,
                       execution_time char(50),
                       task_price int,
                       task_executor_id int,
                       project_id int
);

alter table tasks add constraint tasks_taskexecutor_id_fk foreign key (task_executor_id)
    references taskexecutor(taskexecutor_id);

alter table tasks add constraint tasks_projects_id_fk foreign key (project_id) references projects(id);

insert into tasks(task_name,execution_time,task_price, task_executor_id, project_id)
values ('задача 1','4 часа','2000', '1',
        '1');

insert into tasks(task_name,execution_time,task_price, task_executor_id, project_id)
values ('задача 2','8 часов','2500', '2',
        '1');

insert into tasks(task_name,execution_time,task_price, task_executor_id, project_id)
values ('задача 3','4 часа','1000', '2',
        '1');

insert into tasks(task_name,execution_time,task_price, task_executor_id, project_id)
values ('задача 4','5 часов','3000', '3',
        '2');

insert into tasks(task_name,execution_time,task_price, task_executor_id, project_id)
values ('задача 5','3 часа','500', '1',
        '2');





-- Основные операции для задачи
select task_name from tasks join projects on tasks.project_id = projects.id
where projects.complexity = 'сложный';

select project_name,sum(task_price) from tasks join projects on tasks.project_id = projects.id
group by project_name;

select project_name,sum(task_price) from tasks join projects on tasks.project_id = projects.id
group by project_name having sum(task_price) > 4000;

update projects set project_name = 'Проект 25' where project_name = 'Проект 1';