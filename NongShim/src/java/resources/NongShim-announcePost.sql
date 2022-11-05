create table NongShim_Announce_Post(
post_No number primary key,
id VARCHAR2(100) NOT NULL,
title varchar2(100) not null,
content clob not null,
hits number default 0 not null,
nickname varchar2(100) DEFAULT '운영자' not null,
register_Date date not null,
CONSTRAINT fk_anounce_post FOREIGN KEY(id) REFERENCES NongShim_Member(id)
);

CREATE SEQUENCE announce_seq;
INSERT INTO NongShim_Announce_Post VALUES (announce_seq.nextval, 'java', '테스트공지입니다', '이 공지는 테스트공지입니다.', DEFAULT, DEFAULT, sysdate);

SELECT post_No, title, hits, nickname, register_Date
  FROM ( SELECT ROW_NUMBER() OVER(ORDER BY post_No DESC) AS rnum, post_No, title, hits, nickname, TO_CHAR(register_Date, 'YYYY-MM-DD') AS register_Date
  		   FROM NongShim_Announce_Post)
  WHERE rnum BETWEEN 1 AND 5
  
  
  drop table NongShim_Announce_Post;
  		   
  		 