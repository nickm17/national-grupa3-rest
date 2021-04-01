
-- rulati aceste scripturi pe o schema noua pe serverul vostru local mysql
create schema new_schema; -- puteti face schema si direct din intellij , la schemas click dreapta si new schema

--deschideti o consola noua in care sa executati scripturile de creare tabele si insert data
-- verificati ca acea consola pe care o deschideti sa utilizeze schema dorita, in partea dreapta sus a consolei puteti alege schema
-- schimbati numele din url-ul bazei de date din application.properties cu numele schemei

create table department
(
    id int auto_increment
        primary key,
    city varchar(255) null,
    created_at datetime(6) null,
    modified_at datetime(6) null,
    name varchar(255) null
);

create table employee
(
    id int auto_increment
        primary key,
    comm int null,
    created_at datetime(6) null,
    hiredate date null,
    job varchar(255) null,
    mgr int null,
    modified_at datetime(6) null,
    name varchar(255) null,
    salary int null,
    department_id int null,
    constraint FKbejtwvg9bxus2mffsm3swj3u9
        foreign key (department_id) references jpa_ex2.department (id)
);

create table library
(
    id int auto_increment
        primary key,
    name varchar(255) null
);

create table book
(
    id int auto_increment
        primary key,
    name varchar(255) null,
    library_id int null,
    constraint FKaojxagnfmppd09k35kye5eph5
        foreign key (library_id) references jpa_ex2.library (id)
);

INSERT INTO department (id, name, city, modified_at, created_at) VALUES (10, 'WORK', 'NEW YORK', '2021-03-08 19:33:41', '2021-03-08 19:33:41');
INSERT INTO department (id, name, city, modified_at, created_at) VALUES (20, 'RESEARCH', 'DALLAS', '2021-03-08 19:33:41', '2021-03-08 19:33:41');
INSERT INTO department (id, name, city, modified_at, created_at) VALUES (30, 'SALES', 'CHICAGO', '2021-03-08 19:33:41', '2021-03-08 19:33:41');
INSERT INTO department (id, name, city, modified_at, created_at) VALUES (40, 'OPERATIONS', 'BOSTON', '2021-03-08 19:33:41', '2021-03-08 19:33:41');



INSERT INTO employee (id, name, job, mgr, hiredate, salary, comm, department_id, created_at, modified_at) VALUES (7788, 'Ion2', 'PROGRAMATOR2', 6676, '1982-12-09', 6900, 12, 20, '2021-03-08 19:32:19', '2021-03-24 15:11:00');
INSERT INTO employee (id, name, job, mgr, hiredate, salary, comm, department_id, created_at, modified_at) VALUES (7839, 'KING', 'PRESIDENT', null, '1981-11-17', 5000, null, 10, '2021-03-08 19:32:19', '2021-03-08 19:32:19');
INSERT INTO employee (id, name, job, mgr, hiredate, salary, comm, department_id, created_at, modified_at) VALUES (7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08', 1500, 0, 30, '2021-03-08 19:32:19', '2021-03-08 19:32:19');
INSERT INTO employee (id, name, job, mgr, hiredate, salary, comm, department_id, created_at, modified_at) VALUES (7876, 'ADAMS', 'CLERK', 7788, '1983-01-12', 1265, 190, 20, '2021-03-08 19:32:19', '2021-03-08 19:32:19');
INSERT INTO employee (id, name, job, mgr, hiredate, salary, comm, department_id, created_at, modified_at) VALUES (7900, 'JAMES', 'CLERK', 7698, '1981-12-03', 950, null, 30, '2021-03-08 19:32:19', '2021-03-08 19:32:19');
INSERT INTO employee (id, name, job, mgr, hiredate, salary, comm, department_id, created_at, modified_at) VALUES (7902, 'FORD', 'ANALYST', 7566, '1981-12-03', 3450, 518, 20, '2021-03-08 19:32:19', '2021-03-08 19:32:19');
INSERT INTO employee (id, name, job, mgr, hiredate, salary, comm, department_id, created_at, modified_at) VALUES (7934, 'MILLER', 'CLERK', 7782, '1982-01-23', 1300, null, null, '2021-03-08 19:32:19', '2021-03-08 19:32:19');
INSERT INTO employee (id, name, job, mgr, hiredate, salary, comm, department_id, created_at, modified_at) VALUES (7935, 'MILLER', 'CLERK', 7782, '1982-01-23', 1300, null, 10, '2021-03-08 19:32:19', '2021-03-08 19:32:19');
INSERT INTO employee (id, name, job, mgr, hiredate, salary, comm, department_id, created_at, modified_at) VALUES (123456800, 'sdsadas', 'sdasd', 7566, null, 1233, null, null, '2021-03-08 19:32:19', '2021-03-08 19:32:19');
INSERT INTO employee (id, name, job, mgr, hiredate, salary, comm, department_id, created_at, modified_at) VALUES (123456801, 'SCOTT2', 'ANALYST', 7566, '2021-03-08', 5000, 500, 20, null, null);


INSERT INTO library (id, name) VALUES (1, 'Java');
INSERT INTO library (id, name) VALUES (4, 'Java2');


INSERT INTO book (id, name, library_id) VALUES (1, 'Head First Java', 1);
INSERT INTO book (id, name, library_id) VALUES (2, 'Java for dummies', 1);
INSERT INTO book (id, name, library_id) VALUES (7, 'Head First Java', 4);
INSERT INTO book (id, name, library_id) VALUES (8, 'Java for dummies', 4);
