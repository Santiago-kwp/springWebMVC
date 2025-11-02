use sqldb;

drop table if exists tbl_todo;

create table tbl_todo (
    tno int auto_increment primary key,
    title varchar(100) not null,
    dueDate date not null,
    writer varchar(50) not null,
    finished tinyint default 0

);

select * from tbl_todo;


INSERT INTO tbl_todo (title, dueDate, writer, finished)
SELECT CONCAT(title, ' 복사본'), DATE_ADD(dueDate, INTERVAL 1 DAY), writer, finished FROM tbl_todo;

-- 결과 확인
SELECT * FROM tbl_todo order by tno desc;