-- 3. 좋아요 리스트
drop table like_product;

CREATE TABLE like_product(
  post_no NUMBER NOT NULL,
  id VARCHAR2(100) NOT NULL,
   CONSTRAINT post_no_fk FOREIGN KEY (post_no) REFERENCES NongShim_productPost(post_no),
    CONSTRAINT id_fk FOREIGN KEY (id) REFERENCES NongShim_Member(id),
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
	constraint buy_product_product_no_fk foreign key(post_no) references NongShim_productPost(post_no),
	constraint buy_product_pk primary key (id,post_no,ns_date)
)

-- 3.3 판매중인 목록: member(id), product_info(product_no) fk 및 pk

drop table sell_product_list

create table sell_product_list(
	id varchar2(100) not null,
	post_no number not null,
	status varchar2(100) not null,
	constraint sell_product_id_fk foreign key(id) references NongShim_Member(id),
	constraint sell_product_product_no_fk foreign key(post_no) references NongShim_productPost(post_no),
	constraint sell_product_pk primary key (id,post_no)
)

--3.4 구매 확인 리스트: member(id), product_info(product_no) fk 및 pk

drop table confirm_list

create table confirm_list(
	id varchar2(100) not null,
	post_no number not null,
	product_amount varchar2(100) not null,
	post_status varchar2(100) not null,
	constraint confirm_id_fk foreign key(id) references NongShim_Member(id),
	constraint confirm_product_fk foreign key(post_no) references NongShim_productPost(post_no),
	constraint confirm_product_pk primary key(id,post_no)
)