use sqldb;

drop table if exists board;
create table board

(
    bno        int auto_increment
        primary key,
    title      varchar(500)                          not null,
    content    varchar(2000)                         not null,
    writer     varchar(100)                          not null,
    regDate    timestamp default current_timestamp() null,
    updateDate timestamp default current_timestamp() null
);

insert into board(title,content,writer) values ("boardTest","boardContent","user00");

select * from board order by bno desc;

select count(*) from board;


create table reply (
    rno int auto_increment primary key,
    bno int not null,
    replyText varchar(2000) not null,
    replyer varchar(100) not null,
    regDate timestamp default current_timestamp() null,
    updateDate timestamp default current_timestamp() null,
    constraint fk_reply_board foreign key (bno) references board(bno)
    );


insert into reply(bno, replyText,replyer) values(1525, '1526번 댓글', 'sym');


select * from reply;

delete from reply where rno = 40;

# 10000건 더미데이터 입력
insert into board(title,content,writer)
select title,content,writer from board;

select count(*) from board;