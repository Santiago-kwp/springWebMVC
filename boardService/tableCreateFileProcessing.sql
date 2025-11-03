use sqldb;

drop table if exists board;

create table board(
                      bno bigint auto_increment primary key ,
                      title varchar(30) not null,
                      writer varchar(30) not null,
                      content text null ,
                      created_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      updated_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                      password varchar(20) not null ,
                      hits bigint not null ,
                      userId varchar(20) null,
                      file_path VARCHAR(255) NULL,          -- 파일 경로 추가
                      original_file_name VARCHAR(100) NULL  -- 원본 파일명 추가
);

ALTER TABLE board alter column hits set default 0;

-- 1. 기존 BLOB 컬럼 제거
ALTER TABLE board DROP COLUMN file;


select * from board;
