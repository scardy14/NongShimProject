-- 4.1 게시판 댓글 
create table NongShim_productPostComments(
id varchar2(100) not null,
post_No number not null,
comments_date date not null,
content clob not null,
category varchar2(100) not null,
constraint comments_id_fk foreign key(id) references NongShim_Member(id), 
constraint comments_post_no_fk foreign key(post_no) references NongShim_productPost(post_no),
constraint comments_pk primary key(id, post_no,comments_date)
)

--4.2 게시판 댓글 데이터
insert into NONGSHIM_PRODUCTPOSTCOMMENTS values ('java','1',sysdate,'냠냠맛있어요','후기');
insert into NONGSHIM_PRODUCTPOSTCOMMENTS values ('spring','2',sysdate,'ww','후기');
insert into NONGSHIM_PRODUCTPOSTCOMMENTS values ('jdbc','3',sysdate,'gg','후기');

commit

--4.3 게시판 선택
select * from NONGSHIM_PRODUCTPOSTCOMMENTS 

--4.4 게시판 삭제
drop table NongShim_productPostComments