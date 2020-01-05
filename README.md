# JSONSchmea-UI-Generation
JSONSchmea-UI-Generation

Used postgresql RDMS as backednd. Check app prop for database details. 

Create below tables in postgres database.

--Table 1
CREATE TABLE list(

   id serial PRIMARY KEY,

   name VARCHAR (50) UNIQUE NOT NULL

);

 
insert into list(id,name) values (1,'A1');

insert into list(id,name) values (2,'A2');

insert into list(id,name) values (3,'A3');

insert into list(id,name) values (4,'A4');

 
--Table 2
CREATE TABLE A(

   id serial PRIMARY KEY,

   a1 VARCHAR (50),

   a2 VARCHAR (50),

   a3 VARCHAR (50),

   list_id INTEGER REFERENCES list(id)

);
