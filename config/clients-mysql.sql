DROP SCHEMA IF EXISTS clients;
CREATE SCHEMA clients;
CREATE USER if not exists 'adm'@'localhost' IDENTIFIED BY 'adm';
GRANT ALL PRIVILEGES ON clients.* TO 'adm'@'localhost';
USE clients
CREATE TABLE clients (
    id integer auto_increment,
    login VARCHAR(20) unique,
    password VARCHAR(120),
    prenom VARCHAR(10) unique,
    age integer,
    PRIMARY KEY(id)
);
insert into clients (login,password,prenom,age) values ('jean','ccc','Jean',25);
insert into clients (login,password,prenom,age) values ('pier','aaa','Pierre',17);
insert into clients (login,password,prenom,age) values ('soph','bbb','Sophie',18 );
select * from clients;
