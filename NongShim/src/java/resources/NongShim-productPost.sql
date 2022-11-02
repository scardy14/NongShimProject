drop sequence postNo_seq

create table NongShim_productPost(
postNo number primary key,
title varchar2(100) not null,
content clob not null,
id varchar2(100) not null,
hits number default 0 not null,
nickname varchar2(100) not null,
comments varchar2(100) not null,
registerDate date not null,
category varchar2(100) not null,
status varchar2(100)not null,
CONSTRAINT fk_pp FOREIGN KEY(id) REFERENCES NongShim_Member(id)
);


create sequence postNo_seq;

insert into NongShim_productPost
values (postNo_seq.nextval, '초록빛깔 상추', '신선하고 맛있습니다','java',default,'민석짱','코멘트부분',sysdate,'야채','status');
insert into NongShim_productPost
values (postNo_seq.nextval, '사과사과', '달콤하고 맛있습니다','spring',default,'민석짱2','코멘트부분',sysdate,'과일','status');
insert into NongShim_productPost 
values (postNo_seq.nextval, '맛있는 햅쌀', '꼬들꼬들합니다','jdbc',default,'민석짱3','코멘트부분',sysdate,'곡물','status');



select * from NongShim_productpost

