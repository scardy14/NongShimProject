
create table NongShim_productPostComments(
id varchar2(100) not null,
post_No number not null,
comments_date date not null,
content clob not null,
category varchar2(100) not null,
constraint comments_id_fk foreign key(id) references NongShim_Member(id), 
constraint comments_post_no_fk foreign key(post_no) references NongShim_productPost(postno),
constraint comments_pk primary key(id, post_no,comments_date)
)
DROP TABLE NongShim_productPostComments;

select * from NONGSHIM_PRODUCTPOSTCOMMENTS 

insert into NONGSHIM_PRODUCTPOSTCOMMENTS 
values ('java','1',sysdate,'냠냠맛있어요','후기')