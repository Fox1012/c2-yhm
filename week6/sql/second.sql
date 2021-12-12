create table  students(
                       SNO varchar(20),
                       Name varchar(10),
                       Age integer,
                       College varchar (30)
);

insert into students values ('s001','老大',20,'计算机学院');
insert into students values ('s002','老二',19,'计算机学院');
insert into students values ('s003','老三',18,'计算机学院');
insert into students values ('s004','老四',17,'计算机学院');


SELECT * from students;

delete from students where SNO='s004';

select * from students where SNO='s003';

update students set College='通信学院'  where SNO='s001';

