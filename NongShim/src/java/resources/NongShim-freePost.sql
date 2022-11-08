CREATE SEQUENCE free_seq;
INSERT INTO NongShim_free_Post VALUES (free_seq.nextval, 'jdbc', '과일조아', '여기 농산물 신선해여?', '오픈한지 얼마 안된곳이라 조금 걱정입니다 흠', DEFAULT, sysdate);

SELECT post_No, title, hits, nickname, register_Date
  FROM ( SELECT ROW_NUMBER() OVER(ORDER BY post_No DESC) AS rnum, post_No, title, hits, nickname, TO_CHAR(register_Date, 'YYYY-MM-DD') AS register_Date
  		   FROM NongShim_free_Post)
  WHERE rnum BETWEEN 1 AND 5
  
    drop table NongShim_free_Post;
ALTER TABLE NongShim_free_Post DROP CONSTRAINT fk_free_post;
   