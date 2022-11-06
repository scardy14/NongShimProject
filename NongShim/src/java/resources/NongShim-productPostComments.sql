-- 4.1 게시판 댓글 
create table NongShim_productPostComments(
id varchar2(100) not null,
post_No number not null,
comments_date date not null,
content clob not null,
category varchar2(100) not null,
constraint comments_id_fk foreign key(id) references NongShim_Member(id), 
constraint comments_post_no_fk foreign key(post_no) references NongShim_product_Post(post_no),
constraint comments_pk primary key(id, post_no,comments_date)
)



DROP TABLE NongShim_productPostComments;

--4.2 게시판 댓글 데이터
insert into NONGSHIM_PRODUCTPOSTCOMMENTS values ('java',1,sysdate,'냠냠맛있어요','후기');
insert into NONGSHIM_PRODUCTPOSTCOMMENTS values ('spring',2,sysdate,'ww','후기');
insert into NONGSHIM_PRODUCTPOSTCOMMENTS values ('jdbc',3,sysdate,'gg','문의');

commit

--4.3 게시판 선택
select * from NONGSHIM_PRODUCTPOSTCOMMENTS 

--4.4 게시판 삭제
drop table NongShim_productPostComments

--걍 test 부분 -- 
select content, category,id,

---------------------공지사항게시판-------------------
ALTER TABLE NongShim_Announce_Post DROP CONSTRAINT fk_anounce_post;

ALTER TABLE NongShim_Announce_Post
ADD CONSTRAINT fk_anounce_post FOREIGN KEY(id)
REFERENCES NongShim_Member(id) ON DELETE CASCADE;
----------------------------------------------------
---------------------상품정포게시판-------------------
ALTER TABLE NongShim_product_Post DROP CONSTRAINT fk_pp;

ALTER TABLE NongShim_product_Post
ADD CONSTRAINT fk_pp FOREIGN KEY(id)
REFERENCES NongShim_Member(id) ON DELETE CASCADE;
----------------------------------------------------
---------------------상품정포게시판-------------------
ALTER TABLE like_product DROP CONSTRAINT id_fk;

ALTER TABLE like_product
ADD CONSTRAINT id_fk FOREIGN KEY(id)
REFERENCES NongShim_Member(id) ON DELETE CASCADE;

ALTER TABLE seller_ide DROP CONSTRAINT seller_id_fk;

ALTER TABLE seller_ide
ADD CONSTRAINT seller_id_fk FOREIGN KEY(id)
REFERENCES NongShim_Member(id) ON DELETE CASCADE;

ALTER TABLE buy_product_list DROP CONSTRAINT buy_product_id_fk;

ALTER TABLE buy_product_list
ADD CONSTRAINT buy_product_id_fk FOREIGN KEY(id)
REFERENCES NongShim_Member(id) ON DELETE CASCADE;

ALTER TABLE confirm_list DROP CONSTRAINT confirm_id_fk;

ALTER TABLE confirm_list
ADD CONSTRAINT confirm_id_fk FOREIGN KEY(id)
REFERENCES NongShim_Member(id) ON DELETE CASCADE;
----------------------------------------------------
---------------------상품정포댓글게시판-------------------
ALTER TABLE NongShim_productPostComments DROP CONSTRAINT comments_id_fk;

ALTER TABLE NongShim_productPostComments
ADD CONSTRAINT comments_id_fk FOREIGN KEY(id)
REFERENCES NongShim_Member(id) ON DELETE CASCADE;
----------------------------------------------------