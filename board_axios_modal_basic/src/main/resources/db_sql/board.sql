use sqldb;
CREATE TABLE test_board (
                       bno        INT AUTO_INCREMENT PRIMARY KEY,
                       title      VARCHAR(200)   NOT NULL,
                       content    TEXT           NOT NULL,
                       writer     VARCHAR(50)    NOT NULL,
                       reg_date   DATETIME       NOT NULL DEFAULT NOW(),
                       update_date DATETIME      NULL
);

insert into test_board (title, content, writer) values("첫제목", "내용", "글쓴이");
insert into test_board (title, content, writer) values("두번째 제목", "내용입니다.", "글쓴이22");

select * from test_board;
