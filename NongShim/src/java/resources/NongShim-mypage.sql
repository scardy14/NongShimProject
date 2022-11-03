-- 3. 좋아요 리스트
drop table like_product;

--							[내 테이블]
CREATE TABLE like_product(
  post_no NUMBER NOT NULL,
  id VARCHAR2(100) NOT NULL,
--						  [별명]									(내 테이블에서 fk로 지정할 컬럼)			[가져올 fk가 있는 테이블명](가져 올 fk의 컬럼)
  CONSTRAINT post_no_fk FOREIGN KEY (post_no) REFERENCES NongShim_product_Post(post_no),
--						  [별명]									(내 테이블에서 fk로 지정할 컬럼)			[가져올 fk가 있는 테이블명](가져 올 fk의 컬럼)
  CONSTRAINT id_fk FOREIGN KEY (id) REFERENCES NongShim_Member(id),
-- 							[별명]										 (내 테이블에서 만들 컬럼1,컬럼2)
  CONSTRAINT like_product_pk PRIMARY KEY (post_no, id)
)

-- 3.1 인증정보

drop table seller_ide

create table seller_ide(
	id varchar2(100) not null,
	company_register_num varchar2(100) not null,
	constraint seller_id_fk foreign key (id) references NongShim_Member(id)
)


-- 3.2 구매중인 목록: member(id), product_info(product_no) fk 및 pk, date도 pk

drop table buy_product_list

create table buy_product_list(
	id varchar2(100) not null,
	post_no number not null,
	ns_date date not null,
	status varchar2(100) not null,
	amount number not null,
	constraint buy_product_id_fk foreign key(id) references NongShim_Member(id),
	constraint buy_product_product_no_fk foreign key(post_no) references NongShim_product_Post(post_no),
	constraint buy_product_pk primary key (id,post_no,ns_date)
)

insert into buy_product_list values ('jdbc','10',sysdate,'발송중',15);
insert into buy_product_list values ('jdbc','11',sysdate,'발송완료',20);
insert into buy_product_list values ('java','12',sysdate,'발송중',15);
insert into buy_product_list values ('java','13',sysdate,'발송완료',20);
insert into buy_product_list values ('spring','14',sysdate,'발송중',15);
insert into buy_product_list values ('spring','15',sysdate,'발송완료',20);

commit

-- 3.3 판매중인 목록: member(id), product_info(product_no) fk 및 pk

drop table sell_product_list

create table sell_product_list(
	id varchar2(100) not null,
	post_no number not null,
	status varchar2(100) not null,
	constraint sell_product_id_fk foreign key(id) references NongShim_Member(id),
	constraint sell_product_product_no_fk foreign key(post_no) references NongShim_product_Post(post_no),
	constraint sell_product_pk primary key (id,post_no)
)

--3.4 구매 확인 리스트: member(id), product_info(product_no) fk 및 pk

drop table confirm_list

-- 추가할 메서드 id 말구 sysdate 추가하기
create table confirm_list(
	id varchar2(100) not null,
	post_no number not null,
	product_amount varchar2(100) not null,
	post_status varchar2(100) not null,
	constraint confirm_id_fk foreign key(id) references NongShim_Member(id),
	constraint confirm_product_fk foreign key(post_no) references NongShim_product_Post(post_no),
	constraint confirm_product_pk primary key(id,post_no)
)

insert into confirm_list values ('java','11','30','확인중');
insert into confirm_list values ('spring','12','30','확인중');
insert into confirm_list values ('jdbc','13','30','발송');
insert into confirm_list values ('jdbc','14','18','발송');
insert into confirm_list values ('spring','14','18','발송');

commit

insert into NongShim_product_Post
values (postNo_seq.nextval, '초록빛깔 샐러리', '신선하고 맛있습니다','spring',default,'민석짱','코멘트부분',sysdate,'야채','판매종료','딸기',100,sysdate+7,7,10);
insert into NongShim_product_Post
values (postNo_seq.nextval, '노란 배추', '신선하고 맛있습니다','jdbc',default,'민석짱','코멘트부분',sysdate,'야채','판매종료','딸기',178,sysdate+7,7,10);
insert into NongShim_product_Post
values (postNo_seq.nextval, '노란 배추', '신선하고 맛있습니다','jdbc',default,'jdk','jdk',sysdate,'야채','판매중','딸기',178,sysdate+7,7,10);


-- MySellProductList : 게시판 특정 상태인 판매목록(최신순)
select post_no,id,register_date,category,status,product_name,product_point,duration,min_customer,max_customer 
from NongShim_product_Post where status='판매중' AND  id='java' order by register_date desc;

-- MySellProductListCount : 게시판 특정 상태인 판매목록 수
select count(*)
from NongShim_product_Post where status='판매종료' AND  id='jdbc';

-- MySellProductListTotal : 게시판 내 판매 상품 전체 조회(최신순)
select post_no,id,register_date,category,status,product_name,product_point,duration,min_customer,max_customer 
from NongShim_product_Post where id='java' order by register_date desc;

--findCustomerConfirmListbyidandpostno() : 매칭 고객 정보 테이블의 발송 여부 컬럼의 데이터가 '발송'이 이면
select post_status from confirm_list where id='jdbc'and post_no='13';

-- ChangeBuyState() : 위의 메서드로 true를 반환 받으면 구매목록 리스트의 상태를 '발송완료'로 바꿔줌
select * from buy_product_list where id='spring' and post_no='14';
update buy_product_list set status='발송완료' where id='jdbc' and post_no='10';

-- StatusUpdatebyDuration() : post_product 테이블의 duration과 오늘 날짜를 비교하였을 때, 
-- 											   조회 되는 데이터가 있으면 이 데이터들의 status는 '판매종료'로 업데이트
select * from NongShim_product_Post where duration <= sysdate;
select * from NongShim_product_Post
select * from NongShim_product_Post where nickname='jdk';
update NongShim_product_Post set status='판매종료' where duration <= sysdate;

-- MyBuyProductList() : 특정 상태인 구매목록(최신순)

