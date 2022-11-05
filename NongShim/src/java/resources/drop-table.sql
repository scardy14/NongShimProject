-- 전체테이블 drop 

-- 회원정보
drop table NongShim_Member

-- 상품 게시판
drop table NongShim_product_Post

-- 상품 게시판 댓글
drop table NongShim_productPostComments



-- 테이블 삭제 에러시


--1) 참조때문에 회원탈퇴 아이디=삭제를 실행하면 위배 문구가 떴음

--2)일단 테이블을 다시 삭제해봄
--제약 조건 걸려있는 테이블 삭제 방법? -> drop table 뒤에 cascade constraints 추가

DROP TABLE NongShim_product_Post cascade constraints;
DROP TABLE NongShim_productpost	cascade constraints;
DROP TABLE NongShimmember	cascade constraints;
DROP TABLE NongShimproductinfo	cascade constraints;


--그후 참조하는 테이블에는 제약조건 뒤에 ON DELETE CASCADE를 추가해보니 됨

--ex) CONSTRAINT fk_pp FOREIGN KEY(id) REFERENCES NongShim_Member(id) ON DELETE CASCADE   <-- 이 부분

-- 확실하지는 않음 일단 재명 컴퓨터에서는 그렇게 하니 돌아가긴했음
-- 다른 방법이 있으면 코멘트 부탁

