create table  cqupt_student(
                             student_id varchar(10),
                             name varchar(20),
                             sex varchar(2),
                             age integer,
                             Fee DECIMAL(10,2),
                             address varchar(50),
                             memo varchar(300)
);
create table CourseAa(
                       Aa1 varchar(20),
                       Aa2 integer,
                       Aa3 DECIMAL(10)
);
create table Choosebb(
                       Bb1 varchar(30),
                       Bb2 integer,
                       Bb3 DECIMAL(6)
);
alter table Choosebb add Bb4 varchar(20) not null DEFAULT "系统测试值";

alter table Choosebb add Bb5 varchar(20) not null;
alter table Choosebb add primary key (Bb5);

create view View_Choosebb(View_bb1,View_bb2,view_bb3) as select Choosebb.Bb1,Choosebb.Bb2,Choosebb.Bb3
                                                         from Choosebb;

drop view View_Choosebb;

create index index_bb2 on Choosebb(Bb2 asc);
create index index_bb4 on Choosebb(Bb4 desc);

drop index index_bb2 on Choosebb;

create table test(
                   name varchar(20),
                   Age integer,
                   Score numeric(10,2),
                   Address varchar(60)
);

insert into test values ('赵三',20,580.00,'重邮宿舍12-3-5');
insert into test values ('钱二',19,540.00,'南福苑5-2-9');
insert into test values ('孙三',21,555.50,'学生新区21-5-15');
insert into test values ('李四',22,505.00,'重邮宿舍8-6-22');
insert into test values ('周五',20,495.50,'学生新区23-4-8');
insert into test values ('吴六',19,435.00,'南福苑2-5-12');

create table test_temp(
                        Name varchar(20),
                        Age integer,
                        Score numeric(10,2),
                        Address varchar(60)
);

insert into test_temp values ('郑七',21,490.50,'重邮宿舍11-2-5');
insert into test_temp values ('张八',20,540.00,'南福苑3-3-3');
insert into test_temp values ('王九',10,515.00,'学生新区19-7-1');


INSERT INTO test(name, Age, Score, Address) select Name,Age,Score,Address from test_temp;

update test set Score=Score+5 where Age<20;
update test set Age=Age-1 where Address like '南福苑%';

delete from test where Age>=21 and Score>=500;
delete from test where Score<500 and Address like '重邮宿舍%';

create table Student(
                      SNO varchar(20),
                      Name varchar(10),
                      Age integer,
                      College varchar(30)
);

create table course(
                     CourseId varchar(15),
                     CourseName varchar(30),
                     CourseBeforeId varchar(15)
);

create table choose(
                     SNO varchar(20),
                     CourseId varchar(15),
                     Score DECIMAL(5,2)
);

insert into Student values('S00001','张三',20,'计算机学院');
insert into Student values('S00002','李四',19,'通信学院');
insert into Student values('S00003','王五',21,'计算机学院');

insert into course values ('C1','计算机引论',null);
insert into course values ('C2','C语言','C1');
insert into course values ('C3','数据结构','C2');

insert into choose values ('S00001','C1',95);
insert into choose values ('S00001','C2',80);
insert into choose values ('S00001','C3',84);
insert into choose values ('S00002','C1',80);
insert into choose values ('S00002','C2',85);
insert into choose values ('S00003','C1',78);
insert into choose values ('S00003','C3',70);

select SNO,Name from Student where College='计算机学院';
select  * from Student where Age between 20 and 23;
select count(*) from Student;
select max(Score) from choose where CourseId='C1';
select min(Score) from choose where CourseId='C1';
select sum(Score) from choose where CourseId='C1';
select avg(Score) from choose where CourseId='C1';

select CourseId,CourseName from course where CourseBeforeId is NULL;

select student.SNO,student.Name,choose.CourseId,choose.Score from Student,choose where choose.SNO=Student.SNO;


select * from Student as S where exists (select * from Student where Student.College=S.College and Student.Name='张三');

select Student.SNO,Student.Name from Student  where Student.SNO in (select choose.SNO from choose where choose.Score<(select Score from choose where CourseId='C1'and choose.SNO in (select Student.SNO from Student where Name='张三')));

select SNO from Student union select SNO from choose where CourseId='C1' or CourseId='C3';

select SNO from Student union distinct select SNO from choose where CourseId='C1' or CourseId='C3';