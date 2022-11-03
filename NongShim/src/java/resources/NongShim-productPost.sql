drop sequence postNo_seq
drop table NongShim_product_Post
drop table productpost1
pst_no,title,content,id,hits,nickname,comments,register,category,status,product_name,product_point
-- 2. Product Post 상품 게시판 글
create table NongShim_product_Post(
post_No number primary key,
title varchar2(100) not null,
content clob not null,
id varchar2(100) not null,
hits number default 0 not null,
nickname varchar2(100) not null,
comments varchar2(100) not null,
register_Date date not null,
category varchar2(100) not null,
status varchar2(100)not null,
product_Name varchar2(100) not null,
product_Point number not null,
duration date not null,
min_Customer number not null,
max_Customer number not null,
CONSTRAINT fk_pp FOREIGN KEY(id) REFERENCES NongShim_Member(id)
);

INSERT INTO NongShim_product_Post(post_No, title, content, id, hits, nickname,comments,category,status,product_Name,product_Point,duration,min_Customer,max_Customer)
VALUES (select title, content, id, hits, nickname,comments,category,status,product_Name,product_Point,duration,min_Customer,max_Customer from NongShim_product_Post)
-- 2.1 시퀀스 생성
create sequence postNo_seq;

-- 2.2 product post data 입력 
insert into NongShim_product_Post
values (postNo_seq.nextval, '초록빛깔 상추', '신선하고 맛있습니다','java',default,'민석짱','코멘트부분',sysdate,'야채','status','상추',50,sysdate,5,10);
insert into NongShim_product_Post
values (postNo_seq.nextval, '사과사과', '달콤하고 맛있습니다','spring',default,'민석짱2','코멘트부분',sysdate,'과일','사과',200,sysdate,10,30);
insert into NongShim_product_Post 
values (postNo_seq.nextval, '맛있는 햅쌀', '꼬들꼬들합니다','jdbc',default,'민석짱3','코멘트부분',sysdate,'곡물','status','쌀',150,sysdate,50,100);

commit





-- 2.3 product post 

select * from NongShim_product_Post

SELECT rownum from NongShim_product_Post

SELECT post_No, title, hits, register_Date, category, nickname, status
  FROM (SELECT rownum, post_No, title, hits, TO_CHAR(register_Date, 'YYYY-MM-DD') AS register_Date, category, nickname, status
  		  FROM NongShim_product_post)
 WHERE rownum BETWEEN 5 AND 10
  

select * from NongShim_product_post
<<<<<<< HEAD
>>>>>>> refs/heads/main

-- 2.4 product post data 입력 (write)									
insert into NongShim_product_Post 
values (postNo_seq.nextval, '탐스런 과일', '크고 달아요','java',default,'짱아','맛있네요',sysdate,'과일','status','청포도',100,sysdate,10,30);
=======
>>>>>>> refs/heads/main





--아래거가 완성본
SELECT post_No, title, hits, register_Date, category, nickname, status
  FROM (SELECT row_number() over(ORDER BY post_No DESC) AS rnum,
  post_No, title, hits, TO_CHAR(register_Date, 'YYYY-MM-DD') AS register_Date, category, nickname, status 
  		  FROM NongShim_product_post)
  WHERE rnum BETWEEN 1 AND 5
  
  SELECT ROW_NUMBER() OVER(ORDER BY post_No) AS rnum, category FROM NongShim_product_post

